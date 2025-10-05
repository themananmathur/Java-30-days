package day19;

public class StudentTest {

    public static void main(String[] args) {
        // test runner: each test method runs and prints pass/fail
        runTest("Valid student", StudentTest::testValidStudent);
        runTest("Invalid name", StudentTest::testInvalidName);
        runTest("Invalid age", StudentTest::testInvalidAge);
        runTest("Invalid email", StudentTest::testInvalidEmail);
        runTest("Equals with same ID", StudentTest::testEqualsWithId);
    }

    static void testValidStudent() {
        Student s = new Student(null, "Manan", 21, "manan@example.com");
        if (!"Manan".equals(s.getName())) throw new AssertionError("name");
        if (s.getAge() != 21) throw new AssertionError("age");
        if (!"manan@example.com".equals(s.getEmail())) throw new AssertionError("email");
    }

    static void testInvalidName() {
        try {
            new Student(null, "   ", 21, null);
            throw new AssertionError("Expected exception not thrown");
        } catch (IllegalArgumentException e) {
            if (!"name required".equals(e.getMessage())) throw new AssertionError("message mismatch");
        }
    }

    static void testInvalidAge() {
        try {
            new Student(null, "Sheldon", -5, null);
            throw new AssertionError("Expected exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    static void testInvalidEmail() {
        try {
            new Student(null, "Leonard", 25, "no-at");
            throw new AssertionError("Expected exception not thrown");
        } catch (IllegalArgumentException e) {
        }
    }

    static void testEqualsWithId() {
        Student a = new Student(1L, "A", 20, "a@x.com");
        Student b = new Student(1L, "B", 30, "b@x.com");
        if (!a.equals(b)) throw new AssertionError("Students with same ID should be equal");
    }

    interface TestMethod { void run(); }

    private static void runTest(String name, TestMethod t) {
        try {
            t.run();
            System.out.println("PASS: " + name);
        } catch (AssertionError e) {
            System.err.println("FAIL: " + name + " -> " + e.getMessage());
        } catch (Exception e) {
            System.err.println("FAIL: " + name + " -> Unexpected " + e);
        }
    }
}
