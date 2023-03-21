package hexlet.code.parsers;

import java.util.Map;

public interface DataGenerator {
    Map<String, Object> parse(String content) throws Exception;
}
