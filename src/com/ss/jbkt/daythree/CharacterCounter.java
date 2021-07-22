package com.ss.jbkt.daythree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CharacterCounter {
    public static int countCharacterInFile(String sourceFile, char characterToMatch) {
        int count = 0;
        //try to open file
        try (BufferedReader buf = new BufferedReader(new FileReader(sourceFile))) {
            String line;
            //iterate over lines until file is completely read
            while ((line = buf.readLine()) != null) {
                //iterate over string looking for matching characters
                for (int charIndex = 0; charIndex < line.length(); charIndex++) {
                    if (line.charAt(charIndex) == characterToMatch) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}
