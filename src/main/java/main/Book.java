package main;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Book {
	
	String name;
	String authorName;
	int ISBN;
	boolean av;
	int yearPublished;
	
	
	//getters and setters
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
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
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
	 * @param iSBN
	 * @param av
	 * @param yearPublished
	 */
	public Book(String name, String authorName, boolean av, int yearPublished) {
		super();
		this.name = name;
		this.authorName = authorName;
		ISBN = ThreadLocalRandom.current().nextInt(1000, 10000);
		this.av = av;
		this.yearPublished = yearPublished;
	}
	@Override
	public String toString() {
		return "Book [name=" + name + ", authorName=" + authorName + ", ISBN=" + ISBN + ", av=" + av
				+ ", yearPublished=" + yearPublished + "]";
	}
	public void borrowBook() {
		av = false;
	}
	
	
	public void returnBook() {
		av = true;
	}
	
	
}
