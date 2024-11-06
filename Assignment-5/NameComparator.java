// CS 211 HW 5
//   NameComparator
//   Ethan Hamilton

//   This comparator compares StudentData objects by their name for sorting purposes.

import java.util.*;

public class NameComparator implements Comparator<StudentData> {
    public int compare(StudentData s1, StudentData s2) {
        return s1.getName().compareTo(s2.getName());
    }
}
