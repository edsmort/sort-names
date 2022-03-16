package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static List<String> nameList;

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 1) { //TODO: possible extension to allow multiple file path arguments
            File input = new File(args[0]);
            FileHandler fileHandler = new FileHandler();
            try {
                nameList = fileHandler.readNamesFromFile(input);
            } catch (IOException e) {
                System.err.println("Unable to read file, check that the file path you have provided is correct");
                e.printStackTrace();
            }
            nameList.sort(String.CASE_INSENSITIVE_ORDER);
            try {
                String outputFilename = input.getName().replaceAll(".txt","-sorted.txt");
                fileHandler.writeOutputFile(outputFilename, nameList);
            } catch (IOException e) {
                System.err.println("Error occurred while trying to write new file");
                e.printStackTrace();
            }
        } else {
            System.out.println("Usage: name-sorter [file-path]");
        }
    }
}
