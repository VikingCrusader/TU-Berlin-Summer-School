package day6;

public class Shapes_Test {

	public static void main(String[] args) {

	}

}

abstract class Shapes {
	double length;
	double height;
	
	public Shapes(double length, double height) {
		this.length = length;
		this.height = height;
	}
	abstract double volume();
	abstract double surface();
	
}

class Rectangular extends Shapes {
	double width;
	public Rectangular(double length, double width, double height) {
		super (length, height);
		this.width = width;
		this.height = height;
	}
	double volume () {
		return this.length * this.width * this.height;
	}
	double surface () {
		return 2 * (length * width + length * height + width * height);
	}
	
	
}

class Cylindrical extends Shapes {
	double radius;
	
	public Cylindrical(double height, double radius) {
		super(0, height);
		this.radius = radius;
	}
	double volume () {
		return radius * radius * height * Mathhhh.PI;
	}
	double surface() {
		return 2 * radius * (radius + height) * Mathhhh.PI;
	}
}
