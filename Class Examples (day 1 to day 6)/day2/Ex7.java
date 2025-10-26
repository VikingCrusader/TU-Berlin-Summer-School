package day2;
import java.util.Scanner;

public class Ex7 {
	public static void main(String[] args) {
		System.out.println("Please enter a double number");
		Scanner input = new Scanner(System.in);
		double x = input.nextDouble();
		double y = 3 * Math.pow(x, 3) - 5 * Math.sqrt(Math.abs(x)) + 3 * Math.pow(x, 2) - Math.exp(-3*x);
		input.close();
		System.out.println(y);
		
		double z, fx;
		z = Double.parseDouble(args[0]);
		fx = 3 * Math.pow(z, 3) - 5 * Math.sqrt(Math.abs(z)) + 3 * Math.pow(z, 2) - Math.exp(-3*z);
		System.out.println("f(x)= "+ fx);

	}

}
