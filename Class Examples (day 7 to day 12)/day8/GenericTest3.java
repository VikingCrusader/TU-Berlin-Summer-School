package day8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericTest3 {
	public static void main(String[] args) {
		List <Integer> myList = new ArrayList<Integer>();
		Integer a  = 6;
		myList.add(a);
		List <Integer> list = Arrays.asList(5, 7, 8, 9, 20);  // treated as an array, can not extend the length.
		System.out.println(list);
		list.set(0, 1);
		System.out.println(list);
		var name = "Alex";
		var number = 19;
		System.out.println(name.getClass());

	}
}
