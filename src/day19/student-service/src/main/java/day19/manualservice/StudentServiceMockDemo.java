package day19.manualservice;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

/*
 This class demonstrates how mocking works, implemented manually:
 - Created an inline fake implementation of StudentRepository,
   controlled what it returns, and verified calls by tracking flags.
*/
public class StudentServiceMockDemo {

    public static void main(String[] args) {
        FakeRepo fake = new FakeRepo();
        // configure fake to return a student for id=1
        fake.saved = new Student(1L, "Manan", 20, "manan@x.com");
        fake.returnOnFind = true;

        StudentService service = new StudentService(fake);

        // call service method that uses repo
        Student s = service.getStudent(1L);
        if (!"Manan".equals(s.getName())) {
            System.err.println("FAIL: expected Manan");
        } else {
            System.out.println("PASS: got Manan from service");
        }

        // verify the repo recorded that findById was called
        if (fake.findCalled) {
            System.out.println("PASS: repo.findById was called");
        } else {
            System.err.println("FAIL: repo.findById not called");
        }
    }

    // small fake repo implementing StudentRepository
    static class FakeRepo implements StudentRepository {
        boolean findCalled = false;
        boolean returnOnFind = false;
        Student saved = null;
        List<Student> store = new ArrayList<>();

        @Override
        public Optional<Student> findById(Long id) {
            findCalled = true;
            if (returnOnFind && saved != null && saved.getId().equals(id)) {
                return Optional.of(saved);
            }
            return Optional.empty();
        }

        @Override
        public List<Student> findAll() {
            return store;
        }

        @Override
        public Student save(Student student) {
            // simple save behavior
            if (student.getId() == null) {
                long nid = store.size() + 1;
                student.setId(nid);
            }
            store.add(student);
            return student;
        }

        @Override
        public void deleteById(Long id) {
            store.removeIf(s -> s.getId().equals(id));
        }
    }
}
