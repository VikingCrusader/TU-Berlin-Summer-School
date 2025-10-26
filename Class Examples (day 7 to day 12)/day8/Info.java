package day8;

public class Info <T> {
	private T a;
	
	public Info(T a) {
		super();
		this.a = a;
	}
	
	

	public T getA() {
		return a;
	}



	public void setA(T a) {
		this.a = a;
	}



	public void printInfo () {
		System.out.println(a);
	}
}
