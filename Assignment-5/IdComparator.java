// CS 211 HW 5
//   IdComparator
//   Ethan Hamilton

//   This comparator compares StudentData objects by their ID for sorting purposes.

import java.util.*;

public class IdComparator implements Comparator<StudentData> {
    public int compare(StudentData s1, StudentData s2) {
        return s1.getId().compareTo(s2.getId());
    }
}
