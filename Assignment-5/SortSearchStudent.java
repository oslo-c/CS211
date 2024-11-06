// CS 211 HW 5
//   SortSearchStudent
//   Ethan Hamilton

// This program drives the sorting and searching of StudentData objects, each of which represents a single student's identifying information and academic record.

import java.io.*;
import java.util.*;

public class SortSearchStudent {
    private List<StudentData> studentList = new ArrayList<StudentData>();

    public static void main(String[] args) throws FileNotFoundException {
        // TODO: change path to match where your input file is located
        File f = new File("students.txt");

        SortSearchStudent sss = new SortSearchStudent(f);

        System.out.println("\n=== The original ===");
        sss.PrintList();


        System.out.println("\n=== Sort by Name ===");
        sss.SortList(new NameComparator());
        sss.PrintList();


        System.out.println("\n=== Search by Name: Smith Marty ===");
        sss.SearchAndPrintEntry(new StudentData("Smith Marty", "", 0), new NameComparator());
        System.out.println("\n=== Search by Name: Johnson Gus ===");
        sss.SearchAndPrintEntry(new StudentData("Johnson Gus", "", 0), new NameComparator());

        System.out.println("\n=== Search by Name: Foo Bar ===");
        sss.SearchAndPrintEntry(new StudentData("Foo Bar", "", 0), new NameComparator());


        System.out.println("\n=== Sort by Id ===");
        sss.SortList(new IdComparator());
        sss.PrintList();

        System.out.println("\n=== Search by Id: 346282 ===");
        sss.SearchAndPrintEntry(new StudentData("", "346282", 0), new IdComparator());
        System.out.println("\n=== Search by Id: 210498 ===");
        sss.SearchAndPrintEntry(new StudentData("", "210498", 0), new IdComparator());
        System.out.println("\n=== Search by Id: 999999 ===");
        sss.SearchAndPrintEntry(new StudentData("", "999999", 0), new IdComparator());


        System.out.println("\n=== Sort by Grade ===");
        sss.SortList(new GradeComparator());
        sss.PrintList();

        System.out.println("\n=== Search by Grade: 84.1 ===");
        sss.SearchAndPrintEntry(new StudentData("", "", 84.1), new GradeComparator());
        System.out.println("\n=== Search by Grade: 98.6 ===");
        sss.SearchAndPrintEntry(new StudentData("", "", 98.6), new GradeComparator());
        System.out.println("\n=== Search by Grade: 72.4 ===");
        sss.SearchAndPrintEntry(new StudentData("", "", 72.4), new GradeComparator());
        System.out.println("\n=== Search by Grade: 100 ===");
        sss.SearchAndPrintEntry(new StudentData("", "", 100), new GradeComparator());
    }

    // This method reads each line from the file, breaking it into the data parts. It creates a new StudentData object for each student and adds it to the studentList.
    public SortSearchStudent(File f) throws FileNotFoundException {
        studentList = new ArrayList<StudentData>();
        Scanner s = new Scanner(f);
        while (s.hasNextLine()) {
            String[] dataParts = s.nextLine().split("\\t+"); // Split the line into data parts using tab as delimiter, accounting for multiple tabs
            studentList.add(new StudentData(dataParts[0].trim(), dataParts[1].trim(), Double.parseDouble(dataParts[2].trim()))); 
        }
        s.close();
    }

    public void PrintList() {
        for(StudentData d: studentList) {
            System.out.println(d);
        }
    }

    public void SortList(Comparator<StudentData> comp) {
        Collections.sort(studentList, comp);
    }

    public void SearchAndPrintEntry(StudentData toFind, Comparator<StudentData> comp) {
        int index = Collections.binarySearch(studentList, toFind, comp);

        if(index >= 0) {
            System.out.println(studentList.get(index));
        } else {
            System.out.println("(hmm, no such student!)");
        }
    }
}
