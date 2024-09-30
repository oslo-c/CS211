// You need to implement this

import java.awt.*;

public class Bear extends Critter {
    private boolean polar;
    private int frontSlash = 0;
    
    public Bear(boolean polar) {
        this.polar = polar;
    }
    
    public Critter.Action getMove(CritterInfo info) {

        frontSlash++;
        if (info.frontThreat()) { // if enemy in front, infect
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) { // else if possible, hop 
            return Action.HOP;
        }
        return Action.LEFT; //else turn left
    }

    public Color getColor() {
        if (polar) {
            return Color.WHITE;
        }
        return Color.BLACK;
    }

    public String toString() {
        if (frontSlash % 2 == 0) { // Alternates on turns
            return "/";
        }
        return "\\";
    }
}
