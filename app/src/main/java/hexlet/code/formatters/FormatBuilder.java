package hexlet.code.formatters;

import hexlet.code.DifferenceValue;

import java.util.Map;

public interface FormatBuilder {
    String format(Map<String, DifferenceValue> data);
}
