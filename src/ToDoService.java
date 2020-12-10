import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ToDoService {

    static Path tasksPath = Paths.get("../data/tasks.txt");
    static List<String> taskList;

    public static List<String> readFromFile() {
        taskList = new ArrayList<>();
        try {
            taskList = Files.readAllLines(tasksPath);
            return taskList;
        } catch (IOException e) {
            System.out.println("File is not available :(");
            return taskList;
        }
    }

    public static void writeToFile() {
        try {
            Files.write(tasksPath, taskList);
        } catch (IOException e) {
            System.out.println("File is not available :(");
        }
    }

    public static void removeTask(String indexToRemove) {
        try {
            int indexToRemoveInt = Integer.parseInt(indexToRemove);
            taskList = new ArrayList<>();
            readFromFile();
            taskList.remove(indexToRemoveInt - 1);
            writeToFile();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Unable to remove: index is out of bound");
        } catch (NumberFormatException e) {
            System.out.println("Unable to remove: index is not a number");
        }
    }

    public static void addTask(String task) {
        taskList = new ArrayList<>();
        readFromFile();
        taskList.add(task);
        writeToFile();
    }

    public static void listTasks() {
        taskList = new ArrayList<>();
        readFromFile();
        if (taskList.isEmpty()) {
            System.out.println("No todos for today! :)");
        } else {
            for (int i = 0; i < taskList.size(); i++) {
                System.out.println(i + 1 + " - " + taskList.get(i));
            }
        }
    }

}
