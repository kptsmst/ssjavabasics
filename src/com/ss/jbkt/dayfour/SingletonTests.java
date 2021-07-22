package com.ss.jbkt.dayfour;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SingletonTests {
    @Test
    public void testOnlyInstance () {
        DoubleCheckedSingleton dcs1 = DoubleCheckedSingleton.getInstance();
        DoubleCheckedSingleton dcs2 = DoubleCheckedSingleton.getInstance();
        DoubleCheckedSingleton dcs3 = DoubleCheckedSingleton.getInstance();
        assertEquals(dcs1, dcs2);
        assertEquals(dcs3, dcs2);
    }
}
