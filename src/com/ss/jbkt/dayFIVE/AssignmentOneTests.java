package com.ss.jbkt.dayFIVE;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AssignmentOneTests {
    @Test
    public void testSortByLength () {
        List<String> strs = Arrays.asList("wow", "this", "are", "a", "list", "with", "low", "age");
        AssignmentOne.sortArrayListByLength(strs);
        String[] expected = {"a","wow","are","low","age","this","list","with"};
        assertArrayEquals(expected, strs.toArray());
    }

    @Test
    public void testSortByLengthReverse () {
        List<String> strs = Arrays.asList("wow", "this", "are", "a", "list", "with", "low", "age");
        AssignmentOne.sortArrayListByLengthReverse(strs);
        String[] expected = {"this","list","with","wow","are","low","age","a"};
        assertArrayEquals(expected, strs.toArray());
    }

    @Test
    public void testEsFirst () {
        List<String> strs = Arrays.asList("wow", "this", "are", "a", "echo", "list", "with", "low", "age");
        AssignmentOne.SortArrayListByEFirst(strs);
        List<String> strs2 = Arrays.asList("echo", "wow", "this", "are", "a", "list", "with", "low", "age");
        assertEquals(strs2, strs);
    }
}
