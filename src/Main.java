
import java.util.Vector;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception
    {
        //initialize first class
        Controller controller = new Controller();

        //process data into UI consumable
        controller.readFile(new File("src/shapes.csv"));

        //initialize UI
        controller.controllerInitUI();
    }
}
