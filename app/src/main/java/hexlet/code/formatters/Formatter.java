package hexlet.code.formatters;

public class Formatter {
    public static FormatBuilder getFormatter(String format) {
        return new StylishFormatter();
    }

}