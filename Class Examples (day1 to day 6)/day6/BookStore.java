package day6;

public class BookStore {

	public static void main(String[] args) {
		
		// Creating a new book from the class
		
		
		Book book2 = new Book("Lord of the Ring", "Tolking", 24.9, "YHSUSHSJISOSJ", "SCI FI", 0.15);
		book2.printInfo();
		System.out.println(book2.salePrice());

	}

}
