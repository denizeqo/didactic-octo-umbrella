package main;
import java.lang.reflect.Array;
import java.util.*;
public class Library {
	
		
		ArrayList<Book> books = new ArrayList<> ();
		ArrayList<User> users = new ArrayList<> ();
		ArrayList<Librarian> librarian = new ArrayList<>();
		/**
		 * @return the books
		 */
		public ArrayList<Book> getBooks() {
			return books;
		}
		/**
		 * @param books the books to set
		 */
		public void setBooks(ArrayList<Book> books) {
			this.books = books;
		}
		/**
		 * @return the users
		 */
		public ArrayList<User> getUsers() {
			return users;
		}
		/**
		 * @param users the users to set
		 */
		public void setUsers(ArrayList<User> users) {
			this.users = users;
		}
		/**
		 * @return the librarian
		 */
		public ArrayList<Librarian> getLibrarian() {
			return librarian;
		}
		/**
		 * @param librarian the librarian to set
		 */
		public void setLibrarian(ArrayList<Librarian> librarian) {
			this.librarian = librarian;
		}
		/**
		 * @param books
		 * @param users
		 * @param librarian
		 */
		public Library(ArrayList<Book> books, ArrayList<User> users, ArrayList<Librarian> librarian) {
			this.books = books;
			this.users = users;
			this.librarian = librarian;
		}
		
	
		public void registerUsers(User user) {
		
			boolean userExists =users.stream()
			.anyMatch(newUser -> user.getMemberID().equals(user.getMemberID()));
			
			if(userExists) {
				System.out.println("the user already exists");
			} else {
				
				if(user.getMemberID().equals(null)) {
					user.setMemberID(UUID.randomUUID());
				}
				
				users.add(user);
				
				System.out.println("user registered succesfully");
			}

		}
		
		public void unRegisterUsers(User user) {
			
			
			
			boolean removed = users.removeIf(foundUser -> foundUser.getMemberID().equals(user.getMemberID()));

		    if (removed) {
		        System.out.println("User removed");
		    } else {
		        System.out.println("User not found");
		    }
			
			
		}
		
		
		public void searchByISBN (int ISBN) {
			books.stream()
			.filter(book -> book.getISBN() == ISBN)
			.findFirst()
			.ifPresentOrElse(book -> System.out.println("the book is found" + book), () -> 
			System.out.println("The book isnt found with isbn" + ISBN));
			
			}
		 
		public void searchByTitle (String name) {
			
			books.stream()
			.filter(book -> book.getName().equals(name))
			.findFirst()
			.ifPresentOrElse(book -> System.out.println("The book is present" + name),
					() -> System.out.println("book isnt present"));
			
		}
		
		
		public void searchByAuthor(String author) {
				
				
			books.stream().filter(book -> book.getAuthorName().equalsIgnoreCase(author))
			.forEach(book -> System.out.println(book));
			
		}
		
		//add book
		
		
		
		public void addBook(Book book) {
			boolean exists = books.stream().anyMatch(addedBook -> book.getAuthorName()
					.equalsIgnoreCase(addedBook.getAuthorName()));
			
			
			if (exists) {
				System.out.println("the book already exists");
			} else {
				System.out.println("the book is being added");
				books.add(book);
				System.out.println("book added");
			}
			
		}
		
		public void showAllBooks() {
		    books.forEach(book -> System.out.println("Title: " 
		+ book.getName() + ", Author: " + book.getAuthorName() + ", Year Published: " + book.getYearPublished()));
		}
		//remove book
		
		
		@Override
		public String toString() {
			return "Library [books=" + books + "]";
		}
		public void removeBook(Book book) {
			
			    if (books.remove(book)) {
			        System.out.println("Book removed successfully.");
			    } else {
			        System.out.println("Book doesn't exist.");
			    }

		
		}
 		
		
		
		
}
