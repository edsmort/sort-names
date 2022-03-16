package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    File inputFile;
    List<String> nameList;

    public FileHandler(File inputFile) {
        this.inputFile = inputFile ;
        this.nameList = new ArrayList<String>();
    }

    public void readNamesFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(this.inputFile));
        reader.lines().forEach(name -> this.nameList.add(name));
        reader.close();
    }

    public void writeOutputFile() throws IOException {
        String outputFilename = inputFile.getName().replaceAll(".txt","-sorted.txt");
        FileWriter writer = new FileWriter(outputFilename);
        for (String name: this.nameList) {
            writer.write(name + System.lineSeparator());
        }
        writer.close();
    }

    public List<String> getNameList() {
        return this.nameList;
    }

}
