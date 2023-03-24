package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.DifferenceValue;

import java.util.Map;

public interface FormatBuilder {
    String format(Map<String, DifferenceValue> data) throws JsonProcessingException;
}
