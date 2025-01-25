package main;

import java.util.ArrayList;
import java.util.UUID;

public class User {
	
	String name;
	private String memberID;
	private String phoneNumber;
	private String Address;
	ArrayList <Book> borrowedBooks = new ArrayList<>();
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the memberID
	 */
	public String getMemberID() {
		return memberID;
	}
	/**
	 * @param uuid the memberID to set
	 */
	public void setMemberID(String uuid) {
		this.memberID = uuid;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return Address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		Address = address;
	}
	/**
	 * @return the borrowedBooks
	 */
	public ArrayList<Book> getBorrowedBooks() {
		return borrowedBooks;
	}
	/**
	 * @param borrowedBooks the borrowedBooks to set
	 */
	public void setBorrowedBooks(ArrayList<Book> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}
	/**
	 * @param name
	 * @param memberID
	 * @param phoneNumber
	 * @param address
	 * @param borrowedBooks
	 */
	
	
	public User(String name, String memberID, String phoneNumber, String address, ArrayList<Book> borrowedBooks) {
		super();
		this.name = name;
		this.memberID = memberID;
		this.phoneNumber = phoneNumber;
		Address = address;
		this.borrowedBooks = borrowedBooks;
	}
	
	
	
	public void borrowBook(Book book) {
		if (book.getAvailability()) {
			book.setAvailability(false);
			borrowedBooks.add(book);
			System.out.println("The book was borrowed succesfully " + book.getName() + "and now the books availability is " +book.getAvailability());
			borrowedBooks.forEach(foundbook -> System.out.println(foundbook.toString()));
			
		} else {
			System.out.println("The  book has already been borrowed");
		}
	}
	
	
	public void returnBook(Book book) {
		if(borrowedBooks.contains(book)) {
			System.out.println("the book was returned" + book.getName());
			book.setAvailability(true);
			borrowedBooks.remove(book);
			
			System.out.println(book.av);
			
		}
	}
	
	
	
	
	
	
}
