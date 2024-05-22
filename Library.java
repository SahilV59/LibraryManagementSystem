import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private Map<String, Book> books;
    private Map<String, Member> members;

    public Library() {
        books = new HashMap<>();
        members = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public void removeBook(String bookId) {
        books.remove(bookId);
    }

    public void registerMember(Member member) {
        members.put(member.getId(), member);
    }

    public void borrowBook(String memberId, String bookId) {
        Member member = members.get(memberId);
        Book book = books.get(bookId);
        if (member != null && book != null && book.isAvailable()) {
            member.borrowBook(book);
        }
    }

    public void returnBook(String memberId, String bookId) {
        Member member = members.get(memberId);
        Book book = books.get(bookId);
        if (member != null && book != null) {
            member.returnBook(book);
        }
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public List<Book> getBorrowedBooks(String memberId) {
        Member member = members.get(memberId);
        if (member != null) {
            return member.getBorrowedBooks();
        }
        return new ArrayList<>();
    }
}
