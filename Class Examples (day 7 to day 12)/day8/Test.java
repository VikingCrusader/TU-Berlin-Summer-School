package day8;

public class Test {
	public static void main(String[] args) {
		MathT obj = new MathT();
		obj.a = 12.8;
		obj.b = 0.2;
		double res = obj.add();
		if (res == 13.0) {
			System.out.println("Correct Program.");
		} else {
			System.out.println("Error");

		}
	}
}

class MathT {
	double a;
	double b;
	public double add () {
		return this.a + this.b;
	}
}