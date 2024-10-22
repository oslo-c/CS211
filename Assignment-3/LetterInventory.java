// CS 211 HW 3
// Ethan Hamilton


import java.util.*;

// This class takes a string input and returns its canonical form, which is all the letters in a sorted order, and all lower cases.
// Example: for the input word "AliBaba", the canonical form should be "aaabbil"
public class LetterInventory {
    private List<Character> canonical = new ArrayList<>();

    public LetterInventory(String input) {
        String lower = input.toLowerCase();
        for (int i = 0; i < lower.length(); i++) {
            canonical.add(lower.charAt(i));
        }
        Collections.sort(canonical);
    }
    
    // Returns the canonical form of the input word as a String
    public String getCanonical() {
        String result = "";
        for (char c: canonical) {
            result += c;
        }
        return result;
    }
}
