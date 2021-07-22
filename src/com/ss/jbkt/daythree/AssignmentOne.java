package com.ss.jbkt.daythree;

import java.io.File;

public class AssignmentOne {
    public static void main(String[] args) {
        System.out.println("Starting printing in " + DirectoryPrinter.getCWD());
        File cwd = DirectoryPrinter.getCurrentFile();
        DirectoryPrinter.printFileContents(cwd, 0);
    }
}
