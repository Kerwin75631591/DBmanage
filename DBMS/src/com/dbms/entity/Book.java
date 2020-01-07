package com.dbms.entity;

public class Book {
    private String isbn;
    private String bname;
	private String author;
	private int price;
    private int storage;
	private int avaliblity;
	private int buynum;
	public int getBuynum() {
		return buynum;
	}
	public void setBuynum(int buynum) {
		this.buynum = buynum;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStorage() {
		return storage;
	}
	public void setStorage(int storage) {
		this.storage = storage;
	}
	public int getAvaliblity() {
		return avaliblity;
	}
	public void setAvaliblity(int avaliblity) {
		this.avaliblity = avaliblity;
	}
	
}
