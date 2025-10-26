package day6;

public class OuterClass {
	private String name;
	private double number;
	
	public OuterClass(String name, double number) {
		this.name = name;
		this.number = number;
	}

	public OuterClass() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getNumber() {
		return number;
	}

	public void setNumber(double number) {
		this.number = number;
	}

	public String toString() {
		return "OuterClass [name=" + this.name + ", number=" + this.number + "]";
	}
	
	//Inner Class
	class Inner {
		void printName() {
			System.out.println(name);

		}
	}
	
	
	
}
