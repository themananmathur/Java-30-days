package day19.manualservice;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    Optional<Student> findById(Long id);
    List<Student> findAll();
    Student save(Student student);
    void deleteById(Long id);
}