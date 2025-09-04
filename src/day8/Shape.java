package day8;

public abstract class Shape {
    private final String name;

    protected Shape(String name) {
        this.name = name;
    }

    public final String getName() {
        return name;
    }

    public abstract double Area();
    public abstract double Perimeter();

    public String describe(){
        return "%s | area=%.2f | perimeter=%.2f".formatted(name,Area(),Perimeter());
    }
}
