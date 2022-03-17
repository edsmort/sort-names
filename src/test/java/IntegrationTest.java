import com.company.FileHandler;
import com.company.Main;
import org.junit.jupiter.api.Assertions;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegrationTest {
    public static final String FILE_NAME = "test-names";
    public static final String VALID_TEST_FILE_PATH = "src/test/resources/" + FILE_NAME + ".txt";
    public static final String INVALID_TEST_FILE_PATH = "src/test/resources/non-existent.txt";
    public static final List<String> TEST_NAME_LIST = Arrays.asList("BAKER, THEODORE", "SMITH, ANDREW", "sMITH, AAron", "KENT, MADISON", "SMITH, FREDRICK");
    public static final List<String> SORTED_TEST_NAME_LIST = Arrays.asList("BAKER, THEODORE","KENT, MADISON", "sMITH, AAron", "SMITH, ANDREW", "SMITH, FREDRICK");
    public static final String OUTPUT_FILE_NAME = "output-test.txt";

    @org.junit.jupiter.api.Test
    public void validEndToEndTest() throws IOException {
        Main.main(new String[] {VALID_TEST_FILE_PATH});
        File sorted = new File(FILE_NAME + "-sorted.txt");
        BufferedReader reader = new BufferedReader(new FileReader(sorted));
        FileHandler testFileHandler = new FileHandler();
        List<String> nameList = testFileHandler.readNamesFromFile(reader);
        Assertions.assertIterableEquals(SORTED_TEST_NAME_LIST, nameList);
        sorted.delete();
    }

    @org.junit.jupiter.api.Test
    public void invalidFilePathEndToEndTest() throws IOException {
        Exception e = Assertions.assertThrows(IOException.class, () -> {
            Main.main(new String[] {INVALID_TEST_FILE_PATH});
        });
        String expectedMessage = INVALID_TEST_FILE_PATH + " (No such file or directory)";
        Assertions.assertTrue(e.getMessage().equals(expectedMessage));
    }

    @org.junit.jupiter.api.Test
    public void multipleArgumentsTest() throws FileNotFoundException {
        ByteArrayOutputStream stdOutCapture = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdOutCapture));
        Main.main(new String[] {VALID_TEST_FILE_PATH, "second"});
        Assertions.assertEquals("Usage: name-sorter [file-path]\n", stdOutCapture.toString());
        System.setOut(System.out);
    }

    @org.junit.jupiter.api.Test
    public void readNamesFromValidFilePath() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(VALID_TEST_FILE_PATH));
        FileHandler testFileHandler = new FileHandler();
        List<String> nameList = testFileHandler.readNamesFromFile(reader);
        Assertions.assertIterableEquals(TEST_NAME_LIST, nameList);
    }

    @org.junit.jupiter.api.Test
    public void writeEmptyOutputFile() throws IOException {
        FileHandler testFileHandler = new FileHandler();
        List<String> emptyList = new ArrayList<String>();
        FileWriter writer = new FileWriter(OUTPUT_FILE_NAME);
        testFileHandler.writeOutputFile(writer, emptyList);
        File newFile = new File(OUTPUT_FILE_NAME);
        Assertions.assertTrue(newFile.exists());
        newFile.delete();
    }

    @org.junit.jupiter.api.Test
    public void confirmOutputFileContents() throws IOException {
        FileHandler testFileHandler = new FileHandler();
        FileWriter writer = new FileWriter(OUTPUT_FILE_NAME);
        testFileHandler.writeOutputFile(writer, TEST_NAME_LIST);
        File newFile = new File(OUTPUT_FILE_NAME);
        List<String> actualNameList = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader(newFile));
        reader.lines().forEach(actualNameList::add);
        reader.close();
        newFile.delete();
        Assertions.assertIterableEquals(TEST_NAME_LIST, actualNameList);
    }
}