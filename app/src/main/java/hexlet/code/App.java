package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;


@Command(
        name = "gendiff",
        mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference."
)

public class App {
    public static void main(String[] args) {
        var line = new CommandLine(new App()).execute(args);
        System.exit(line);
    }
}
