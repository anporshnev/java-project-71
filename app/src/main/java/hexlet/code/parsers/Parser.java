package hexlet.code.parsers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {
    public static String getFileContent(String filepath) throws Exception {
        Path path = Paths.get(filepath).toAbsolutePath().normalize();
        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }
        return Files.readString(path);
    }
    public static Map<String, Object> getData(String filepath) throws Exception {
        var content = getFileContent(filepath);
        var parser = getParser(getFileExtension(filepath));
        return parser.parse(content);
    }
    private static String getFileExtension(String path) throws Exception {
        if (path.lastIndexOf(".") != -1) {
            return path.substring(path.lastIndexOf(".") + 1);
        } else {
            throw new Exception("Unknown file extension");
        }
    }
    private static DataGenerator getParser(String extension) throws Exception {
        switch (extension) {
            case "json" -> {
                return new JsonParser();
            }
            case "yml" -> {
                return new YamlParser();
            }
            default -> throw new Exception("Unsupported file extension");
        }
    }
}
