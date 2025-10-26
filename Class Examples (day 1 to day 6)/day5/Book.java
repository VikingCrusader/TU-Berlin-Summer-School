package day5;

public class Book {
	// Attributes
	private String title;
	private String author;
	private String isbn;
	private double profit = 0.15;
	private double price;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void printInfo (double profit) {
		System.out.println("Book Title: " + title);
		System.out.println("Book Author: " + author);
		System.out.println("Price: " + salePrice(this.profit));

	}
	
	public double salePrice (double profit) {
		return price * profit + price;
	}
}
