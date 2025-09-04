package day6;

class Car {
    String brand;
    String model;
    int year;

    Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    void run() {
        System.out.println("Car " + brand + " " + model + " is running.");
    }
    void release(){
        System.out.println("Car " + brand + " " + model + " is releasing in " + year);
    }
    void showDetails() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", Year: " + year);
    }
}

public class Main{
    public static void main(String[] args) {
        Car car1 = new Car("BMW", "M5", 2025);
        Car car2 = new Car("Mercedes AMG", "E63 CS", 2023);
        Car car3 = new Car("Porsche", "911 Carerra S", 2022);
        Car car4 = new Car("Tesla", "Roadster", 2030);

        car1.showDetails();
        car1.run();
        car2.showDetails();
        car2.run();
        car3.showDetails();
        car3.run();
        car4.showDetails();
        car4.release();
    }
}
