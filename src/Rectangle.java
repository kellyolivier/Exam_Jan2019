public class Rectangle implements Shape {

    private String id;
    private double length;
    private double width;
    private String color;

    public Rectangle(String newId, String newLength, String newWidth, String newColor)
    {
        id = newId;
        length = Double.parseDouble(newLength);
        width = Double.parseDouble(newWidth);
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
