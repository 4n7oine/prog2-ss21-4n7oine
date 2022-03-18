package prg2project;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Result {
    public static List<Integer> gradingStudents(List<Integer> grades) {
        return null;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Number of Students");
        int students = scan.nextInt();
        System.out.println(students);
        List<Integer> grades = new ArrayList<>();
        for (int i=0; i<students;i++){
            System.out.println("Enter Grade of Student" + (i+1));
            grades.add(scan.nextInt());
        }
    }
}
