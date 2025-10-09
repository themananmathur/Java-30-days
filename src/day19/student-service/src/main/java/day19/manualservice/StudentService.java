package day19.manualservice;

import java.util.List;
import java.util.NoSuchElementException;

public class StudentService {
    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public Student createStudent(Student student) {
        if (student.getId() != null) throw new IllegalArgumentException("new student must not have id");
        return repo.save(student);
    }

    public Student getStudent(Long id) {
        return repo.findById(id).orElseThrow(() -> new NoSuchElementException("student not found"));
    }

    public List<Student> listStudents() {
        return repo.findAll();
    }

    public Student updateStudent(Long id, Student update) {
        Student existing = getStudent(id);
        existing.setName(update.getName());
        existing.setAge(update.getAge());
        existing.setEmail(update.getEmail());
        return repo.save(existing);
    }

    public void deleteStudent(Long id) {
        getStudent(id); // throws if absent
        repo.deleteById(id);
    }
}
