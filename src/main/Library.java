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
		
			
			
			for (User foundUser: users) {
				if (foundUser.getMemberID().equals(user.getMemberID())) {
					System.out.println("This user already exists");
					
					return;
				}
			} 
				users.add(user);
				System.out.println("user succesfully added");

		}
		
		public void unRegisterUsers(User user) {
			
			for (User foundUser : users) {
				if (foundUser.getMemberID().equals(user.getMemberID())) {
					
					users.remove(foundUser);
					
					System.out.println("User removed");
					return;
				}
				
				
			}
			System.out.println("user not found");
			
			
		}
		
		 
		public void searchByTitle (String name) {
			
			boolean found = false;
			
			for (Book book : books) {
				if (book.getName().equalsIgnoreCase(name)) {
					System.out.println("book found " + name);
					found = true;
					return;
				}
				
				
			}
			
				System.out.println("Book wasnt found");
			
		}
		
		
		public void searchByAuthor(String author) {
				ArrayList<Book> foundBooks = new ArrayList<>();

				for(Book book : books) {
					
					
					if (book.authorName.equalsIgnoreCase(author)) {
						foundBooks.add(book);
						
						
					}
					
				}
				
				if(foundBooks.isEmpty()) {
					System.out.println("no books were found");
				}
				
				System.out.println("these books were found" + foundBooks);
				
				
				
			
			
		}
		
		//add book
		
		
		
		public void addBook(Book book) {
			books.add(book);
		}
		
		
		//remove book
		
		
		public void removeBook(Book book) {
			books.remove(book);
		}
		
		
		public void showBooks () {
			
			for(Book book : books) {
				
				System.out.println(book);
				
			}
		
		}
 		
		
		
		
}
