package com.ss.jbkt.dayfour;

public class AssignmentOne {
    public static void main(String[] args){
        DoubleCheckedSingleton dcs1 = DoubleCheckedSingleton.getInstance();
        DoubleCheckedSingleton dcs2 = DoubleCheckedSingleton.getInstance();
        boolean areSame = dcs1 == dcs2;
        System.out.println("Both instances of the singleton are the same: " + areSame);
    }
}
