package com.ss.jbkt.dayfour;

public class Deadlocker {
    public static void StartDeadlock() {
        Integer lockOne = 4;
        Integer lockTwo = 2;


        //very simple process for the thread. aquire a lock on one, sleep, aquire a lock on two
        //all while printing status messages. threadTwo, however, will stop this from working
        Runnable threadOne = new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (lockOne) {
                        System.out.println("Inside first lock of threadOne, sleeping");
                        Thread.sleep(100);
                        synchronized (lockTwo) {
                            System.out.println("Inside both locks of threadOne");
                        }
                        System.out.println("Deadlock over!");
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        };

        //this runnable gets the second lock, sleeps, then tries to get the first
        //because the last thread is doing the opposite, there's almost no possible
        //way for either thread to aquire both locks.
        //We'll see the first syso print for each thread, but nothing more
        Runnable threadTwo = new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (lockTwo) {
                        System.out.println("Inside first lock of threadTwo, sleeping");
                        Thread.sleep(100);
                        synchronized (lockOne) {
                            System.out.println("Inside both locks of threaTwo");
                        }
                        System.out.println("Deadlock over!");
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        };

        Thread t1 = new Thread(threadOne); 
        t1.start();
        Thread t2 = new Thread(threadTwo);
        t2.start();
        
        //this stops the startDeadlock function from returning until the other two thread have finished
        while (t1.isAlive() || t2.isAlive()) {
            System.out.println("Status of thread one: " + t1.getState().toString());
            System.out.println("Status of thread two: " + t1.getState().toString());
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
    }
}
