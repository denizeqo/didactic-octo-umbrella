package main;

import java.util.UUID;

public class Book {

	//ALWAYS MAKE VARIABLES PRIVATE or PROTECTED to prevent direct access
	private String name;
	String authorName;
	//Use wrapper classes for primitive types
	private Integer isbn;
	UUID bookID;
	boolean av;
	int yearPublished;
	int numberOfCopies;


	//getters and setters


	/**
	 * @return the bookID
	 */
	public UUID getBookID() {
		return bookID;
	}
	/**
	 * @return the av
	 */
	public boolean isAv() {
		return av;
	}
	/**
	 * @param av the av to set
	 */
	public void setAv(boolean av) {
		this.av = av;
	}
	/**
	 * @return the numberOfCopies
	 */
	public int getNumberOfCopies() {
		return numberOfCopies;
	}
	/**
	 * @param numberOfCopies the numberOfCopies to set
	 */
	public void setNumberOfCopies(int numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}
	/**
	 * @param bookID the bookID to set
	 */
	public void setBookID(UUID bookID) {
		this.bookID = bookID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int iSBN) {
		isbn = iSBN;
	}
	public boolean getAvailability() {
		return av;
	}
	public void setAvailability(boolean av) {
		this.av = av;
	}
	public int getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}




	/**
	 * @param name
	 * @param authorName
	 * @param isbn
	 * @param av
	 * @param yearPublished
	 */
	public Book(String name, String authorName, boolean av, int yearPublished, int isbn, int numberOfCopies) {
		super();
		this.name = name;
		this.authorName = authorName;
		this.isbn = isbn;
		this.av = av;
		this.yearPublished = yearPublished;
		this.bookID = UUID.randomUUID();
		this.numberOfCopies = numberOfCopies;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", authorName=" + authorName + ", ISBN=" + isbn + ", bookID=" + bookID + ", av="
				+ av + ", yearPublished=" + yearPublished + ", numberOfCopies=" + numberOfCopies + "]";
	}
	public void borrowBook() {
		av = false;
	}


	public void returnBook() {
		av = true;
	}


}
