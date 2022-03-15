package com.company;

import java.io.*;

public class Main {
    public static NameList generateNameList(File input) throws FileNotFoundException {
        NameList names = new NameList();
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

    public static void main(String[] args) {
        if (args.length == 1) { //TODO: allow multiple file path arguments
            File input = new File(args[0]);
            try {
                NameList unsorted = generateNameList(input);
                System.out.println(unsorted.toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Usage: name-sorter [file-path]");
        }
    }
}
