// src/day8/Square.java
package day8;

public class Square extends Shape {
    private final double side;

    public Square(double side) {
        super("Square");
        this.side = side;
    }

    @Override
    public double Area() {
        return side * side;
    }

    @Override
    public double Perimeter() {
        return 4 * side;
    }

    public static void main(String[] args) {
        Square s = new Square(4);
        System.out.println(s.describe());
    }
}
