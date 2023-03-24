package hexlet.code.formatters;

public class Formatter {
    public static FormatBuilder getFormatter(String format) {
        return switch (format) {
            case "plain" -> new PlainFormatter();
            case "json" -> new JsonFormatter();
            default -> new StylishFormatter();
        };
    }

}
