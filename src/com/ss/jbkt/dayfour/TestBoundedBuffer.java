package com.ss.jbkt.dayfour;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestBoundedBuffer {
    
    @Test
    public void testPut () {
        BoundedBuffer bb = new BoundedBuffer();
        try {
            bb.bufferPut(3);
            bb.bufferPut(6);
            bb.bufferPut(9);
        } catch (Exception e) {
            //TODO: handle exception
        }
        assertEquals(bb.buffer[0], 3);
        assertEquals(bb.buffer[1], 6);
        assertEquals(bb.buffer[2], 9);
    }

    @Test
    public void testGet () {
        BoundedBuffer bb = new BoundedBuffer();
        try {
            bb.bufferPut(3);
            bb.bufferPut(6);
            bb.bufferPut(9);
            assertEquals(bb.bufferGet(), 3);
            assertEquals(bb.bufferGet(), 6);
            assertEquals(bb.bufferGet(), 9);
        } catch (Exception e) {
            System.out.println("Test failed");
            //TODO: handle exception
        }
    }
}
