// CS 211 HW 4
// Sierpinski Carpet
// Ethan Hamilton

// Draw the Sierpinski carpet
import java.awt.Color;
import java.awt.Graphics;

public class SierpinskiCarpet {
    public static void main(String[] args) {
        SierpinskiCarpet t = new SierpinskiCarpet(800, 800);
        t.draw(4);
    }

    private Graphics g;
    private int totalWidth, totalHeight;

    public SierpinskiCarpet(int totalWidth, int totalHeight) {
        this.totalWidth = totalWidth;
        this.totalHeight = totalHeight;

        DrawingPanel panel = new DrawingPanel(totalWidth, totalHeight);
        g = panel.getGraphics();
        g.setColor(Color.BLACK);
    }

    public void draw(int level) {
        drawHelper(level, 0, 0, totalWidth, totalHeight);
    }

    // Draws the Sierpinski carpet exclusively using recursion
    // I worked this problem many different ways, attempting to mitigate the apparent redundancy of the recursive calls,
    // however, I was unable to work out a solution to find the coordinates of the sub squares without using a for loop.

    private void drawHelper(int level, int startX, int startY, int width, int height) {
        int subWidth = width / 3;
        int subHeight = height / 3;

        if (level == 0) {
            return;
        }

        g.fillRect(startX + width / 3, startY + height / 3, width / 3, height / 3);

        // Top Row
        drawHelper(level - 1, startX, startY, subWidth, subHeight); // Left
        drawHelper(level - 1, startX + subWidth, startY, subWidth, subHeight); // Middle
        drawHelper(level - 1, startX + 2 * subWidth, startY, subWidth, subHeight); // Right
            
        // Middle Row
        drawHelper(level - 1, startX, startY + subHeight, subWidth, subHeight); // Left
        drawHelper(level - 1, startX + 2 * subWidth, startY + subHeight, subWidth, subHeight); // Right
            
        // Bottom Row
        drawHelper(level - 1, startX, startY + 2 * subHeight, subWidth, subHeight); // Left
        drawHelper(level - 1, startX + subWidth, startY + 2 * subHeight, subWidth, subHeight); // Middle
        drawHelper(level - 1, startX + 2 * subWidth, startY + 2 * subHeight, subWidth, subHeight); // Right
    }
}


        
