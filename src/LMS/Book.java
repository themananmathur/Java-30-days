package LMS;

public class Book extends LibraryItem {
    private String title;
    private String author;
    private String isbn;

    public Book(String isbn, String title, String author) {
        super(isbn);        // set LibraryItem.itemId to isbn
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
        this.itemId = isbn; // keep LibraryItem.itemId in sync
    }

    @Override
    public void displayInfo() {
        System.out.printf("Book | Title: %s | Author: %s | ISBN: %s%n", title, author, isbn);
    }

    @Override
    public String toString() {
        return "Book[" + title + ", " + author + ", ISBN=" + isbn + "]";
    }
}
