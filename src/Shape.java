
//base class for circle, square, triangle, and rectangle
//created for displaying generic shape data, and because many methods are identical across child classes
//handles methods that display based on id, type of shape, and color
public class Shape implements ShapeInterface{
    private String type;
    private int id;
    private String color;

    public Shape(String newType, String newId, String newColor)
    {
        type = newType;
        id = Integer.parseInt(newId);
        color = newColor;
    }

    public String toString()
    {
        String str = getKind() + " (" + id + ")";
        return str;
    }
    public String getKind()
    {
        String output = Character.toUpperCase(type.charAt(0)) + type.substring(1);
        return output;
    }

    public String getDisplayHeader()
    {
        String str = getKind() + " (ID# " + id + ")";
        return str;
    }
    public int getID()
    {
        return id;
    }

    public String getColor() {
        return color;
    }

    //made for easy rounding to two decimals when needed
    public double roundToTwoDecimals(double value)
    {
        value = value * 100;
        value = Math.round(value);
        value = value / 100;

        return value;
    }

}
