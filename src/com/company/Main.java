package com.company;

import java.io.*;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 1) { //TODO: possible extension to allow multiple file path arguments
            File input = new File(args[0]);
            FileHandler fileHandler = new FileHandler(input);
            try {
                fileHandler.readNamesFromFile();
            } catch (IOException e) {
                System.err.println("Unable to read file, check that the file path you have provided is correct");
                e.printStackTrace();
            }
            Collections.sort(fileHandler.getNameList(), String.CASE_INSENSITIVE_ORDER);
            try {
                fileHandler.writeOutputFile();
            } catch (IOException e) {
                System.err.println("Error occurred while trying to write new file");
                e.printStackTrace();
            }
        } else {
            System.out.println("Usage: name-sorter [file-path]");
        }
    }
}
