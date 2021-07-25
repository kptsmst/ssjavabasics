package com.ss.jbkt.weekone;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Functional {
  
    public static void main(String[] args) {
        System.out.println(rightDigit(Arrays.asList(1, 22, 92)));
        System.out.println(rightDigit(Arrays.asList(18, 8, 886, 8, 1)));

        System.out.println(doubling(Arrays.asList(1, 2, 3)));
        System.out.println(doubling(Arrays.asList(6, 8, 6, 8, -1)));

        System.out.println(noX(Arrays.asList("ax","bc","cx","xxdx")));


    }

    static List<Integer> rightDigit (List<Integer> list) {
        return list.stream().map((i)->i%10).collect(Collectors.toList());
    }

    static List<Integer> doubling (List<Integer> list) {
        return list.stream().map((i)->i*2).collect(Collectors.toList());
    }

    static List<String> noX (List<String> list) {
        return list.stream().map((s)->s.replace("x", "")).collect(Collectors.toList());

    }

}

/* 
Assignment 2: Functional
Given a list of non-negative integers, return an integer list of the rightmost digits. (Note: use %)

rightDigit([1, 22, 93]) → [1, 2, 3]
rightDigit([16, 8, 886, 8, 1]) → [6, 8, 6, 8, 1]
rightDigit([10, 0]) → [0, 0]

Assignment 3: Functional
Given a list of integers, return a list where each integer is multiplied by 2.

doubling([1, 2, 3]) → [2, 4, 6]
doubling([6, 8, 6, 8, -1]) → [12, 16, 12, 16, -2]
doubling([]) → []

Assignment 4: Functional
Given a list of strings, return a list where each string has all its "x" removed.

noX(["ax", "bb", "cx"]) → ["a", "bb", "c"]
noX(["xxax", "xbxbx", "xxcx"]) → ["a", "bb", "c"]
noX(["x"]) → [""]
*/