package LMS;

import java.util.*;

public class Library {
    private final Map<String, Book> books = new HashMap<>();        // isbn -> Book
    private final Map<String, Member> members = new HashMap<>();    // memberId -> Member
    private final Map<String, String> borrowedBy = new HashMap<>(); // isbn -> memberId

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
    }

    public void borrowBook(String isbn, String memberId)
            throws BookNotFoundException, MemberNotFoundException, BookAlreadyBorrowedException {
        Book book = books.get(isbn);
        if (book == null) {
            throw new BookNotFoundException("Book with ISBN " + isbn + " not found.");
        }
        Member member = members.get(memberId);
        if (member == null) {
            throw new MemberNotFoundException("Member with ID " + memberId + " not found.");
        }
        if (borrowedBy.containsKey(isbn)) {
            throw new BookAlreadyBorrowedException("Book with ISBN " + isbn + " is already borrowed by member " + borrowedBy.get(isbn));
        }
        borrowedBy.put(isbn, memberId);
    }

    public void returnBook(String isbn) throws BookNotFoundException {
        Book book = books.get(isbn);
        if (book == null) {
            throw new BookNotFoundException("Book with ISBN " + isbn + " not found.");
        }
        if (!borrowedBy.containsKey(isbn)) {
            System.out.println("Book with ISBN " + isbn + " is not currently borrowed.");
            return;
        }
        borrowedBy.remove(isbn);
    }

    public Optional<Book> findBook(String isbn) {
        return Optional.ofNullable(books.get(isbn));
    }

    public Optional<Member> findMember(String memberId) {
        return Optional.ofNullable(members.get(memberId));
    }

    public List<Book> listAllBooks() {
        return new ArrayList<>(books.values());
    }

    public List<Book> listAvailableBooks() {
        List<Book> out = new ArrayList<>();
        for (Book b : books.values()) {
            if (!borrowedBy.containsKey(b.getIsbn())) out.add(b);
        }
        return out;
    }

    public Map<String, String> getBorrowedMap() {
        return Collections.unmodifiableMap(borrowedBy);
    }
}
