package com.ss.jbkt.dayFIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssignmentOne {

    public static void main(String[] args) { 
        basicLambdas();
    }

    public static void basicLambdas()) {
        String[] aFewStrings = {"java","echo","smoothstack","pramod","kevin","saturday", "july", "engine","Epsilon"};
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
