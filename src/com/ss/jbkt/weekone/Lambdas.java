package com.ss.jbkt.weekone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.invoke.LambdaMetafactory;

public class Lambdas {
    public static void main(String[] args) {
        String fileToRead = "resources/input/Week1Input.txt";
        try ( BufferedReader br = new BufferedReader(new FileReader(fileToRead)) ) {
            int testCount = Integer.parseInt(br.readLine());
            for (int i = 0; i < testCount; i++) {
                String[] testAndValue = br.readLine().split(" ");
                boolean result;
                switch (testAndValue[0]) {
                    case "1":
                        result = isOdd().test(Integer.parseInt(testAndValue[1]));
                        System.out.println(result?"ODD":"EVEN");
                        break;
                    case "2":
                        result = isPrime().test(Integer.parseInt(testAndValue[1]));
                        System.out.println(result?"PRIME":"COMPOSITE");
                        break;
                    case "3":
                        result = isPalindrome().test(Integer.parseInt(testAndValue[1]));
                        System.out.println(result?"PALINDROME":"NON-PALINDROME");
                        break;
                    
                    default:
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static PerformOperation isOdd () {
        return x -> x%2 == 1;
    }

    PerformOperation isEven () {
        return x -> x%2 == 0;
    }

    static PerformOperation isPrime () {
        return (x)->{
            x = Math.abs(x);
            if (x == 2 || x == 3) return true;
            if (x == 1 || x % 2 == 0) return false;
            for (int i = 3; i*i <= x; i = i + 2) {
                if (x % i == 0) return false;                
            }

            return true;
        };
    }

    static PerformOperation isPalindrome () {
        return x -> {
            String str = x.toString();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == str.charAt(str.length() - 1 - i)) {
                    continue;
                } else return false;
            };
            return true;
        };
    }
}
