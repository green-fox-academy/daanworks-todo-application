import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ArgumentHandler extends ToDoService {

    public void handleArgument(String[] arguments) {
        if (arguments.length == 0) {
            System.out.println(getInstructions());
        } else {
            switch (arguments[0]) {
                case "-l": {
                    listTasks();
                    break;
                }
                case "-a": {
                    if (arguments.length == 1) {
                        System.out.println("Unable to add: no task provided!");
                    } else {
                        addTask(arguments[1]);
                    }
                    break;
                }
                case "-r": {
                    if (arguments.length == 1) {
                        System.out.println("Unable to remove: no task provided!");
                    } else {
                        removeTask(arguments[1]);
                    }
                    break;
                }
                case "-c": {
                    System.out.println("Completing a task...");
                    break;
                }
                case "-cr": {
                    System.out.println(getCredits());
                    break;
                }
                default: {
                    System.out.println("Unsupported argument");
                    listTasks();
                    break;
                }
            }
        }
    }

    public String getInstructions() {
        Path instructionPath = Paths.get("../data/instructions");
        List<String> content = new ArrayList<>();
        try {
            content = Files.readAllLines(instructionPath);
        } catch (IOException e) {
            System.out.println("Instructions are not available :(");
        }
        StringBuilder contentAsString = new StringBuilder();
        for (String line: content) {
            contentAsString.append(line);
            contentAsString.append("\n");
        }
        return contentAsString.toString();
    }

    public String getCredits() {
        Path creditsPath = Paths.get("../data/credits");
        List<String> content = new ArrayList<>();
        try {
            content = Files.readAllLines(creditsPath);
        } catch (IOException e) {
            System.out.println("Credits are not available :(");
        }
        StringBuilder contentAsString = new StringBuilder();
        for (String line: content) {
            contentAsString.append(line);
            contentAsString.append("\n");
        }
        return contentAsString.toString();
    }
}
