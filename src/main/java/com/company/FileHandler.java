package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    public List<String> readNamesFromFile(File input) throws IOException {
        List<String> nameList = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader(input));
        reader.lines().forEach(nameList::add);
        reader.close();
        return nameList;
    }

    public void writeOutputFile(String outputFilename, List<String> nameList) throws IOException {
        FileWriter writer = new FileWriter(outputFilename);
        for (String name: nameList) {
            writer.write(name + System.lineSeparator());
        }
        writer.close();
    }
}
