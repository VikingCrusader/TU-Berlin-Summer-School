package day7;

public class Ex1 {

	public static void main(String[] args) {
		// print hello
		printHello b = () -> System.out.println("Hello");
		b.printH();
		
		// string process
		stringTransform toUpper = (s) -> s.toUpperCase();
		String a = toUpper.opreate("shshshshsjjsjshsjsjsj");
		System.out.println(a);
		
		// add two integers
		Calculate add = (x, y) -> x + y;
		int c = add.operate(75,38);
		System.out.println(c);
	}

}

interface printHello {
	public void printH();
}

interface stringTransform {
	public String opreate(String s);
}

interface Calculate {
	public int operate (int a, int b);
}