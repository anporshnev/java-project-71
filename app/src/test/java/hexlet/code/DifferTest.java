package hexlet.code;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DifferTest {
    private final String JSON_FILE_PATH_1 = "src/test/resources/json/file1.json";
    private final String JSON_FILE_PATH_2 = "src/test/resources/json/file2.json";
    private final String YAML_FILE_PATH_1 = "src/test/resources/yaml/file1.yml";
    private final String YAML_FILE_PATH_2 = "src/test/resources/yaml/file2.yml";

    private static String expectedStylish;
    private static String expectedPlain;

    @BeforeAll
    public static void initExpected() throws IOException {
        Path expectedStylishFilePath = Path.of("src/test/resources/expectedStylish").toAbsolutePath();
        Path expectedPlainFilePath = Path.of("src/test/resources/expectedPlain").toAbsolutePath();
        expectedStylish = Files.readString(expectedStylishFilePath).trim();
        expectedPlain = Files.readString(expectedPlainFilePath).trim();
    }

    @Test
    public void generateDiffJsonToStylishTest() throws Exception {
        assertEquals(expectedStylish, Differ.generate(JSON_FILE_PATH_1, JSON_FILE_PATH_2, "stylish"));
    }

    @Test
    public void generateDiffYamlToStylishTest() throws Exception {
        assertEquals(expectedStylish, Differ.generate(YAML_FILE_PATH_1, YAML_FILE_PATH_2, "stylish"));
    }

    @Test
    public void generateDiffJsonToPlainTest() throws Exception {
        assertEquals(expectedPlain, Differ.generate(JSON_FILE_PATH_1, JSON_FILE_PATH_2, "plain"));
    }

    @Test
    public void generateDiffYamlToPlainTest() throws Exception {
        assertEquals(expectedPlain, Differ.generate(YAML_FILE_PATH_1, YAML_FILE_PATH_2, "stylish"));
    }
}
