package day8;

public class Circle extends Shape{
    private final double radius;

    public Circle(double radius){
        super("Circle");
        this.radius = radius;
    }

    @Override
    public double Area(){
        return Math.PI*Math.pow(radius,2);
    }

    @Override
    public double Perimeter(){
        return 2*Math.PI*radius;
    }

    public static void main(String[] args) {
        Circle c = new Circle(5);
        System.out.println(c.describe());
    }
}
