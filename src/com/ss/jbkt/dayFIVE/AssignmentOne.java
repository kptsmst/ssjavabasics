package com.ss.jbkt.dayFIVE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AssignmentOne {

    public static void main(String[] args) { 
        basicStringLambdas();
        java8StringsToIntsDemo();
        filterDemo();
    }

    public static void basicStringLambdas() {
        String[] aFewStrings = {"java","echo","smoothstack","pramod","kevin","saturday", "july", "engine","Epsilon", "bob", "alpha"};
        List<String> asAList = Arrays.asList(aFewStrings);
        
        System.out.print("List at initialization: ");
        System.out.println(asAList);
        
        sortArrayListByLength(asAList);
        System.out.print("List after sorting by length: ");
        System.out.println(asAList);

        sortArrayListByLengthReverse(asAList);
        System.out.print("List after sorting by length descending: ");
        System.out.println(asAList);

        SortArrayListByEFirst(asAList);
        System.out.print("List after bringing `e`s to the front: ");
        System.out.println(asAList);

        sortArrayListByFirstChar(asAList);
        System.out.print("List after sorting by first character: ");
        System.out.println(asAList);

        /*
        Arrays.sort(asAList, (s1, s2)->Utils.LowercaseEFirstStringCompare(s1,s2));
        System.out.print("List after bringing `e`s to the front: ");
        System.out.println(asAList);
        */

        Arrays.sort(aFewStrings, (s1,s2) -> Utils.compare(s1, s2));
        System.out.print("List after bringing `e`s to the front (with static helper): ");
        System.out.println(asAList);
    }

    public static void java8StringsToIntsDemo () {
        List<Integer> ints = Arrays.asList(456, 34561, 123, 4, 7, 1234, 547);
        String intsAsStr = labelEvenOddInts(ints);
        System.out.print("Integer list: ");
        System.out.println(ints);
        System.out.print("Comma seperated labeled string: ");
        System.out.println(intsAsStr);
    }

    public static String labelEvenOddInts (List<Integer> ints ) {
        String str = ints.stream().map(IntObj->{
            if (IntObj % 2 == 0) {
                return "e"+String.valueOf(IntObj);
            } else {
                return "o"+String.valueOf(IntObj);
            }
        }).collect(Collectors.joining(","));
        return str;
    }

    public static void filterDemo () {
        List<String> strs = Arrays.asList("wow", "this", "are", "a", "list", "with", "low", "age");
        List<String> filteredStrs = filterForThreeLettersStartingWith_a(strs);
        System.out.print("Pre filter: ");
        System.out.println(strs);
        System.out.print("After filtering for three letters starting with a: ");
        System.out.println(filteredStrs);
    }

    public static List<String> filterForThreeLettersStartingWith_a (List<String> originalList ) {
        List<String> newList = originalList.stream().filter(str->{
            if (str.length() == 3 && str.charAt(0) == 'a') return true;
            return false;
        }).collect(Collectors.toList());
        return newList;
    }


    public static void sortArrayListByLength (List<String> aList) {
        aList.sort((f,s)->f.length() - s.length());
    }

    public static void sortArrayListByLengthReverse (List<String> aList) {
        aList.sort((f,s)->s.length() - f.length());
    }

    public static void sortArrayListByFirstChar (List<String> aList) {
        aList.sort((f,s)->f.charAt(0) - s.charAt(0));
    }

    public static void SortArrayListByEFirst (List<String> aList) {
        aList.sort((f,s)->{
            if (f.charAt(0) == 'e' && s.charAt(0) == 'e') {
                return 0;
            } else if (f.charAt(0) == 'e') {
                return -1;
            } else if (s.charAt(0) == 'e') {
                return 1;
            }
            
            return 0;

        });
    }
 

}
