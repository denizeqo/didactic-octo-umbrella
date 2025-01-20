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
