import java.awt.*;

public class Giant extends Critter {
    String[] phrases = {"fee", "fie", "foe", "fum"};
    int displayCount = 0; // Counts steps
    int phrase = 0; // Used as index to return current phrase


    // public Giant() {
    // }

    public Action getMove(CritterInfo info) {
        if (displayCount < 5) {
            displayCount++; // Increment on every step
        } else if (phrase < 3) {
            displayCount = 0;
            phrase++;   // Increment on sixth step
        } else { // Reset counters
            displayCount = 0;
            phrase = 0;
        }
        if (info.frontThreat()) { // If enemy in front, Infect
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) { // Else if possible, hop
            return Action.HOP;
        }
        return Action.RIGHT; // Else turn right
    }

    public Color getColor() {
        return Color.GRAY;
    }

    public String toString() {
        return phrases[phrase];
    }    
}
