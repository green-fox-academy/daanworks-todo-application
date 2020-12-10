import java.util.ArrayList;
import java.util.List;

public class todo {

    private static ArgumentHandler argumentHandler = new ArgumentHandler();

    public static void main(String[] args) {

        List<Element> ListOfTaskElements = new ArrayList<>();

        argumentHandler.handleArgument(args);
    }
}