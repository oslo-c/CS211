// CS 211 HW 2
// Article Reverser
// Ethan Hamilton


// This program takes an plaintext input file, reads it, then prints it both forwards and backwards
import java.io.*;
import java.util.*;

public class ArticleReverser {

    public static void main(String[] args)  throws FileNotFoundException {
        // Replace with path to test file
        File f = new File("HW2_sample_input.txt");

        ArticleReverser r = new ArticleReverser();
        r.readLines(f);

        System.out.println("--- the Original article ---");
        r.print();

        System.out.println("\n--- now Reversed ---");
        r.reversePrint();
    }

    // Each element in lines is an ArrayList of the elements in the corresponding line
    private List<List<String>> lines = new ArrayList<List<String>>();

    public void readLines(File inputFile) throws FileNotFoundException {
        // Reads input file one line at a time
        Scanner lineScan = new Scanner(inputFile);
        int index = 0;

        while (lineScan.hasNextLine()) {
            int subIndex = 0;
            String line = lineScan.nextLine();
            List<String> currentLine = new ArrayList<String>(); // Creates new ArrayList to house elements from individual lines

            Scanner elementScan = new Scanner(line); // Reads elements from single line
            while (elementScan.hasNext()) {
                currentLine.add(subIndex, elementScan.next()); // Adds String elements to ArrayList<String> currentLine
                subIndex++;
            }
            lines.add(index, currentLine); // Adds currentLine to lines
            index++;
        }
    }

    public void print() {
        // Prints the original article as was written
        for (List<String> line: lines) {
            for (String element: line) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public void reversePrint() {
        // Prints reversed lines, in reversed order
        for (int i = lines.size() - 1; i >= 0; i--) {
            List<String> line = lines.get(i);
            for (int j = line.size() - 1; j >= 0; j--) {
                System.out.print(line.get(j) + " ");
            }
            System.out.println();
        }
    }
}

