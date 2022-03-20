package prg2project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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

}