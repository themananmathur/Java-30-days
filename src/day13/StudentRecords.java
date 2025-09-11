package day13;

import day10.Account;

import java.util.*;

class Student{
    private int id;
    private String name;
    private String grade;

    public Student(int id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public int getId() {return id;}
    public String getName() {return name;}
    public String getGrade() {return grade;}

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", grade=" + grade + "}";
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Student)) return false;
        Student different = (Student) o;
        return id == different.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

public class StudentRecords {
    public static void main(String[] args) {

        List<Student> arrayList =  new ArrayList<>();
        arrayList.add(new Student(1, "A", "A"));
        arrayList.add(new Student(2, "B", "B"));
        arrayList.add(new Student(3, "C", "C"));
        System.out.println("Array List: ");
        for(Student s : arrayList){
            System.out.println(s);
        }

        LinkedList<Student> linkedList = new LinkedList<>();
        linkedList.add(new Student(4, "D", "A"));
        linkedList.add(new Student(5, "E", "B"));
        linkedList.add(new Student(6, "F", "C"));
        System.out.println("Linked List: ");
        for(Student s : linkedList){
            System.out.println(s);
        }

        HashSet<Student> studentSet = new HashSet<>();
        studentSet.add(new Student(7, "G", "A"));
        studentSet.add(new Student(8, "H", "B"));
        studentSet.add(new Student(9, "I", "C"));
        studentSet.add(new Student(7, "J", "D"));
        System.out.println("Student Set : ");
        for(Student s : studentSet){
            System.out.println(s);
        }
    }
}
