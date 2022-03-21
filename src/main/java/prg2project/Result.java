package prg2project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Result {
    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<grades.size(); i++){
            if(grades.get(i)<38){
                result.add(grades.get(i));
            }else{
                if(grades.get(i)%5==0){
                    result.add(grades.get(i));
                }else{
                    int temp = grades.get(i);
                    while (true){
                        if(temp%5==0){
                            if(temp-grades.get(i)<3){
                                result.add(temp);
                            }else{
                                result.add(grades.get(i));
                            }
                            break;
                        }
                        temp++;
                    }
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int students;
        while (true) {
            System.out.println("Enter Number of Students");
            if (scan.hasNextInt()) {
                int temp = scan.nextInt();
                if (temp > 0 && temp <= 60) {
                    students = temp;
                    break;
                }
            } else {
                scan.next();
            }
        }

        List<Integer> grades = new ArrayList<>();

        for (int i = 0; i < students; i++) {
            while (true) {
                System.out.println("Enter Grade of Student " + (i + 1));
                if (scan.hasNextInt()) {
                    int temp = scan.nextInt();
                    if (temp >= 0 && temp <= 100) {
                        grades.add(temp);
                        break;
                    }
                } else {
                    scan.next();
                }

            }
        }

    }
}
