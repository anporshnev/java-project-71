package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Differ {
    public static String generate(String filepath1, String filepath2) throws Exception {
        Map<String, Object> data1 = getData(filepath1);
        Map<String, Object> data2 = getData(filepath2);

        StringBuilder result = new StringBuilder();
        result.append("{\n");
        Set<String> keys = new TreeSet<>(data1.keySet());
        keys.addAll(data2.keySet());

        for (String item: keys) {
            if (data1.containsKey(item) && data2.containsKey(item)) {
                if (data1.get(item).equals(data2.get(item))) {
                    result.append("    %s: %s\n".formatted(item, data1.get(item)));
                } else {
                    result.append(computeDiffItem(item, data1.get(item), "del"));
                    result.append(computeDiffItem(item, data2.get(item), "add"));
                }
            } else if (data1.containsKey(item)) {
                result.append(computeDiffItem(item, data1.get(item), "del"));
            } else {
                result.append(computeDiffItem(item, data2.get(item), "add"));
            }
        }
        result.append("}");
        return result.toString();
    }

    private static String getFileContent(String filepath) throws Exception {
        Path path = Paths.get(filepath).toAbsolutePath().normalize();
        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }
        return Files.readString(path);
    }

    private static Map<String, Object> getData(String filepath) throws Exception {
        var content = getFileContent(filepath);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(content, new TypeReference<>() { });
    }

    private static String computeDiffItem(String key, Object value, String type) {
        String result = "";
        if (type.equals("add")) {
            result = "  + %s: %s\n".formatted(key, value);
        }
        if (type.equals("del")) {
            result = "  - %s: %s\n".formatted(key, value);
        }
        return result;
    }
}
