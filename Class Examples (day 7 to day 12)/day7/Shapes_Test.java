package day7;

public class Shapes_Test {

    public static void main(String[] args) {
        // Rectangular
        Shapes box = new Rectangular(5, 3, 4);
        System.out.println("Rectangular Box:");
        System.out.println("Volume: " + box.volume());
        System.out.println("Surface Area: " + box.surface());
        System.out.println();

        // Cylindrical
        Shapes cylinder = new Cylindrical(6, 2);
        System.out.println("Cylindrical:");
        System.out.println("Volume: " + cylinder.volume());
        System.out.println("Surface Area: " + cylinder.surface());
    }

}

abstract class Shapes {
    double length;
    double height;

    public Shapes(double length, double height) {
        super();
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
        return radius * radius * height * Math.PI;
    }
    double surface() {
        return 2 * radius * (radius + height) * Math.PI;
    }
}


class VolumnN extends Shapes{
	private double h;
	private double l;
	private double w;
	public double getH() {
		return h;
	}
	public void setH(double h) {
		this.h = h;
	}
	public double getL() {
		return l;
	}
	public void setL(double l) {
		this.l = l;
	}
	public double getW() {
		return w;
	}
	public void setW(double w) {
		this.w = w;
	}
	
	public VolumnN(double length, double height, double h, double l, double w) {
		super(length, height);
		this.h = h;
		this.l = l;
		this.w = w;
	}
	
	// TODO : Calculate Volume
	
	@Override
	double volume () {
		double Volume = this.h * this.l * this.w;
		return Volume;
	}
	
	
	// TODO : Calculate Surface abstract method
	
	@Override
	double surface () {
		double Surface = this.w * this.l;
		return Surface;
	}
	
}








