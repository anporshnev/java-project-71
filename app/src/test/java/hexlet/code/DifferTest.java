package hexlet.code;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DifferTest {
    static String expectedStylish;

    @BeforeAll
    public static void initExpected() throws IOException {
        Path expectedFilePath = Path.of("src/test/resources/expectedStylish").toAbsolutePath();
        expectedStylish = Files.readString(expectedFilePath).trim();
    }
    @Test
    public void generateDiffJsonToStylishTest() throws Exception {
        var filePath1 = "src/test/resources/json/file1.json";
        var filePath2 = "src/test/resources/json/file2.json";

        assertEquals(expectedStylish, Differ.generate(filePath1, filePath2, "stylish"));
    }
    @Test
    public void generateDiffYamlToStylishTest() throws Exception {
        var filePath1 = "src/test/resources/yaml/file1.yml";
        var filePath2 = "src/test/resources/yaml/file2.yml";

        assertEquals(expectedStylish, Differ.generate(filePath1, filePath2, "stylish"));
    }
}
