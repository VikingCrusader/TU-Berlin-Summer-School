package day2;

public class Ex18 {
	public static void main(String[] args) {
		double radius = Double.parseDouble(args[0]);
		double S;
		S = Math.PI * Math.pow(radius, 2);
		System.out.println("The area of the circle is: "+S);
	}
}
