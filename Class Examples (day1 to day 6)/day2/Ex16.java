package day2;
import java.util.Scanner;
import java.util.Random;

public class Ex16 {
	public static void main(String[] args) {
		int a, b;
		Scanner input = new Scanner (System.in);
		System.out.println("Enter a: ");
		int start = input.nextInt();
		System.out.println("Enter b: ");
		int end = input.nextInt();
		int random = (int)((Math.random() * ( end - start + 1)) + start);
		System.out.println("The generated integer is: "+random);
		
		int c, d;
		c = Integer.parseInt(args[0]);
		d = Integer.parseInt(args[1]);
		
	}
}
