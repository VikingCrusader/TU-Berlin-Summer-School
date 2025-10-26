package day6;

public class Math_Later extends Mathhhh {
	private double a;
	private double b;
	public Math_Later(double a, double b) {
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
	
	// (a*b) - (a+b)
	public double calculate_ab() {
		double res = super.mul() - super.add();
		return res;
	}
	
}
