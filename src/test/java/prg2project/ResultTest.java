package prg2project;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Link to my Repo
// https://github.com/4n7oine/prog2-ss21-4n7oine
// Lanners Antoine

class ResultTest {

    @Test
    @DisplayName("Test Grades below 38")
    void gradingStudentsbelow38() {
        //Generate List of grades that doesn't should be rounded
        List<Integer> input = new ArrayList<>();
        List<Integer> expected = new ArrayList<>();;
        for(int i=0; i<38; i++){
            input.add(i);
            expected.add(i);
        }
        List<Integer> actual = Result.gradingStudents(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test Grades that should get rounded")
    void gradingStudentswithroundedgrades() {
        // Generate Grades that must be rounded
        List<Integer> input = new ArrayList<>();
        for( int i=38; i<100; i++){
            input.add(i);
            if((i+1)%10==0 || (i+1)%5==0){
                i = i+3;
            }
        }
        List<Integer> actual = Result.gradingStudents(input);
        //Generate expected rounded grades
        List<Integer> expected = new ArrayList<>();
        int counter = 40;
        while(true){
           if(counter == 100){
               expected.add(counter);
               expected.add(counter);
               break;
           }else{
               expected.add(counter);
               expected.add(counter);
               counter=counter+5;
           }
        }

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test Grades that shouldn't get rounded and are >38")
    void gradingStudentswithNoRoundedgrades_and_are_above_38() {

        // Generate Grades that must not be rounded

        List<Integer> input = new ArrayList<>();
        List<Integer> expected = new ArrayList<>();
        for(int i=39; i<=100; i++){
            int temp = i;
            while(temp%5!=0){
                temp++;
            }

            if(temp-i>2 || temp==i){
                input.add(i);
                expected.add(i);
            }
        }

        List<Integer> actual = Result.gradingStudents(input);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Check Handling for Null-List")
    void handlingNullList_and_returnEmptyList() {
        List<Integer> input = null;
        List<Integer> expected = new ArrayList<Integer>();
        List<Integer> actual = Result.gradingStudents(null);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Boolean Test if Null-List")
    void checkIfListIsNull() {
        assertTrue(Result.isListNull(null));
    }

    @Test
    @DisplayName("Number of students below 0")
    void checkRangeStudents_below_0() {
        assertFalse(Result.checkRangeStudents(-1));
    }

    @Test
    @DisplayName("Number of stundets = 0")
    void checkRangeStudents_0() {
        assertFalse(Result.checkRangeStudents(0));
    }

    @Test
    @DisplayName("Number of students in range")
    void checkRangeStudents_in_Range() {
        assertTrue(Result.checkRangeStudents(10));
    }

    @Test
    @DisplayName("Number of students to high")
    void checkRangeStudents_too_high() {
        assertFalse(Result.checkRangeStudents(100));
    }

    @Test
    @DisplayName("Grade below 0")
    void checkRangeGrades_below_0() {
        assertFalse(Result.checkRangeGrades(-1));
    }

    @Test
    @DisplayName("Grade in Range")
    void checkRangeGrades_in_Range() {
        assertTrue(Result.checkRangeGrades(10));
    }

    @Test
    @DisplayName("Grade to High")
    void checkRangeGrades_too_high() {
        assertFalse(Result.checkRangeGrades(110));
    }












}