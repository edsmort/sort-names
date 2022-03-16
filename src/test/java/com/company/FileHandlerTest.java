package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileHandlerTest {
    public static final String VALID_TEST_FILE_PATH = "src/test/resources/test-names.txt";
    public static final String INVALID_TEST_FILE_PATH = "src/test/resources/non-existent.txt";
    public static final List<String> TEST_NAME_LIST = Arrays.asList("BAKER, THEODORE", "SMITH, ANDREW", "sMITH, AAron", "KENT, MADISON", "SMITH, FREDRICK");
    public static final String OUTPUT_FILE_NAME = "output-test.txt";


    @org.junit.jupiter.api.Test
    public void readNamesFromValidFilePath() throws IOException {
        File testFile = new File(VALID_TEST_FILE_PATH);
        FileHandler testFileHandler = new FileHandler();
        List<String> nameList = new ArrayList<String>();
        nameList = testFileHandler.readNamesFromFile(testFile);
        Assertions.assertIterableEquals(TEST_NAME_LIST, nameList);
    }

    @org.junit.jupiter.api.Test
    public void readNamesFromInvalidFilePath() {
        File testFile = new File(INVALID_TEST_FILE_PATH);
        FileHandler testFileHandler = new FileHandler();
        Assertions.assertThrows(IOException.class, () -> {
            testFileHandler.readNamesFromFile(testFile);
        });
    }

    @org.junit.jupiter.api.Test
    public void writeEmptyOutputFile() throws IOException {
        FileHandler testFileHandler = new FileHandler();
        List<String> emptyList = new ArrayList<String>();
        testFileHandler.writeOutputFile(OUTPUT_FILE_NAME, emptyList);
        File newFile = new File(OUTPUT_FILE_NAME);
        Assertions.assertTrue(newFile.exists());
        newFile.delete();
    }

    @org.junit.jupiter.api.Test
    public void confirmOutputFileContents() throws IOException {
        FileHandler testFileHandler = new FileHandler();
        testFileHandler.writeOutputFile(OUTPUT_FILE_NAME, TEST_NAME_LIST);
        File newFile = new File(OUTPUT_FILE_NAME);
        List<String> actualNameList = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader(newFile));
        reader.lines().forEach(actualNameList::add);
        reader.close();
        newFile.delete();
        Assertions.assertIterableEquals(TEST_NAME_LIST, actualNameList);
    }
}