package main.model;

import java.util.UUID;

import main.service.BookService;
import main.service.UserService;


//TODO: FORMAT YOU METHODS. After every method, add a new line, and before every method, add a new line
public class Library {

		BookService dao = new BookService();
		UserService userService = new UserService();

		public void registerUsers(User user) {

			System.out.println("User Is Being Added...");
			userService.addUser(user);

		}


		public void unRegisterUsers(UUID id) {

			System.out.println("User Is Being Removed...");
			userService.removeUser(id);
		}




		public void searchByISBN (int ISBN) {

			System.out.println("Searching With ISBN..." + ISBN);
			BookService.searchByField("ISBN",String.valueOf(ISBN), "int");

			}

		public void searchByTitle (String name) {

			System.out.println("Searching With Title...");
			BookService.searchByField("name", name, "string");


		}


		public void searchByAuthor(String author) {

				System.out.println("Seaching With Author...");
				BookService.searchByField("authorname", author, "string");
		}

		//add book



		public void addBook(Book book) {



			System.out.println("Adding Book: " + book.getName() + "...");

			BookService.addBook(book);


		}

		public void showAllBooks() {

			System.out.println("Showing All Books...");
			BookService.showAllBooks();


		}
		//remove book


		public void removeBook(UUID id) {
			System.out.println("Removing" + id + "...");
			BookService.removeBook(id);
		}


		public void removeAllBooks() {
			System.out.println("Removing All Books...");
			BookService.removeAllBooks();


		}



}
