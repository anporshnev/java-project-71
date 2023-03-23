package hexlet.code.formatters;

import hexlet.code.DifferenceValue;
import org.apache.commons.lang3.ClassUtils;

import java.util.Map;



public class PlainFormatter implements FormatBuilder {
    @Override
    public String format(Map<String, DifferenceValue> data) {
        StringBuilder result = new StringBuilder();
        data.forEach((k, v) -> {
            if (v.getStatus().equals("unchanged")) {
                return;
            }
            result.append(computeRow(k, v));
        });

        return result.toString().trim();
    }

    private static String computeRow(String key, DifferenceValue value) {
        return "Property '%s' was %s%s\n".formatted(key, value.getStatus(), getChanges(value));
    }

    private static String getChanges(DifferenceValue value) {
        var value1 = checkValue(value.getValue1());
        var value2 = checkValue(value.getValue2());

        return switch (value.getStatus()) {
            case "updated" -> ". From %s to %s".formatted(value1, value2);
            case "added" -> " with value: %s".formatted(value1);
            default -> "";
        };
    }
    private static Object checkValue(Object value) {
        if (value == null) {
            return "null";
        }
        if (ClassUtils.isPrimitiveOrWrapper(value.getClass())) {
            return value;
        }
        if (value instanceof String) {
            return "'%s'".formatted(value);
        }
        return "[complex value]";
    }
}
