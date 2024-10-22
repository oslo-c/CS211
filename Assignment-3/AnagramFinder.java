// CS 211 HW 3
// Anagram Finder
// Ethan Hamilton


// This program takes a dictionary file and a word as input, searching for and displaying all anagrams of the word in the dictionary.

import java.io.*;
import java.util.*;

public class AnagramFinder {
    private Map<String, ArrayList<String>> canonicalMap = new HashMap<>();
    public static void main(String[] args) throws FileNotFoundException {
        String[] originals = new String[] {
            "realfun",
            "mias",
            "EVIL",
            "unable",
            "Silent",
            "AliBaba",            
        };

        for(String original: originals) {
            LetterInventory inv = new LetterInventory(original);
            System.out.println("Original: " + original + ", Canonical: " + inv.getCanonical());
        }

        System.out.println("\n");

        // TODO: change path to match where your input file is located
        File f = new File("HW_sample_dict.txt");

        AnagramFinder finder = new AnagramFinder(f);

        for(String original: originals) {
            finder.printAnagrams(original);
        }
    }

    // This is the constructor for the AnagramFinder class. It takes a File object as input and reads the dictionary from the file. 
    // It then populates the canonicalMap with the canonical form of each word in the dictionary.
    public AnagramFinder(File f) throws FileNotFoundException {
        Scanner input = new Scanner(f);

        while (input.hasNextLine()) {
            String entry = input.nextLine();
            LetterInventory ent = new LetterInventory(entry);
            if (canonicalMap.containsKey(ent.getCanonical())) {
                canonicalMap.get(ent.getCanonical()).add(entry);
            } else {
                ArrayList<String> value = new ArrayList<>();
                value.add(entry);
                canonicalMap.put(ent.getCanonical(), value);
            }
        }
        input.close();
    }

    // This method prints all the anagrams of the given word. If the word is not in the dictionary,it will print a message saying so.
    public void printAnagrams(String word) {
        String canonicalWord = new LetterInventory(word).getCanonical();
        if (canonicalMap.containsKey(canonicalWord)) {
            System.out.print("Your input is: " + word + ". Found anagrams: ");
            for (String s: canonicalMap.get(canonicalWord)) {
                System.out.print(s + " ");
            }
            System.out.println();
        } else {
            System.out.println("Your input is: " + word + ". Sorry, didn't find any anagrams.");
        }
    }

    // This is a more advanced version of printAnagrams which omits the given word from the list of anagrams. If the word is not in the dictionary,
    // ***or if the word is the only listed entry in the dictionary***, it will print a message saying so.
    public void printAnagrams2(String word) {
        String canonicalWord = new LetterInventory(word).getCanonical();
        System.out.print("Your input is: " + word + ".");
        
        if (canonicalMap.containsKey(canonicalWord)) {
            List<String> anagrams = canonicalMap.get(canonicalWord);
            if (anagrams.size() < 1 || anagrams.size() == 1 && anagrams.get(0).equals(word.toLowerCase())) {
                System.out.print(" Sorry, didn't find any anagrams.");
            } else {
                System.out.print(" Found anagrams: ");
                for (String entry: anagrams) {
                    if (!entry.equals(word.toLowerCase())) {
                        System.out.print(entry + " ");}
                }
            }
        } else {
            System.out.print(" Sorry, didn't find any anagrams.");
        }
        System.out.println();
    }
}
