public class Circle extends Shape implements ShapeInterface
{
    private double radius;

    public Circle(String newType, String newId, String newRadius, String newColor)
    {
        super(newType, newId, newColor);
        radius = Double.parseDouble(newRadius);
    }

    public double getPerimeter()
    {
        double circumference = 2 * Math.PI * radius;
        circumference = roundToTwoDecimals(circumference);
        return circumference;
    }

    public double getArea()
    {
        double area = 3.14 * radius * radius;
        area = roundToTwoDecimals(area);
        return area;
    }

    public double getRadius() {
        return radius;
    }


}
