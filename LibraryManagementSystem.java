import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Sample data
        library.addBook(new Book("1", "1984", "George Orwell"));
        library.addBook(new Book("2", "To Kill a Mockingbird", "Harper Lee"));
        library.registerMember(new Member("1", "Alice"));
        library.registerMember(new Member("2", "Bob"));

        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. View available books");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. View borrowed books");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Available Books:");
                    for (Book book : library.getAvailableBooks()) {
                        System.out.println(book.getId() + ": " + book.getTitle() + " by " + book.getAuthor());
                    }
                    break;
                case 2:
                    System.out.print("Enter member ID: ");
                    String memberId = scanner.nextLine();
                    System.out.print("Enter book ID: ");
                    String bookId = scanner.nextLine();
                    library.borrowBook(memberId, bookId);
                    break;
                case 3:
                    System.out.print("Enter member ID: ");
                    memberId = scanner.nextLine();
                    System.out.print("Enter book ID: ");
                    bookId = scanner.nextLine();
                    library.returnBook(memberId, bookId);
                    break;
                case 4:
                    System.out.print("Enter member ID: ");
                    memberId = scanner.nextLine();
                    System.out.println("Borrowed Books:");
                    for (Book book : library.getBorrowedBooks(memberId)) {
                        System.out.println(book.getId() + ": " + book.getTitle() + " by " + book.getAuthor());
                    }
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
