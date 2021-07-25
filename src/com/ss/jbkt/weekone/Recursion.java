package com.ss.jbkt.weekone;

public class Recursion {
    public static void main(String[] args) {
        System.out.println(groupSumClump(0, new int[]{1,2,3}, 7));
        System.out.println(groupSumClump(0, new int[]{1,2,5}, 2));
    }

    public static boolean groupSumClump(int currentIndex, int[] remainingInts, int countLeft) {
        if (countLeft == 0) return true;
        if (currentIndex == remainingInts.length) return false;

        //take
        int groupValue = remainingInts[currentIndex];
        int groupCount = 1;
        int groupIndex = currentIndex + 1;
        while(groupIndex < remainingInts.length) {
            if (remainingInts[groupIndex] == groupValue) {
                groupCount = groupCount + 1;
                groupIndex = groupIndex + 1;
            } else {
                break;
            }
        }
        if (groupSumClump(currentIndex + groupCount, remainingInts, countLeft-remainingInts[currentIndex])) return true;
        
        //dont take
        if (groupSumClump(currentIndex + 1, remainingInts, countLeft)) return true;

        return false;
        
    }
}
