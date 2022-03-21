package prg2project;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {


    @Test
    @DisplayName("Grades below 38")
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
    @DisplayName("Grades that should get rounded")
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
    @DisplayName("Check Handling for Null-List")
    void handlingNullList_and_returnEmptyList() {
        //Generate List of grades that doesn't should be rounded
        List<Integer> input = null;
        List<Integer> expected = new ArrayList<Integer>();
        List<Integer> actual = Result.gradingStudents(null);
        assertEquals(expected, actual);
    }


    @Test
    void checkRangeStudents_below_0() {
        assertFalse(Result.checkRangeStudents(-1));
    }

    @Test
    void checkRangeStudents_0() {
        assertFalse(Result.checkRangeStudents(0));
    }

    @Test
    void checkRangeStudents_in_Range() {
        assertTrue(Result.checkRangeStudents(10));
    }
    @Test
    void checkRangeStudents_too_high() {
        assertFalse(Result.checkRangeStudents(100));
    }

    @Test
    void checkRangeGrades_below_0() {
        assertFalse(Result.checkRangeGrades(-1));
    }
    @Test
    void checkRangeGrades_in_Range() {
        assertTrue(Result.checkRangeGrades(10));
    }
    @Test
    void checkRangeGrades_too_high() {
        assertFalse(Result.checkRangeGrades(110));
    }

}