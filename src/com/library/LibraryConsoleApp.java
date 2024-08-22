package com.library;

import com.library.books.Book;
import com.library.enums.BookStatus;
import com.library.enums.BorrowingPeriod;
import com.library.personnel.*;

import java.time.LocalDate;
import java.util.*;

public class LibraryConsoleApp {
    private static Map<String, Book> bookCatalog = new HashMap<>();
    private static List<Person> users = new ArrayList<>();
    private static Map<Book, Person> borrowedBooks = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Sample data
        List<Book> books = new ArrayList<>();
        Author author = new Author("Jane", "Doe", 12345678901L, "555-1234", "jane.doe@example.com", books);


        do {
            System.out.println("Library System Menu:");
            System.out.println("1. Add a new book");
            System.out.println("2. Update a book");
            System.out.println("3. Delete a book");
            System.out.println("4. Search for a book");
            System.out.println("5. List all books");
            System.out.println("6. Borrow a book");
            System.out.println("7. Return a book");
            System.out.println("8. Add a Reader");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    updateBook(scanner);
                    break;
                case 3:
                    deleteBook(scanner);
                    break;
                case 4:
                    searchBook(scanner);
                    break;
                case 5:
                    listAllBooks();
                    break;
                case 6:
                    borrowBook(scanner);
                    break;
                case 7:
                    returnBook(scanner);
                    break;
                case 8:
                    addReader(scanner);
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9); // Çıkış koşulunu güncelleyin
    }

    private static void addBook(Scanner scanner) {
        System.out.print("Enter Book ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Author Name: ");
        String authorName = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Edition: ");
        String edition = scanner.nextLine();
        System.out.print("Enter Date of Purchase (YYYY-MM-DD): ");
        LocalDate dateOfPurchase = LocalDate.parse(scanner.nextLine());

        Author author = new Author(authorName);
        Book book = new Book(id, author, title, price, BookStatus.AVAILABLE, edition, dateOfPurchase) {
            @Override
            public void showDetails() {

            }
        };
        bookCatalog.put(id, book);

        System.out.println("Book added successfully.");
    }

    private static void updateBook(Scanner scanner) {
        System.out.print("Enter Book ID to update: ");
        String id = scanner.nextLine();
        Book book = bookCatalog.get(id);

        if (book != null) {
            System.out.print("Enter new title (leave empty to keep current): ");
            String title = scanner.nextLine();
            if (!title.isEmpty()) {
                book.setName(title);
            }

            System.out.print("Enter new price (leave empty to keep current): ");
            String priceStr = scanner.nextLine();
            if (!priceStr.isEmpty()) {
                book.setPrice(Double.parseDouble(priceStr));
            }

            // Further updates can be done similarly

            System.out.println("Book updated successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void deleteBook(Scanner scanner) {
        System.out.print("Enter Book ID to delete: ");
        String id = scanner.nextLine();
        Book book = bookCatalog.remove(id);

        if (book != null) {
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void searchBook(Scanner scanner) {
        System.out.println("Search by:");
        System.out.println("1. ID");
        System.out.println("2. Title");
        System.out.println("3. Author");

        int searchChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (searchChoice) {
            case 1:
                System.out.print("Enter Book ID: ");
                String id = scanner.nextLine();
                Book book = bookCatalog.get(id);
                if (book != null) {
                    book.display();
                } else {
                    System.out.println("Book not found.");
                }
                break;
            case 2:
                System.out.print("Enter Title: ");
                String title = scanner.nextLine();
                bookCatalog.values().stream()
                        .filter(b -> b.getTitle().equalsIgnoreCase(title))
                        .forEach(Book::display);
                break;
            case 3:
                System.out.print("Enter Author Name: ");
                String authorName = scanner.nextLine();
                bookCatalog.values().stream()
                        .filter(b -> b.getAuthor().getName().equalsIgnoreCase(authorName))
                        .forEach(Book::display);
                break;
            default:
                System.out.println("Invalid search choice.");
                break;
        }
    }

    private static void listAllBooks() {
        System.out.println("Listing all books:");
        bookCatalog.values().forEach(Book::display);
    }

    private static void borrowBook(Scanner scanner) {
        System.out.print("Enter Book ID to borrow: ");
        String id = scanner.nextLine();
        Book book = bookCatalog.get(id);

        if (book != null && book.getStatus() == BookStatus.AVAILABLE) {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            Person user = users.stream().filter(u -> u.getName().equalsIgnoreCase(name)).findFirst().orElse(null);

            if (user != null && user instanceof Reader) {
                Reader reader = (Reader) user;
                reader.borrowBook(book);
                borrowedBooks.put(book, reader);
                System.out.println("Book borrowed successfully.");
            } else {
                System.out.println("User not found or is not a reader.");
            }
        } else {
            System.out.println("Book not available or not found.");
        }
    }


    private static void returnBook(Scanner scanner) {
        System.out.print("Enter Book ID to return: ");
        String id = scanner.nextLine();
        Book book = bookCatalog.get(id);

        if (book != null && borrowedBooks.containsKey(book)) {
            Person user = borrowedBooks.remove(book);
            if (user instanceof Reader) {
                ((Reader) user).returnBook(book);
                System.out.println("Book returned successfully.");
            }
        } else {
            System.out.println("Book not borrowed or not found.");
        }
    }
    private static void addReader(Scanner scanner) {
        System.out.print("Enter Reader Name: ");
        String name = scanner.nextLine();

        System.out.println("Select Reader Type:");
        System.out.println("1. Student");
        System.out.println("2. Faculty");
        int choice = Integer.parseInt(scanner.nextLine());

        BorrowingPeriod period;
        if (choice == 1) {
            period = BorrowingPeriod.STUDENT;
        } else if (choice == 2) {
            period = BorrowingPeriod.FACULTY;
        } else {
            period = BorrowingPeriod.DEFAULT; // Default period if invalid choice
        }

        Reader reader = new Reader(name, period);
        users.add(reader);
        System.out.println("Reader added successfully.");
    }

}
