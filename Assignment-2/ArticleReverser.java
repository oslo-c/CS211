// CS 211 HW 2
// Article Reverser
//   Reverse the lines of the input article.
//   For each line, the words should also be reversed.
//
//   For example, if your article has two lines:
//
//     This is line 1.
//     And, this is line 2.
//
//   The "reversed" should print as:
//
//     2. line is this And,
//     1. line is This
//
//   Please use ArrayList to help you.
//


import java.io.*;
import java.util.*;

public class ArticleReverser {

    public static void main(String[] args)  throws FileNotFoundException {
        // TODO: change path to match where your input file is located
        File f = new File("/sample_input.txt");

        ArticleReverser r = new ArticleReverser();
        r.readLines(f);

        System.out.println("--- the Original article ---");
        r.print();

        System.out.println("\n--- now Reversed ---");
        r.reversePrint();
    }

    private List<List<String>> lines = new ArrayList<List<String>>();

    public void readLines(File inputFile) throws FileNotFoundException {
        // Reads input file, puts data into the above ArrayList
        Scanner lineScan = new Scanner(inputFile);
        int index = 0;

        while (lineScan.hasNextLine()) {
            int subIndex = 0;
            String line = lineScan.nextLine();
            List<String> nextLine = new ArrayList<String>(); // Creates new ArrayList object to house line elements

            Scanner elementScan = new Scanner(line);
            while (elementScan.hasNext()) {
                nextLine.add(subIndex, elementScan.next());
                subIndex++;
            }
            lines.add(index, nextLine);
            index++;
            }
        }

    public void print() {
        // Prints the original article as it was written
        for (List<String> line: lines) {
            System.out.println(line);
        }
    }

    public void reversePrint() {
        // TODO: print with lines reversed, and each line with words reversed
        for (int i = lines.size(); i > 0; i--) {
            for (int j = lines[i].length(); j > 0; j--) {
                System.out.print(line(j));
            }
        }
    }
}
