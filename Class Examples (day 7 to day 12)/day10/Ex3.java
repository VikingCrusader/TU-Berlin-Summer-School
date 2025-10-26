package day10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b, c;
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Please enter the first integer");
			a = scanner.nextInt();
			System.out.println("Please enter the first integer");
			b = scanner.nextInt();
			
			try {
				c = a/b;
				System.out.println("The results: " + c);
			}
			catch (ArithmeticException e) {
				System.out.println(e);
				System.out.println("Please enter a non zero b values");
			}
		} catch (InputMismatchException e){
			System.out.println(e);
			System.out.println("Please enter a valid integer!");

		}
		
		System.out.println("The program is still working");

	}

}
