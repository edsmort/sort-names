package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    public List<String> readNamesFromFile(BufferedReader reader) throws IOException {
        List<String> nameList = new ArrayList<String>();
        reader.lines().forEach(nameList::add);
        reader.close();
        return nameList;
    }

    public void writeOutputFile(Writer writer, List<String> nameList) throws IOException {
        int i = 0;
        for (String name: nameList) {
            if (i++ == nameList.size() - 1) {
                writer.write(name);
            } else {
                writer.write(name + System.lineSeparator());
            }
        }
        writer.close();
    }
}
