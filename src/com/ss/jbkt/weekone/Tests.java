package com.ss.jbkt.weekone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class Tests {

    @Test
    public void isOddTest () {
        int even = 4;
        int odd = 3;
        assertTrue(Lambdas.isOdd().test(odd));
        assertFalse(Lambdas.isOdd().test(even));
    }

    @Test
    public void isPrimeTest () {
        int primeOne = 3;
        int primeTwo = 5;
        int primeThree = 7;
        int primeFour = 11;

        int compositeOne = 4;
        int compositeTwo = 9;
        int compositeThree = 28;

        assertTrue(Lambdas.isPrime().test(primeOne));
        assertTrue(Lambdas.isPrime().test(primeTwo));
        assertTrue(Lambdas.isPrime().test(primeThree));
        assertTrue(Lambdas.isPrime().test(primeFour));

        assertFalse(Lambdas.isPrime().test(compositeOne));
        assertFalse(Lambdas.isPrime().test(compositeTwo));
        assertFalse(Lambdas.isPrime().test(compositeThree));
    }

    @Test
    public void isPalindromeTest () {
        assertTrue(Lambdas.isPalindrome().test(12321));
        assertFalse(Lambdas.isPalindrome().test(123421));
    }

    @Test 
    public void testRightDigits () {
        assertEquals(Arrays.asList(3,5,2,1,8,6), Functional.rightDigit(Arrays.asList(123,435, 12, 111, 88, 56)));
        
    }
    
    @Test 
    public void testDoubling () {
        assertEquals(Arrays.asList(246,870,24,222,176,112), Functional.doubling(Arrays.asList(123,435, 12, 111, 88, 56)));
    }
    
    @Test
    public void testNox () {
        assertEquals(Arrays.asList("a","bc","c","d"), Functional.noX(Arrays.asList("ax","bc","cx","xxdx")));
    }

    @Test
    public void testSingleton () {
        SampleSingleton ss = SampleSingleton.getInstance();
        SampleSingleton ss2 = SampleSingleton.getInstance();
        assertEquals(ss, ss2);
    }

    @Test
    public void groupSumClumpTest() {
        //demoing groupsumclump
        assertFalse(Recursion.groupSumClump(0, new int[]{1,2,3}, 7));
        assertFalse(Recursion.groupSumClump(0, new int[]{1,2,2,5}, 2));

        assertTrue(Recursion.groupSumClump(0, new int[]{2,4,8}, 10));
        assertTrue(Recursion.groupSumClump(0, new int[]{1,2,4,8,1}, 14));
        assertFalse(Recursion.groupSumClump(0, new int[]{2,4,4,8}, 14));

    }
}
