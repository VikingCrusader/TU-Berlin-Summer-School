package day9;

public class Calculation {
	private double a;
	private double b;
	
	public Calculation(double a, double b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	
	public double add () {
		return a + b;
	}
	public double mul () {
		return a + b;
	}
	public double surface () {
		return Math.PI * this.a * this.a;
	}
}
