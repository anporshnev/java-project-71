package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.DifferenceValue;

import java.util.Map;

public class JsonFormatter implements FormatBuilder {
    @Override
    public String format(Map<String, DifferenceValue> data) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(data);
    }
}
