package LMS;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        // Seed data
        library.addBook(new Book("2025-1", "Effective Java", "Joshua Bloch"));
        library.addBook(new Book("2025-2", "Head First Java", "Kathy Sierra"));
        library.addBook(new Book("2025-3", "Clean Code", "Robert C. Martin"));
        library.addBook(new Book("2025-4", "Java: The Complete Reference", "Herbert Schildt"));
        library.addBook(new Book("2025-5", "Thinking in Java", "Bruce Eckel"));
        library.addBook(new Book("2025-6", "Java Concurrency in Practice", "Brian Goetz"));
        library.addBook(new Book("2025-7", "Introduction to Algorithms", "Thomas H. Cormen"));
        library.addBook(new Book("2025-8", "Design Patterns", "Erich Gamma"));
        library.addBook(new Book("2025-9", "The Pragmatic Programmer", "Andrew Hunt"));
        library.addBook(new Book("2025-10", "Refactoring", "Martin Fowler"));

        library.addMember(new Member("M001", "Manan"));
        library.addMember(new Member("M002", "Shaikh"));
        library.addMember(new Member("M003", "Gautham"));
        library.addMember(new Member("M004", "Kushagra"));
        library.addMember(new Member("M005", "Randstad"));

        try {
            boolean running = true;
            while (running) {
                printMenu();
                System.out.print("Choice: ");
                String line = sc.nextLine().trim();
                int choice;
                try {
                    choice = Integer.parseInt(line);
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number.");
                    continue;
                }

                switch (choice) {
                    case 1 -> { // Add Book
                        System.out.print("ISBN: "); String isbn = sc.nextLine().trim();
                        System.out.print("Title: "); String title = sc.nextLine().trim();
                        System.out.print("Author: "); String author = sc.nextLine().trim();
                        library.addBook(new Book(isbn, title, author));
                        System.out.println("Book added.");
                    }
                    case 2 -> { // Add Member
                        System.out.print("Member ID: "); String mid = sc.nextLine().trim();
                        System.out.print("Name: "); String name = sc.nextLine().trim();
                        library.addMember(new Member(mid, name));
                        System.out.println("Member added.");
                    }
                    case 3 -> { // Borrow
                        System.out.print("Member ID: "); String mid = sc.nextLine().trim();
                        System.out.print("Book ISBN: "); String bisbn = sc.nextLine().trim();
                        try {
                            library.borrowBook(bisbn, mid);
                            System.out.println("Borrow successful.");
                        } catch (BookNotFoundException e) {
                            System.out.println("ERROR: " + e.getMessage());
                        } catch (MemberNotFoundException e) {
                            System.out.println("ERROR: " + e.getMessage());
                        } catch (BookAlreadyBorrowedException e) {
                            System.out.println("ERROR: " + e.getMessage());
                        }
                    }
                    case 4 -> { // Return
                        System.out.print("Book ISBN: "); String rIsbn = sc.nextLine().trim();
                        try {
                            library.returnBook(rIsbn);
                            System.out.println("Return processed.");
                        } catch (BookNotFoundException e) {
                            System.out.println("ERROR: " + e.getMessage());
                        }
                    }
                    case 5 -> { // List all books
                        List<Book> all = library.listAllBooks();
                        System.out.println("All books:");
                        all.forEach(Book::displayInfo);
                    }
                    case 6 -> { // List available books
                        List<Book> avail = library.listAvailableBooks();
                        System.out.println("Available books:");
                        avail.forEach(Book::displayInfo);
                    }
                    case 7 -> running = false;
                    default -> System.out.println("Invalid choice.");
                }
            }
        } finally {
            sc.close();
            System.out.println("Scanner closed. Exiting.");
        }
    }

    private static void printMenu() {
        System.out.println("\n=== Library Menu ===");
        System.out.println("1) Add Book");
        System.out.println("2) Add Member");
        System.out.println("3) Borrow Book");
        System.out.println("4) Return Book");
        System.out.println("5) List All Books");
        System.out.println("6) List Available Books");
        System.out.println("7) Exit");
    }
}

