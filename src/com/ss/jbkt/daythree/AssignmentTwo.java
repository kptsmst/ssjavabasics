package com.ss.jbkt.daythree;

public class AssignmentTwo {
    public static void main(String[] args){
        FileAppender aFileAppender= new FileAppender();
        aFileAppender.runBuffStreamAppend("resources/input/input.txt", "resources/output/appendMe.txt");
    }
}
