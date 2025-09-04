package day8;

public class Rectangle extends Shape {
    private final double length, width;

    public Rectangle(double length, double width) {
        super("Rectangle");
        this.length = length;
        this.width = width;
    }

    @Override
    public double Area() {
        return length * width;
    }

    @Override
    public double Perimeter() {
        return 2 * (length + width);
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle(2, 3);
        System.out.println(r.describe());
    }
}
