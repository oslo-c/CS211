/**
 *
 * @author zubinwang
 */
import java.awt.*;

public class Lion extends Critter {
    Color colors[] = {Color.RED, Color.GREEN, Color.BLUE};
    Color color;
    int index;
    int count = -1; //Magic number to solve the initialization fencepost

    public Lion() { //Initializes a lion instance 
        index = (int) Math.round(Math.random() * 2);
        color = getColor(); 
    }
    
    public Action getMove(CritterInfo info) {
        if (info.frontThreat()) { // Infect if enemy in front
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) { // Otherwise If wall in front or to the right, turn left
            return Action.LEFT;
        } else if (info.getFront() == Neighbor.SAME) { // Otherwise If lion in front, turn right
            return Action.RIGHT;
        }
        return Action.HOP; // Otherwise, hop
    }

    public Color getColor() {
        //Randomly selects a color from the list colors[]
        if (count < 3) {
            count++;
            return colors[index];
        }
        count = 0;
        index = (int) Math.round(Math.random() * 2);

        //Included for quick testing -- because it pulls a random color from the list, many times it pulls the same color as before.
        //System.out.println("switch");
        return getColor();
    }

    public String toString() {
        System.out.println(index);
        return "L";
    }
}

