package main.java.model;

import main.java.services.Library;

public class Librarian {

	private String librarianId;
	private String librarianName;

	public void addBookToLibrary(Library library, Book book) {

		library.addBook(book);

	}

	/**
	 * @param uuid
	 * @param librarianName
	 */
	public Librarian(String uuid, String librarianName) {
		this.librarianId = uuid;
		this.librarianName = librarianName;
	}

	public void removeBook(Library library, Book book) {

	}

}
