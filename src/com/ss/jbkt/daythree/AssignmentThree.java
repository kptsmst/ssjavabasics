package com.ss.jbkt.daythree;

public class AssignmentThree {
    public static void main(String[] args) {
        char charToFind;
        if (args.length > 0) {
            charToFind = args[0].charAt(0);
        } else {
            charToFind = 'i';
        }
        System.out.println(args[0]);
        String fileToRead = "resources/input/input1.txt";
        int found = CharacterCounter.countCharacterInFile(fileToRead, charToFind);
        System.out.println(String.valueOf(found) + " instances of " + charToFind + " found in " + fileToRead);
    }
}