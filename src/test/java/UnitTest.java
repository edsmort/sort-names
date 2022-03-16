import com.company.FileHandler;
import org.junit.jupiter.api.Assertions;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class UnitTest {
    public static final List<String> TEST_NAME_LIST = Arrays.asList("BAKER, THEODORE", "SMITH, ANDREW", "sMITH, AAron", "KENT, MADISON", "SMITH, FREDRICK");

    @org.junit.jupiter.api.Test
    public void readNamesFromValidList() throws IOException {
        // Creates a mock buffered reader from the list
        BufferedReader reader = new BufferedReader(new StringReader(String.join("\n", TEST_NAME_LIST)));
        FileHandler testFileHandler = new FileHandler();
        List<String> nameList = testFileHandler.readNamesFromFile(reader);
        Assertions.assertIterableEquals(TEST_NAME_LIST, nameList);
    }

    @org.junit.jupiter.api.Test
    public void readFromEmptyList() throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader(""));
        FileHandler testFileHandler = new FileHandler();
        List<String> nameList = testFileHandler.readNamesFromFile(reader);
    }

    @org.junit.jupiter.api.Test
    public void namesWrittenCorrectly() throws IOException {
        StringWriter writer = new StringWriter();
        FileHandler testFileHandler = new FileHandler();
        testFileHandler.writeOutputFile(writer, TEST_NAME_LIST);
        String expected = String.join("\n", TEST_NAME_LIST);
        Assertions.assertEquals(expected, writer.toString());
    }

}