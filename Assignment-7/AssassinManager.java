// CS211 HW 7
// Ethan Hamilton

// This is the object manager for the assassin game. It generates seperate linked lists to represent the kill ring and the graveyard.
// It also contains methods to print the current state of the game, check the existence/status of a player, check if the game is over,
// and to kill a player.

import java.util.*;

public class AssassinManager {
    // the head of the kill ring linked list
    private AssassinNode killRingHead = null;

    // the head of the grave yard linked list
    private AssassinNode graveYardHead = null;

    public AssassinManager(List<String> names) { // Constructor that builds the kill ring from input names, keeping the same order as the input list
        killRingHead = new AssassinNode(names.get(0), null);
        AssassinNode current = killRingHead;
        for (int i = names.size() - 1; i > 0; i--) {
            AssassinNode a = new AssassinNode(names.get(i), current);
            current = a;
        }
        killRingHead.next = current;
    }

    public void printKillRing() { // Prints the current state of the kill ring
        AssassinNode current = killRingHead;
        while (current.next != killRingHead) {
            System.out.println(current.name + " is stalking " + current.next.name);
            current = current.next;
        }
        System.out.println(current.name + " is stalking " + killRingHead.name);
    }

    public void printGraveyard() { // Prints the current state of the graveyard
        AssassinNode current = graveYardHead;
        while (current != null) {
            System.out.println(current.name + " was killed by " + current.killer);
            current = current.next;
        }
    }

    public boolean killRingContains(String name) { // Checks if a player is in the kill ring
        AssassinNode current = killRingHead;
        while (current.name != name && current.next != killRingHead) {
            if (current.name.equalsIgnoreCase(name)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean graveyardContains(String name) { // Checks if a player is in the graveyard
        AssassinNode current = graveYardHead;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean gameOver() { // Checks if the game is over
        return killRingHead.next == killRingHead;
    }

    public String winner() { // Returns the name of the winner if the game is over
        if (gameOver()) {
            return killRingHead.name;
        }
        return null;
    }

    public void kill(String name) { // Kills a player and moves them to the graveyard, reassigning the victim's target to the victim's killer
        AssassinNode victim = killRingHead.next;
        AssassinNode previous = killRingHead;
        while (!victim.name.equalsIgnoreCase(name)) {
            previous = victim;
            victim = victim.next;
        }
        if (victim == killRingHead) {
            killRingHead = previous;
        }

        if (graveYardHead == null) {
            graveYardHead = new AssassinNode(victim.name, null);
            graveYardHead.killer = previous.name;
        } else {
            AssassinNode currentDead = graveYardHead;
            while (currentDead.next != null) {
                currentDead = currentDead.next;
            }
            currentDead.next = new AssassinNode(victim.name, null);
            currentDead.next.killer = previous.name;
        }

        previous.next = victim.next;
    }
}
