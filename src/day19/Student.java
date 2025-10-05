package day19;

import java.util.Objects;
import java.util.regex.Pattern;

public class Student {
    private Long id;
    private String name;
    private int age;
    private String email;

    private static final Pattern EMAIL = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");

    public Student() { }

    public Student(Long id, String name, int age, String email) {
        this.id = id;
        setName(name);
        setAge(age);
        setEmail(email);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name required");
        this.name = name.trim();
    }

    public int getAge() { return age; }
    public void setAge(int age) {
        if (age < 0 || age > 100) throw new IllegalArgumentException("invalid age");
        this.age = age;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) {
        if (email == null || email.isBlank()) {
            this.email = null;
            return;
        }
        String t = email.trim();
        if (!EMAIL.matcher(t).matches()) throw new IllegalArgumentException("invalid email");
        this.email = t;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        if (id != null && s.id != null) return Objects.equals(id, s.id);
        return age == s.age && Objects.equals(name, s.name) && Objects.equals(email, s.email);
    }

    @Override
    public int hashCode() {
        return (id != null) ? Objects.hash(id) : Objects.hash(name, age, email);
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name='" + name + '\'' +
                ", age=" + age + ", email='" + email + '\'' + '}';
    }
}
