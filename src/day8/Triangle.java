// src/day8/Triangle.java
package day8;

public class Triangle extends Shape {
    private final double a, b, c;

    public Triangle(double a, double b, double c) {
        super("Triangle");
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double Area() {
        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double Perimeter() {
        return a + b + c;
    }

    public static void main(String[] args) {
        Triangle t = new Triangle(6, 7, 8);
        System.out.println(t.describe());
    }
}
