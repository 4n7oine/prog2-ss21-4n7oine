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

        for (int i = 0; i < grades.size(); i++) {
            if(!(checkRangeGrades(grades.get(i)))){
                throw new IllegalArgumentException("Grade not in the Range - Must >=0 && <=100");
            }
        }


        for(int i=0; i<grades.size(); i++) {
            if(checkIfGradeShouldGetRounded(grades.get(i))){
                result.add(roundGrade(grades.get(i)));
            }else{
                result.add(grades.get(i));
            }
        }

        return result;

    }



    protected static int roundGrade(int integer) {
        return nextMultipleOfFive(integer);
    }

    protected static boolean checkIfGradeShouldGetRounded(int integer) {
        if(integer<38 || (nextMultipleOfFive(integer)-integer>2 || integer==nextMultipleOfFive(integer))){
            return false;
        }else{
            return true;
        }
    }

    protected static int nextMultipleOfFive(int integer){
        while (!(integer%5==0)){
            integer++;
        }
        return integer;
    }

    protected static boolean checkRangeStudents(int value) {
        return (value > 0 && value <= 60);
    }

    protected static boolean checkRangeGrades(int value) {
        return (value >= 0 && value <= 100);
    }

    protected static boolean isListNull(List<Integer> grades) {
        return (grades==null);
    }

    protected static boolean listContainsNullElement(List<Integer> grades) {
        return (grades.contains(null));
    }



}
