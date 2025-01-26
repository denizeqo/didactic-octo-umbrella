package main.java.configuration;

import java.util.Scanner;

import main.java.services.Library;

public class Main {

	// Global Scanner instance for input
	private static Scanner scanner = new Scanner(System.in);

	// Global Library instance
	private static Library library = new Library();

	public static void main(String[] args) {
		while (true) {
			System.out.println("\n--- Library Management System ---");
			System.out.println("1. Add Book");
			System.out.println("2. Show All Books");
			System.out.println("3. Search Book by ISBN");
			System.out.println("4. Search Book by Title");
			System.out.println("5. Search Book by Author");
			System.out.println("6. Remove Book");
			System.out.println("7. Remove All Books");
			System.out.println("8. Register User");
			System.out.println("9. Unregister User");
			System.out.println("0. Exit");
			System.out.print("Choose an option: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				addBook();
				break;
			case 2:
				library.showAllBooks();
				break;
			case 3:
				searchByISBN();
				break;
			case 4:
				searchByTitle();
				break;
			case 5:
				searchByAuthor();
				break;
			case 6:
				removeBook();
				break;
			case 7:
				removeAllBooks();
				break;
			case 8:
				registerUser();
				break;
			case 9:
				unregisterUser();
				break;
			case 0:
				System.out.println("Exiting... Goodbye!");
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private static void addBook() {
		System.out.print("Enter Book Name: ");
		String name = scanner.nextLine();
		System.out.print("Enter Author Name: ");
		String author = scanner.nextLine();
		System.out.print("Enter ISBN: ");
		int isbn = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		System.out.print("Enter Year Published: ");
		int year = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		System.out.print("Is the book available? (true/false): ");
		boolean isAvailable = scanner.nextBoolean();

		Book book = new Book(name, author, isAvailable, year); // Assuming this is the constructor
		library.addBook(book);
	}

	private static void searchByISBN() {
		System.out.print("Enter ISBN: ");
		int isbn = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		library.searchByISBN(isbn);
	}

	private static void searchByTitle() {
		System.out.print("Enter Book Title: ");
		String title = scanner.nextLine();
		library.searchByTitle(title);
	}

	private static void searchByAuthor() {
		System.out.print("Enter Author Name: ");
		String author = scanner.nextLine();
		library.searchByAuthor(author);
	}

	private static void removeBook() {
		System.out.print("Enter Book ISBN to Remove: ");
		int isbn = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		// Assuming the `BookDAO.removeBook()` method can accept the ISBN directly.
		library.removeBook(isbn);
	}

	private static void removeAllBooks() {
		System.out.print("Are you sure you want to remove all books? (yes/no): ");
		String confirmation = scanner.nextLine();
		if (confirmation.equalsIgnoreCase("yes")) {
			library.removeAllBooks();
		} else {
			System.out.println("Operation canceled.");
		}
	}

	private static void registerUser() {
		System.out.print("Enter User Name: ");
		String name = scanner.nextLine();
		System.out.print("Enter Member ID: ");
		String memberId = scanner.nextLine(); // Added member ID input
		System.out.print("Enter Phone Number: ");
		String phone = scanner.nextLine();
		System.out.print("Enter Address: ");
		String address = scanner.nextLine();

		User user = new User(name, phone, address); // Assuming this is the constructor
		library.registerUsers(user);
	}

	private static void unregisterUser() {
		System.out.print("Enter Member ID to Unregister: ");
		String memberID = scanner.nextLine();
		User user = new User("dummy", "dummy", "dummy"); // Dummy data except Member ID
		library.unRegisterUsers(user);
	}
}
