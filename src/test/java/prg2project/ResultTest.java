package prg2project;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Link to my Repo
// https://github.com/4n7oine/prog2-ss21-4n7oine
// Lanners Antoine

class ResultTest {

    @Test
    @DisplayName("Check if List contains Null-Element")
    void check_if_list_contains_nullElement_1() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 23, 54, null, 45));
        assertTrue(Result.listContainsNullElement(input));
    }

    @Test
    @DisplayName("Check if List contains Null-Element")
    void check_if_list_contains_nullElement_2() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 23, 54, 88, 45));
        assertFalse(Result.listContainsNullElement(input));
    }


    @Test
    @DisplayName("Check if Grade should be rounded - Test 1")
    void check_if_grade_should_get_rounded_1() {
        int grade = 45;
        assertFalse(Result.checkIfGradeShouldGetRounded(grade));
    }


    @Test
    @DisplayName("Check if Grade should be rounded - Test 2")
    void check_if_grade_should_get_rounded_2() {
        int grade = 44;
        assertTrue(Result.checkIfGradeShouldGetRounded(grade));
    }

    @Test
    @DisplayName("Check if Grade should be rounded - Test 3")
    void check_if_grade_should_get_rounded_3() {
        int grade = 98;
        assertTrue(Result.checkIfGradeShouldGetRounded(grade));
    }

    @Test
    @DisplayName("Check if Grade should be rounded - Test 4")
    void check_if_grade_should_get_rounded_4() {
        int grade = 35;
        assertFalse(Result.checkIfGradeShouldGetRounded(grade));
    }

    @Test
    @DisplayName("Test Grades below 38")
    void gradingStudentsbelow38() {
        //Generate List of grades that doesn't should be rounded
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37));
        List<Integer> expected = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37));

        List<Integer> actual = Result.gradingStudents(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Next Multiple of 5 - Test 1")
    void nextMultipleOf5_Test1() {
        //Generate List of grades that doesn't should be rounded
        int input = 43;
        int expected = 45;

        int actual = Result.nextMultipleOfFive(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Next Multiple of 5 - Test 2")
    void nextMultipleOf5_Test2() {
        //Generate List of grades that doesn't should be rounded
        int input = 44;
        int expected = 45;

        int actual = Result.nextMultipleOfFive(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Next Multiple of 5 - Test 3")
    void nextMultipleOf5_Test3() {
        //Generate List of grades that doesn't should be rounded
        int input = 43;
        int expected = 45;

        int actual = Result.nextMultipleOfFive(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Next Multiple of 5 - Test 4")
    void nextMultipleOf5_Test4() {
        //Generate List of grades that doesn't should be rounded
        int input = 41;
        int expected = 45;

        int actual = Result.nextMultipleOfFive(input);
        assertEquals(expected, actual);
    }




    @Test
    @DisplayName("Round Grade - Test 1")
    void Round_Grade_Test1() {
        //Generate List of grades that doesn't should be rounded
        int input = 43;
        int expected = 45;

        int actual = Result.roundGrade(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Round Grade - Test 2")
    void Round_Grade_Test2() {
        //Generate List of grades that doesn't should be rounded
        int input = 44;
        int expected = 45;

        int actual = Result.roundGrade(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Round Grade - Test 3")
    void Round_Grade_Test3() {
        //Generate List of grades that doesn't should be rounded
        int input = 98;
        int expected = 100;

        int actual = Result.roundGrade(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Round Grade - Test 4")
    void Round_Grade_Test4() {
        //Generate List of grades that doesn't should be rounded
        int input = 99;
        int expected = 100;

        int actual = Result.roundGrade(input);
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

        System.out.println(input.toString());
        System.out.println(expected.toString());
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