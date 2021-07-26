package com.ss.jbkt.dayFIVE;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

public class AssignmentTwoTests {

    @Test
    public void fThirteenthTests () {

        LocalDate janFirst = LocalDate.of(2021, 1, 1);
        boolean shouldBeFalse = AssignmentTwo.isDateFridayTheThirteenth(janFirst);
        assertFalse(shouldBeFalse);
        
        LocalDate fThirteenth = LocalDate.of(2021, 8, 13);
        boolean shouldBeTrue = AssignmentTwo.isDateFridayTheThirteenth(fThirteenth);
        assertTrue(shouldBeTrue);
    }
}
