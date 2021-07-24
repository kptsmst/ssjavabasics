package com.ss.jbkt.dayFIVE;

import java.util.Comparator;

public class Utils {

    public static int LowercaseEFirstStringCompare (String s1, String s2) {
        if (s1.charAt(0) == 'e' && s2.charAt(0) == 'e') {
            return 0;
        } else if (s1.charAt(0) == 'e') {
            return -1;
        } else if (s2.charAt(0) == 'e') {
            return 1;
        }

        return 0;
    }

    public static class StringComparator implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            if (s1.charAt(0) == 'e' && s2.charAt(0) == 'e') {
                return 0;
            } else if (s1.charAt(0) == 'e') {
                return -1;
            } else if (s2.charAt(0) == 'e') {
                return 1;
            }
    
            return 0;
        }

    }

    public static int compare(String s1, String s2) {
        if (s1.charAt(0) == 'e' && s2.charAt(0) == 'e') {
            return 0;
        } else if (s1.charAt(0) == 'e') {
            return -1;
        } else if (s2.charAt(0) == 'e') {
            return 1;
        }

        return 0;
    }


}
