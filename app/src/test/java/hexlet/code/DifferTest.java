package hexlet.code;


import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DifferTest {
    @Test
    public void generateDiffJsonTest() throws Exception {
        var filePath1 = "src/test/resources/json/file1.json";
        var filePath2 = "src/test/resources/json/file2.json";

        Path expectedFilePath = Path.of("src/test/resources/expectedStylish").toAbsolutePath();
        var expected = Files.readString(expectedFilePath).trim();
        assertEquals(expected, Differ.generate(filePath1, filePath2));
    }
}
