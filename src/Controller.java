import java.util.Vector;

public class Controller {

    private Vector<String[]> outer;
    private Vector<Shape> shapes;

    private UI userInterface;

    public Controller(Vector<String[]> newOuter)
    {
        outer = newOuter;
        correctFormatting();

        userInterface = new UI(this);

    }

    public void createShapes() throws Exception
    {
        String[] current;
        Shape shape;
        String currentType;
        for(int i = 0; i < outer.size(); i++)
        {
            current = outer.get(i);
            currentType = current[0].toLowerCase();

            if(currentType.equals("square"))
            {
                shape = new Square(current[1], current[2], current[3]);
            }
            else if(currentType.equals("circle"))
            {
                shape = new Circle(current[1], current[2], current[3]);
            }
            else if(currentType.equals("rectangle"))
            {
                shape = new Rectangle(current[1], current[2], current[3], current[4]);
            }
            else if (currentType.equals("triangle"))
            {
                shape = new Triangle(current[1], current[2], current[3], current[4], current[5]);
            }
            else
            {
                throw new Exception();
            }

            shapes.add(shape);
        }
    }

    public void correctFormatting()
    {
        Vector<String[]> reformatted = new Vector<String[]>();

        for(int j = 0; j < reformatted.size(); j++)
        {
            String[] arr = reformatted.get(j);
            Vector<String> reformatVec = new Vector<String>();
            String[] finalArr = new String[reformatVec.size()]

            for(int i = 0; i < arr.length; i++)
            {
                if(arr[i].contains("\""))
                {
                    arr[i] = arr[i].replaceAll("\"","");
                }
                if(!arr[i].equals(""))
                {
                    reformatVec.add(arr[i]);
                }
            }

            for(int k = 0; k < reformatVec.size(); k++)
            {
                finalArr[k] = reformatVec.get(k);
            }

            reformatted.add(finalArr);
        }
        outer = reformatted;

    }

    //create from vector outer a list of strings to give to UI for creation of JList to display
    public Vector<String> createBasisForList()
    {
        Vector<String> list = new Vector<String>();

        for(int i = 0; i < outer.size(); i++)
        {
            String[] currentRow = outer.get(i);
            list.add((String)currentRow[0]);
        }

        return list;
    }

    public String[] getDisplayInfo(int index)
    {
        return outer.get(index);
    }


}
