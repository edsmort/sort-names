package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static List<String> generateNameList(File input) throws FileNotFoundException {
        List<String> names = new ArrayList<String>();
        String name;
        BufferedReader reader = new BufferedReader(new FileReader(input));
        try {
            while ((name = reader.readLine()) != null) {
                names.add(name);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return names;
    }

    public static void writeToFile(String fileName, List<String> nameList) {
        String newFilename = fileName.replaceAll(".txt","-sorted.txt");
        try {
            FileWriter writer = new FileWriter(newFilename);
            for (String name: nameList) {
                writer.write(name + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length == 1) { //TODO: allow multiple file path arguments
            File input = new File(args[0]);
            try {
                List<String> nameList = generateNameList(input);
                Collections.sort(nameList);
                writeToFile(input.getName(), nameList);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Usage: name-sorter [file-path]");
        }
    }
}
