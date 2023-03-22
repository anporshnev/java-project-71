package hexlet.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import hexlet.code.parsers.Parser;

public class Differ {
    public static String generate(String filepath1, String filepath2) throws Exception {
        Map<String, Object> data1 = Parser.getData(filepath1);
        Map<String, Object> data2 = Parser.getData(filepath2);

        computeDiff(data1, data2);

//        StringBuilder result = new StringBuilder();
//        result.append("{\n");
//        Set<String> keys = new TreeSet<>(data1.keySet());
//        keys.addAll(data2.keySet());
//
//        for (String item: keys) {
//            if (data1.containsKey(item) && data2.containsKey(item)) {
//                if (data1.get(item).equals(data2.get(item))) {
//                    result.append("    %s: %s\n".formatted(item, data1.get(item)));
//                } else {
//                    result.append(computeDiffItem(item, data1.get(item), "del"));
//                    result.append(computeDiffItem(item, data2.get(item), "add"));
//                }
//            } else if (data1.containsKey(item)) {
//                result.append(computeDiffItem(item, data1.get(item), "del"));
//            } else {
//                result.append(computeDiffItem(item, data2.get(item), "add"));
//            }
//        }
//        result.append("}");
//        return result.toString();
        return "";
    }

    public static Map<String, DifferenceValue> computeDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Map<String, DifferenceValue> diff = new HashMap<>();
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

//    private static String computeDiffItem(String key, Object value, String type) {
//        String result = "";
//        if (type.equals("add")) {
//            result = "  + %s: %s\n".formatted(key, value);
//        }
//        if (type.equals("del")) {
//            result = "  - %s: %s\n".formatted(key, value);
//        }
//        return result;
//    }
}
