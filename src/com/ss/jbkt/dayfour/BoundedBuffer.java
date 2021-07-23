package com.ss.jbkt.dayfour;


public class BoundedBuffer {
    //bounded buffer data;
    int bufferSize = 20;
    int buffer[] = new int[bufferSize];
    int nextWrite = 0;
    int nextRead = 0;
    int count = 0;   

    //bounded buffer put
    public synchronized void bufferPut(int toPut) throws InterruptedException{
        //wait for notify if buffer is full;
        while (count == bufferSize) {
            System.out.println("Buffer put waiting on open space");
            wait();
        }
        //write to buffer
        buffer[nextWrite] = toPut;
        
        //increment next write, reset to 0 if nextWrite == buffersize
        // nextWrite = nextWrite + 1;
        // if (nextWrite == bufferSize) nextWrite = 0;
        //probably more efficient? not sure!
        nextWrite = (nextWrite + 1) % bufferSize;
        
        //increment counter;
        count = count + 1;

        //wake sleeping threads;
        notifyAll();
    }

    //bounded buffer get
    public synchronized int bufferGet() throws InterruptedException {
        //wait for notify if buffer is empty;
        while (count == 0) {
            System.out.println("Buffer get waiting on input");
            wait();
        }
        //read from buffer;
        int toGet = buffer[nextRead];

        //increment nextRead, reseting on max size, decrement count
        nextRead = (nextRead + 1) % bufferSize;
        count --;

        //wake sleeping threads
        notifyAll();

        //return value;
        return toGet;
    }
}
