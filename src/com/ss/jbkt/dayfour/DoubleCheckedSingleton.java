package com.ss.jbkt.dayfour;

public class DoubleCheckedSingleton {

    // only instance of double checked singleton that should exist;
    private static volatile DoubleCheckedSingleton onlyDCS;

    // method to get the singleton
    public static DoubleCheckedSingleton getInstance() {
        if (onlyDCS == null) {
            synchronized (DoubleCheckedSingleton.class) {
                if (onlyDCS == null) {
                    onlyDCS = new DoubleCheckedSingleton();
                }
            }
        }
        return onlyDCS;
    }

    private DoubleCheckedSingleton() {
        // private keyword on consturctor to make sure it can't be called elsewhere
    }

}
