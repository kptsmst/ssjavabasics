package com.ss.jbkt.daythree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Collectors;

public class FileAppender {

    //takes all the content from source file and appends it to destination file
    public void runBuffStreamAppend(String source, String destination) {
        String relativePath = source;
        try (BufferedReader buf = new BufferedReader(new FileReader(relativePath))) {
            //modified from pramod's function to get all lines, and replace newline characters, and in append mode
            Files.write(Paths.get(destination), buf.lines().collect(Collectors.joining(System.lineSeparator())).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
