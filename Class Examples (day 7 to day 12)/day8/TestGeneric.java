package day8;

public class TestGeneric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] names = {"Donald", "John", "Sara", "Lee"};
		Integer [] numbers = {4, 8, 9, 3, 6, 19, -12};
		Double [] dnum = {4.4, 3.9, 2.0};
		Character [] chars = {'a', 'b', 'c', 'd'};
		printArray (names);
		printArray (numbers);
		printArray (dnum);
		printArray (chars);
		Integer a = 20;
		Double b = 7.9;
		Info obj = new Info (a);
		obj.printInfo();
		Info obj2 = new Info (b);
		obj2.printInfo();
		
	}
	public static <T> void printArray (T [] arr) {
		for (T t : arr) {
			System.out.println(t + " ");

		}
	}
}
