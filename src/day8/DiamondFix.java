package day8;

public class DiamondFix extends Shape {
    private final Circle circlePart;
    private final Rectangle rectPart;

    public DiamondFix(double radius, double length, double width) {
        super("DiamondFix");
        this.circlePart = new Circle(radius);
        this.rectPart = new Rectangle(length, width);
    }

    @Override
    public double Area() {
        return circlePart.Area() + rectPart.Area();
    }

    @Override
    public double Perimeter() {
        return circlePart.Perimeter() + rectPart.Perimeter();
    }

    public static void main(String[] args) {
        DiamondFix d = new DiamondFix(9, 10, 11);
        System.out.println(d.describe());
    }
}
