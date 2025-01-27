package main.java.model;

import java.util.ArrayList;
import java.util.UUID;

public class User {

	String name;
	private String memberID;
	private String phoneNumber;
	private String Address;

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
	

	public User(String name, String phoneNumber, String address) {
		super();
		this.name = name;
		this.memberID = UUID.randomUUID().toString();
		this.phoneNumber = phoneNumber;
		Address = address;
		
	}
}
