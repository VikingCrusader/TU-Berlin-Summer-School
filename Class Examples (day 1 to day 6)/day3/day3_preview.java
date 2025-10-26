package day3;
import java.util.ArrayList;

public class day3_preview {
	//Loop generally same as C, but there is one more thing: for each, for iterating an array or object.
	//for each循环，用来遍历数组/Arraylist/集合/Hashset等等等等
	
	public static void main(String[] args) {
		//遍历普通数组
		int[] arr = {1, 2, 3, 4, 5};
		for (int num : arr) {
			System.out.println(num);
		}
		//遍历字符数组
		String[] arr1 = {"Alex", "Bob", "Celine", "David", "Elina"};
		for (String names : arr1) {
			System.out.println(names);
		}
		//遍历Arraylist
		ArrayList<String> names = new ArrayList<>();
		names.add("Alice");
		names.add("Bob");
		names.add("Charlie");
		
		for (String name : names) {
		    System.out.println(name);
		}
		
		
	}
	
}
