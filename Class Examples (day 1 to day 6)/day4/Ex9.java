package day4;
import java.util.ArrayList;
import java.util.List;

public class Ex9 {
	public static void main(String[] args) {
		List myList = new ArrayList();
		myList.add(22);
		myList.add(44.8);
		myList.add(33.8);
		myList.add(-2);
		
		System.out.println(myList);  // printing list
		myList.add("one"); // List里面存放的是对象，不是某个数据类型，所以什么都可以往里装
		myList.add(true);
		
		System.out.println(myList);
		
		double a, b, c;
//		a = myList[0]; NO There is no indices in List
		
		for ( int i = 0; i < myList.size(); i++) {
			System.out.println(myList.get(i));
		}
		
		// Add element at the beginning of the list
		myList.addFirst("First");
		System.out.println(myList);
		myList.addLast("Last");
		System.out.println(myList);
		myList.add(2, "Middle");
		
		//remove one element
		myList.remove(0);
		System.out.println(myList);
		myList.remove(true);
		System.out.println(myList);
		
		myList.clear();
		System.out.println(myList);


	}
}
