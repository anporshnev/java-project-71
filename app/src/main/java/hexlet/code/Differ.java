package hexlet.code;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import hexlet.code.formatters.Formatter;
import hexlet.code.parsers.Parser;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        Map<String, Object> data1 = Parser.getData(filepath1);
        Map<String, Object> data2 = Parser.getData(filepath2);

        var diff = computeDiff(data1, data2);
        var formatter = Formatter.getFormatter(format);
        return formatter.format(diff);
    }

    public static Map<String, DifferenceValue> computeDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Map<String, DifferenceValue> diff = new TreeMap<>();
        Set<String> keys = new HashSet<>(data1.keySet());
        keys.addAll(data2.keySet());

        for (String key: keys) {
            var value1 = data1.get(key);
            var value2 = data2.get(key);
            if (data1.containsKey(key) && data2.containsKey(key)) {
                if (Objects.equals(value1, value2)) {
                    diff.put(key, new DifferenceValue("unchanged", value1));
                } else {
                    diff.put(key, new DifferenceValue("changed", value1, value2));
                }
            } else if (data1.containsKey(key)) {
                diff.put(key, new DifferenceValue("deleted", value1));
            } else {
                diff.put(key, new DifferenceValue("added", value2));
            }
        }
        return diff;
    }
}
