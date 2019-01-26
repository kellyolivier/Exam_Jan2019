/*
FEEDBACK

Read from the file correctly: 20/20%
Implement class hierarchy correctly: 20/20%
Populate appropriate data structures with shape data: 15/15%
Show list of shapes correctly: 15/15%
Show specific shape properties correctly: 15/15%
Well-structured, well-commented code: 8/15%


Comments:
  separate the displayInfo code into a separate functions.
  need images
*/

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
