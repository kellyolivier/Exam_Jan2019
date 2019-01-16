public class Triangle extends Shape implements ShapeInterface
{

    private double sideOne;
    private double sideTwo;
    private double sideThree;


    public Triangle(String newType, String newId, String newSideOne, String newSideTwo, String newSideThree, String newColor)
    {
        super(newType, newId, newColor);
        sideOne = Double.parseDouble(newSideOne);
        sideTwo = Double.parseDouble(newSideTwo);
        sideThree = Double.parseDouble(newSideThree);

    }

    public double getArea()
    {
        double perimeter = getPerimeter();
        double area = perimeter * (perimeter - sideOne)*(perimeter - sideTwo) *(perimeter - sideThree);
        area = Math.abs(area); //to avoid taking sqrt of a negative, since area cant be negative to begin with
        area = Math.sqrt(area);

        area = roundToTwoDecimals(area);

        return area;
    }

    public double getPerimeter()
    {
        double perimeter = (sideOne + sideThree + sideTwo) / 2.0;
        perimeter = roundToTwoDecimals(perimeter);
        return perimeter;
    }

    public double getSideOne()
    {
        return sideOne;
    }

    public double getSideTwo()
    {
        return sideTwo;
    }

    public double getSideThree()
    {
        return sideThree;
    }

}
