package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileHandlerTest {
    public static final String TEST_FILE_PATH = "src/test/resources/test-names.txt";
    public static final List<String> TEST_NAME_LIST = Arrays.asList("BAKER, THEODORE", "SMITH, ANDREW", "sMITH, AAron", "KENT, MADISON", "SMITH, FREDRICK");


    @org.junit.jupiter.api.Test
    public void readNamesFromValidFilePath() {
        File testFile = new File(TEST_FILE_PATH);
        FileHandler testFileHandler = new FileHandler();
        List<String> nameList = new ArrayList<String>();
        try {
            nameList = testFileHandler.readNamesFromFile(testFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assertions.assertIterableEquals(TEST_NAME_LIST, nameList);
    }

    @org.junit.jupiter.api.Test
    public void readNamesFromInvalidFilePath() {

    }

    @org.junit.jupiter.api.Test
    public void writeOutputFile() {
    }
}