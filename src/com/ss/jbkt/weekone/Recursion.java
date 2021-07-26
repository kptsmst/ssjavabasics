package com.ss.jbkt.weekone;

public class Recursion {
    public static void main(String[] args) {
        //demoing groupsumclump
        System.out.println(groupSumClump(0, new int[]{1,2,3}, 7));
        System.out.println(groupSumClump(0, new int[]{1,2,2,5}, 2));

        System.out.println(groupSumClump(0, new int[]{2,4,8}, 10));
        System.out.println(groupSumClump(0, new int[]{1,2,4,8,1}, 14));
        System.out.println(groupSumClump(0, new int[]{2,4,4,8}, 14));

    }

    public static boolean groupSumClump(int currentIndex, int[] intArray, int countLeft) {
        if (countLeft == 0) return true;
        if (countLeft < 0) return false;
        if (currentIndex == intArray.length) return false;

        //take
        int groupValue = intArray[currentIndex];
        int groupCount = 1;
        int groupIndex = currentIndex + 1;
        while(groupIndex < intArray.length) {
            if (intArray[groupIndex] == groupValue) {
                groupCount = groupCount + 1;
                groupIndex = groupIndex + 1;
            } else {
                break;
            }
        }
        if (groupSumClump(currentIndex + groupCount, intArray, countLeft-(groupCount * groupValue))) return true;
        
        //dont take
        if (groupSumClump(currentIndex + groupCount, intArray, countLeft)) return true;

        return false;
        
    }
}
