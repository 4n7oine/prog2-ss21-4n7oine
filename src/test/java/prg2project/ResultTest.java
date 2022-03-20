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
        List<Integer> input = new ArrayList<>();
        List<Integer> expected = new ArrayList<>();;
        for(int i=0; i<38; i++){
            input.add(i);
            expected.add(i);
        }
        List<Integer> actual = Result.gradingStudents(input);
        assertEquals(expected, actual);
    }


}