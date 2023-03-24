package hexlet.code;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DifferTest {
    private final String jsonFilePath1 = "src/test/resources/json/file1.json";
    private final String jsonFilePath2 = "src/test/resources/json/file2.json";
    private final String yamlFilePath1 = "src/test/resources/yaml/file1.yml";
    private final String yamlFilePath2 = "src/test/resources/yaml/file2.yml";
    private static String expectedStylish;
    private static String expectedPlain;
    private static String expectedJson;

    @BeforeAll
    public static void initExpected() throws IOException {
        Path expectedStylishFilePath = Path.of("src/test/resources/expectedStylish").toAbsolutePath();
        Path expectedPlainFilePath = Path.of("src/test/resources/expectedPlain").toAbsolutePath();
        Path expectedJsonFilePath = Path.of("src/test/resources/expectedJson.json").toAbsolutePath();
        expectedStylish = Files.readString(expectedStylishFilePath).trim();
        expectedPlain = Files.readString(expectedPlainFilePath);
        expectedJson = Files.readString(expectedJsonFilePath);
    }

    @Test
    public void generateDiffJsonToStylishTest() throws Exception {
        assertEquals(expectedStylish, Differ.generate(jsonFilePath1, jsonFilePath2));
    }

    @Test
    public void generateDiffYamlToStylishTest() throws Exception {
        assertEquals(expectedStylish, Differ.generate(yamlFilePath1, yamlFilePath2));
    }

    @Test
    public void generateDiffJsonToPlainTest() throws Exception {
        assertEquals(expectedPlain, Differ.generate(jsonFilePath1, jsonFilePath2, "plain"));
    }

    @Test
    public void generateDiffYamlToPlainTest() throws Exception {
        assertEquals(expectedPlain, Differ.generate(yamlFilePath1, yamlFilePath2, "plain"));
    }

    @Test
    public void generateDiffJsonToJsonTest() throws Exception {
        assertEquals(expectedJson, Differ.generate(jsonFilePath1, jsonFilePath2, "json"));
    }

    @Test
    public void generateDiffYamlToJsonTest() throws Exception {
        assertEquals(expectedJson, Differ.generate(yamlFilePath1, yamlFilePath2, "json"));
    }
}
