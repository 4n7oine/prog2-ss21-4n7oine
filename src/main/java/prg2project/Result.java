package prg2project;

import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Link to my Repo
// https://github.com/4n7oine/prog2-ss21-4n7oine
// Lanners Antoine

// Class with static method to calculate rounded grades

public class Result {

    //Method to calculate rounded grades and return them as a List<Integer>

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> result = new ArrayList<>();

        if(isListNull(grades)){
            return result;
        }

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

    protected static boolean checkRangeStudents(int value) {
        return (value > 0 && value <= 60);
    }

    protected static boolean checkRangeGrades(int value) {
        return (value > 0 && value <= 100);
    }

    protected static boolean isListNull(List<Integer> grades) {
        return (grades==null);
    }



    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int students;

        while (true) {
            System.out.println("Enter Number of Students");
            if (scan.hasNextInt()) {
                students = scan.nextInt();
                if(checkRangeStudents(students));
                   break;
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
                    if(checkRangeGrades(students));
                    break;
                } else {
                    scan.next();
                }

            }
        }
    }


}
