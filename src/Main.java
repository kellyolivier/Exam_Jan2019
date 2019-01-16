
import java.util.Vector;
import java.io.*;

public class Main {
    private static Vector<String[]> outer = new Vector<String[]>();


    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        //process data into UI consumable
        readFile();

        //initialize first class
        Controller controller = new Controller(outer);

    }

    public static void readFile() throws FileNotFoundException, IOException
    {
        // relative path

        File file = new File("shapes.csv");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String str;
        while((str = br.readLine()) != null)
        {
            String[] inner = str.split(",");
            outer.add(inner);
        }


    }
}
