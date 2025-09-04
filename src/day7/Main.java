package day7;

class Student {
    private String name;
    private int age;
    private int roll;

    public Student(int roll, String name, int age) {
        this.roll = roll;
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if(age>0){
            this.age = age;
        } else {
            System.out.println("Invalid Age");
        }
    }
    public int getRoll() {
        return roll;
    }
    public void setRoll(int roll) {
        this.roll = roll;
    }

    public void displayStudentInfo(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Roll: " + roll);
    }
}

public class Main{
    public static void main(String[] args) {
        Student s1 = new Student(1, "Manan", 10);
        Student s2 = new Student(2, "Randstad", 20);

        System.out.println("Student name: " + s1.getName());

        s1.setAge(21);
        System.out.println("Student age: " + s1.getAge());

        s1.setAge(-10);

        s1.displayStudentInfo();
    }
}
