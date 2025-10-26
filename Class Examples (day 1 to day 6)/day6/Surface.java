package day6;

abstract class Shape {
	abstract double surface();	
}

class Cube extends Shape {
	double side;
	Cube (double side){
	  this.side = side;
	}
	double surface () {
		return side * side;
	}
}

class Rectangular extends Shape {
	double length, width, height;
	Rectangular(double length, double width) {
		super();
		this.length = length;
		this.width = width;
	}
	double surface () {
		return length * width;
	}
	
}

class Circle extends Shape {
	double radium;
	Circle (double radium){
		this.radium = radium;
	}
	double surface () {
		return Math.PI * radium * radium;
	}
}

public class Surface {
	public static void main(String[] args) {
		Cube c1 = new Cube (12);
		Rectangular r2 = new Rectangular (10, 20);
		Circle c3 = new Circle (5);
		System.out.println(c1.surface());
		System.out.println(r2.surface());
		System.out.println(c3.surface());
	}
}