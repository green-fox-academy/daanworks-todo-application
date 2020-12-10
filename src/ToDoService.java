import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ToDoService {

    static Path tasksPath = Paths.get("../data/tasks.txt");
    static List<String> taskList = new ArrayList<>();

    public static List<String> readFromFile() {
        try {
            taskList = Files.readAllLines(tasksPath);
            return taskList;
        } catch (IOException e) {
            System.out.println("File is not available :(");
            return taskList;
        }
    }

    public static void removeTask() {

    }

    public static void addTask(String task) {
        readFromFile();
        taskList.add(task);
        try {
            Files.write(tasksPath, taskList);
        } catch (IOException e) {
            System.out.println("File is not available :(");
        }

    }

    public static void listTasks() {
        readFromFile();
        if (taskList.isEmpty()) {
            System.out.println("No todos for today! :)");
        } else {
            for (int i = 0; i < taskList.size(); i++) {
                System.out.println(i + 1 + ". " + taskList.get(i));
            }
        }
    }

}
