public class Rectangle extends Shape implements ShapeInterface {

    private double length;
    private double width;


    public Rectangle(String newType, String newId, String newLength, String newWidth, String newColor)
    {
        super(newType, newId, newColor);
        length = Double.parseDouble(newLength);
        width = Double.parseDouble(newWidth);

    }


    public double getPerimeter()
    {
        double perimeter = length + length + width + width;
        perimeter = roundToTwoDecimals(perimeter);
        return perimeter;
    }

    public double getArea()
    {
        double area = length * width;
        area = roundToTwoDecimals(area);
        return area;
    }


    public double getLength()
    {
        return length;
    }

    public double getWidth()
    {
        return width;
    }
}
