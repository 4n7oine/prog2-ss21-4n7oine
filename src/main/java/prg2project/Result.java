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
            throw new IllegalArgumentException("List is null");
        }

        if(listContainsNullElement(grades)){
            throw new IllegalArgumentException("List contains null element");
        }

        //Old Code
        /*for(int i=0; i<grades.size(); i++){
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
        }*/

        for(int i=0; i<grades.size(); i++) {
            if(checkIfGradeShouldGetRounded(grades.get(i))){
                result.add(roundGrade(grades.get(i)));
            }else{
                result.add(grades.get(i));
            }
        }

        return result;

    }

    protected static Integer roundGrade(Integer integer) {
        return nextMultipleOfFive(integer);
    }

    protected static boolean checkIfGradeShouldGetRounded(Integer integer) {
        if(integer<38 || (nextMultipleOfFive(integer)-integer>2 || integer==nextMultipleOfFive(integer))){
            return false;
        }else{
            return true;
        }
    }

    protected static Integer nextMultipleOfFive(Integer integer){
        int temp = integer;
        while (!(integer%5==0)){
            integer++;
        }
        return integer;
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


    protected static boolean listContainsNullElement(List<Integer> grades) {
        return (grades.contains(null));
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
