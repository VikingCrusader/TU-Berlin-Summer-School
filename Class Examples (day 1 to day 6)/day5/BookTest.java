package day5;

import java.util.ArrayList;
import java.util.List;

public class BookTest {

	public static void main(String[] args) {
		Book b1 = new Book();
		b1.setTitle("Harry Potter");
		b1.getAuthor("J.K.Rolling");
		b1.setIsbn("22222200099ABL");
		b1.price = 14.9;
		Book b2 = new Book();
		b2.title = "Lord of the Ring";
		b2.author = "John Ronald Reuel Tolkien";
		b2.isbn = "88989999900JH2";
		b2.price = 19.0;
		Book b3 = new Book();
		b3.title = "Ritch dad poor dad";
		b3.author = "Robert Kiyosaki";
		b3.isbn = "92929299292KL7";
		b3.price = 20;
		List <Book> myList = new ArrayList();
		
		printInfo(b1);
		
		double sp = b1.salePrice(0.15);
		System.out.println(sp);
		System.out.println(printInfo());


		
	}
	
	public static void printInfo (Book obj) {
		System.out.println("Book Title: " + obj.title);
		System.out.println("Book Author: " + obj.author);
	}
	
	
}
