package com.ss.jbkt.dayfour;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LineTest {

    @Test
    public void testGetSlope () {
        Line line = new Line(0,0,1,1);
        assertEquals(1, line.getSlope(), .0001);

        Line lineTwo = new Line(0,0,1,2);
        assertEquals(2, lineTwo.getSlope(), .0001); 

        Line lineThree = new Line(50, 12, 70, 12);
        assertEquals(0, lineThree.getSlope(), .001);

    }

    //length?
    @Test
    public void testGetDistance () {
        Line line = new Line(0,0,1,1);
        assertEquals(Math.sqrt(2), line.getDistance(), .0001);

        Line lineTwo = new Line(0,0,1,2);
        assertEquals(Math.sqrt(5), lineTwo.getDistance(), .0001);
    }

    @Test
    public void testParallelTo () {
        Line line1 = new Line(0,0,2,2);
        Line line2 = new Line(2,0,4,2);
        Line line3 = new Line(1,0,2,2);

        assertTrue("Line one and two SHOULD be parallel", line1.parallelTo(line2));
        assertFalse("Line two and three SHOULD NOT be parallel", line2.parallelTo(line3));
    }

    @Test
    public void testSlopeError() {
        //line that goes from the origin to y = 1 above the origin;
        Line line1 = new Line(0, 0, 0, 1);
        try {
            line1.getSlope();
        } catch (Exception e) {
            System.out.println(e.toString());
            assertEquals("java.lang.ArithmeticException", e.toString());
        }
    }
}
