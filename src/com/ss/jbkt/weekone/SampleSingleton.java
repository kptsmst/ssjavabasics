package com.ss.jbkt.weekone;

//remove static
public class SampleSingleton {

    private static SampleSingleton instance = null;

    // add private constructor
    private SampleSingleton() {

    }

    // add if (instance == null) new Constructor() to singleton
    public static SampleSingleton getInstance() {
        if (instance == null)
            instance = new SampleSingleton();
        return instance;
    }

}
