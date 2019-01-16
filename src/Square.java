public class Square extends Shape implements ShapeInterface
{

    private double side;


    public Square(String newType, String newId, String newSide, String newColor)
    {
        super(newType, newId, newColor);
        side = Double.parseDouble(newSide);
    }

    public double getArea()
    {
        double area = side * side;
        area = roundToTwoDecimals(area);
        return area;
    }

    public double getPerimeter()
    {
        double perimeter = side * 4;
        perimeter = roundToTwoDecimals(perimeter);
        return perimeter;
    }

    public double getSide()
    {
        return side;
    }

}
