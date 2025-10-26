package day6;

public class MathNewM extends Mathhhh {
	private double a;
	private double b;
	
	// Constructor
	public MathNewM(double a, double b) {
		super(a, b);
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
	
	public double div () {
		if (this.b != 0) {
			return this.a / this.b;
		} else {
			return Double.POSITIVE_INFINITY;
		}
	}
	
	public double reminder () {
		return this.a % this.b;
	}
	
	
	
}
