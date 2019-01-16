public class Triangle implements Shape
{
    private String id;
    private double sideOne;
    private double sideTwo;
    private double sideThree;
    private String color;

    public Triangle(String newId, String newSideOne, String newSideTwo, String newSideThree, String newColor)
    {
        id = newId;
        sideOne = Double.parseDouble(newSideOne);
        sideTwo = Double.parseDouble(newSideTwo);
        sideThree = Double.parseDouble(newSideThree);
        color = newColor;
    }

    public String toString()
    {

    }
    public String getKind()
    {

    }
    public String getDetailString()
    {

    }
    public int getID()
    {

    }
}
