package day6;

public class Book {
	// Attribute
	private String title;
	private String author;
	private double price;
	private String isbn;
	private String description;
	private double profit;
	
	// constructor 可以有多个，用哪个看参数（多态）
	// for initialize the attributes
	
	public Book(String title, String author, double price, String isbn, String description, double profit) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.isbn = isbn;
		this.description = description;
		this.profit = profit;
	}

	// Getters and setters
	public String getTitle () {
		return this.title;
	}
	
	public void setTitle (String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	// Method
	public void printInfo () {
		System.out.println("The book title: " + this.title);
		System.out.println("Author: " + this.author);
		System.out.println("Isbn: " + this.isbn );
		System.out.println("Price: " + this.price);
	}
	
	public double salePrice () {
		return this.price * this.profit + this.price;
	}
}
























