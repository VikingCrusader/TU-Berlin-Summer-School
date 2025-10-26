package day6;

public class TestPets {
	public static void main(String[] args) {
		Pets p1 = new Pets("Lucky","Dog",7,100,10);
		Pets p2 = new Pets("Meow Meow","Cat",10, 150, 20);
		System.out.println(p1.toString());
		System.out.println(p1.final_sales_price());
		System.out.println(p2.toString());
		System.out.println(p2.final_sales_price());
	}
}
