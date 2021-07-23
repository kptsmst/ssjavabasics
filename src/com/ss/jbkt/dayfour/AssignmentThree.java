package com.ss.jbkt.dayfour;

public class AssignmentThree {
    public static void main(String[] args) {
        //buffer creation call
        BoundedBuffer buffer = new BoundedBuffer();

        //producer thread
        Runnable producer = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Producer entering put loop");
                    for (int i = 0; i < 100; i++) {
                        buffer.bufferPut(i);
                        System.out.println("Wrote: " + String.valueOf(i));
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        };

        //consumer thread
        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                try {
                    //sleeps for 1s at start to allow consumer to fill the bounded buffer
                    Thread.sleep(1000);
                    System.out.println("Consumer entering get loop");
                    for (int i = 0; i < 100; i++) {
                        int got = buffer.bufferGet();
                        System.out.println("Read: " + String.valueOf(got));
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        };

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();

    }
}