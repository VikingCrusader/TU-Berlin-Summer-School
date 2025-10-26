package day2;

public class Ex17 {
	public static void main(String[] args) {
		double loan = Double.parseDouble(args[0]);
		double r = Double.parseDouble(args[1]);
		double t = Double.parseDouble(args[2]);
		
		double dv;
		dv = loan*Math.pow(1+r, t);
		System.out.println(dv);

	}
}
