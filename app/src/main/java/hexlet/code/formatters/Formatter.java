package hexlet.code.formatters;

public class Formatter {
    public static FormatBuilder getFormatter(String format) {
        return switch (format) {
            case "plain" -> new PlainFormatter();
            default -> new StylishFormatter();
        };
    }

}
