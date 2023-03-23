package hexlet.code.formatters;

import hexlet.code.DifferenceValue;

import java.util.Map;


public class StylishFormatter implements FormatBuilder {

    @Override
    public String format(Map<String, DifferenceValue> data) {
        StringBuilder result = new StringBuilder();

        result.append("{\n");
        data.forEach((k, v) -> {
            switch (v.getStatus()) {
                case "updated" -> {
                    result.append(computeRow(k, v.getValue1(), "del"));
                    result.append(computeRow(k, v.getValue2(), "add"));
                }
                case "added" -> result.append(computeRow(k, v.getValue1(), "add"));
                case "removed" -> result.append(computeRow(k, v.getValue1(), "del"));
                default -> result.append(computeRow(k, v.getValue1()));
            }
        });
        result.append("}");

        return result.toString();
    }
    private static String computeRow(String key, Object value, String type) {
        return switch (type) {
            case "add" -> "  + %s: %s\n".formatted(key, value);
            case "del" -> "  - %s: %s\n".formatted(key, value);
            default -> "    %s: %s\n".formatted(key, value);
        };
    }
    private static String computeRow(String key, Object value) {
        return computeRow(key, value, "default");
    }
}
