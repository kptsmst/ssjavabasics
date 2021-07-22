package com.ss.jbkt.daythree;

import java.io.File;

public class DirectoryPrinter {
    //get the directory the java program is ran from
    public static String getCWD() {
        return System.getProperty("user.dir");
    }

    //gets a file reference to the current directory
    public static File getCurrentFile() {
        File f = new File(".");
        return f;
    }

    //recursive function that prints directory and file names
    //if the file is a directory, it then calls printFileContents on that directory
    //uses the depth variable to indent printing for readability
    public static void printFileContents(File f, int depth) {
        File[] files = f.listFiles();
        String leadingSpaces = new String(new char[depth]).replace('\0', ' ');
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println(leadingSpaces + "Directory " + file.getName());
                printFileContents(file, depth+1);
            } else {
                System.out.println(leadingSpaces + "File " + file.getName());
            }
        }
    }
}
