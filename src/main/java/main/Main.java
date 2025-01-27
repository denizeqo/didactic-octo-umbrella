package main;

import java.util.Scanner;
import main.model.Book;
import main.model.Library;
import main.model.User;

public class Main {

    private static Library library;

    public Main(Library library) {
        this.library = library;
    }

    public static void main(String[] args) {
        runMenu();
    }

    private static void runMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Press 1 to Add a new Book");
            System.out.println("Press 2 to Show All Books");
            System.out.println("Press 3 to Register a User");
            System.out.println("Press 4 to Unregister a User");
            System.out.println("Press 0 to Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    library.showAllBooks();
                    break;
                case 3:
                    registerUser(scanner);
                    break;
                case 4:
                    unregisterUser(scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option selected.");
            }
        }
    }

    private static void registerUser(Scanner scanner) {
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        User user = User.builder()
            .name(name)
            .phoneNumber(phoneNumber)
            .address(address)
            .build();

        library.registerUsers(user);
        System.out.println("User registered successfully!");
    }

    private static void unregisterUser(Scanner scanner) {
        System.out.print("Enter user ID to unregister: ");
        String id = scanner.nextLine();

        library.unRegisterUsers(id);
        System.out.println("User unregistered successfully!");
    }

    private static void addBook(Scanner scanner) {
        System.out.print("Enter book name: ");
        String name = scanner.nextLine();

        System.out.print("Enter author name: ");
        String authorName = scanner.nextLine();

        System.out.print("Enter availability (true/false): ");
        boolean availability = scanner.nextBoolean();

        System.out.print("Enter ISBN: ");
        int isbn = scanner.nextInt();

        System.out.print("Enter year published: ");
        int yearPublished = scanner.nextInt();

        System.out.print("Enter number of copies: ");
        int numberOfCopies = scanner.nextInt();

        Book book = Book.builder()
            .name(name)
            .authorName(authorName)
            .availability(availability)
            .isbn(isbn)
            .yearPublished(yearPublished)
            .numberOfCopies(numberOfCopies)
            .build();

        library.addBook(book);
        System.out.println("Book added successfully!");
    }

}
