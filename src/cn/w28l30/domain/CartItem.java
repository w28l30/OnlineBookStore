package cn.w28l30.domain;

public class CartItem {
	private Book book;
	private double price;
	private int quantity;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public double getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.price = quantity * this.getBook().getPrice();
		this.quantity = quantity;
	}
	
	
}
