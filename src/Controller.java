import javax.swing.*;
import java.io.*;
import java.util.Vector;
import java.awt.*;

public class Controller {

    private Vector<String[]> controllerOuter = new Vector<String[]>();
    private Vector<Shape> shapes = new Vector<Shape>();

    private UI userInterface;

    //empty controller to avoid incorrect order of method calls in coordination with main
    public Controller() {    }

    public void controllerInitUI()
    {
        userInterface = new UI(this);
    }

    //reads file into vector of string arrays, removes extra and leftover formatting
    //and calls create shapes to make a vector of shapes
    public void readFile(File file) throws FileNotFoundException, IOException, Exception
    {
        // relative path

        BufferedReader br = new BufferedReader(new FileReader(file));

        String str;
        while((str = br.readLine()) != null)
        {
            String[] inner = str.split(",");
            controllerOuter.add(inner);
        }
        correctFormatting();

        createShapes();
    }

    public Vector<Shape> getShapes() {
        return shapes;
    }

    public Shape getShape(int index)
    {
        return shapes.get(index);
    }

    //creates shape based on its type name,
    //will throw exception if the lowercase version of the shape name does not match one of the choices
    public void createShapes() throws Exception
    {
        String[] current;
        Shape  shape;
        String currentType;
        for(int i = 0; i < controllerOuter.size(); i++)
        {
            current = controllerOuter.get(i);
            currentType = current[0].toLowerCase();

            if(currentType.equals("square"))
            {
                shape = new Square(currentType, current[1], current[2], current[3]);
            }
            else if(currentType.equals("circle"))
            {
                shape = new Circle(currentType, current[1], current[2], current[3]);
            }
            else if(currentType.equals("rectangle"))
            {
                shape = new Rectangle(currentType, current[1], current[2], current[3], current[4]);
            }
            else if (currentType.equals("triangle"))
            {
                shape = new Triangle(currentType, current[1], current[2], current[3], current[4], current[5]);
            }
            else
            {
                throw new Exception("no matching shape constructor");
            }

            //add to private shapes vector
            shapes.add(shape);
        }
    }


    //remove extra quotes, spaces and empty strings in controllerOuter thats created by readfile
    public void correctFormatting()
    {
        Vector<String[]> reformatted = new Vector<String[]>();

        //outer loop handles stepping through the string arrays that the vector holds
        for(int j = 0; j < controllerOuter.size(); j++)
        {
            String[] arr = controllerOuter.get(j);
            Vector<String> reformatVec = new Vector<String>();

            //handles stepping through each element in a string array pulled from the vector
            //both conditions are individual if statements since both may need to be executed on a single string
            for(int i = 0; i < arr.length; i++)
            {
                //removes all extra quotes existing within the string (replaces them with nothing)
                if(arr[i].contains("\""))
                {
                    arr[i] = arr[i].replaceAll("\"","");

                }
                //trims extra space on beginning/end left by removal of quotes
                arr[i] = arr[i].trim();

                //prevents empty strings in an array from being added to the processed array
                if(!arr[i].equals(""))
                {
                    reformatVec.add(arr[i]);
                }

            }

            //to avoid problems in adding elements to an array, vector above is used and then converted into an array
            String[] finalArr = new String[reformatVec.size()];

            for(int k = 0; k < reformatVec.size(); k++)
            {
                finalArr[k] = reformatVec.get(k);
            }

            //add string array to next open slot in the vector of reformatted data
            reformatted.add(finalArr);
        }
        controllerOuter = reformatted;

    }


    //create from vector outer a list of strings to give to UI for creation of JList to display
    public Vector<String> createBasisForList()
    {
        Vector<String> list = new Vector<String>();

        for(int i = 0; i < shapes.size(); i++)
        {
            Shape current = shapes.get(i);
            list.add(current.toString());
        }

        return list;
    }


}
