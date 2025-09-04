package day8;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(5),
                new Rectangle(2, 3),
                new Square(4),
                new Triangle(6, 7, 8),
                //new Diamond(9, 10, 11),
        };

        for (Shape s : shapes) {
            System.out.println(s.getClass().getSimpleName());
            System.out.println("Area: " + s.Area());
            System.out.println("Perimeter: " + s.Perimeter());
            System.out.println("---------------");
        }
    }
}
