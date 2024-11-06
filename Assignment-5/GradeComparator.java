// CS 211 HW 5
//   GradeComparator
//   Ethan Hamilton

//   This comparator compares StudentData objects by their grade for sorting purposes.

import java.util.*;

public class GradeComparator implements Comparator<StudentData> {
    public int compare(StudentData s1, StudentData s2) {
        return (int) (s1.getGrade() - s2.getGrade());
    }
}
