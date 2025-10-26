package day11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Ex1 {

	public static void main(String[] args) {
		Collection <String> myCollection = new ArrayList();
		myCollection.add("Apple");
		myCollection.add("Orange");
		myCollection.add("Banana");
		myCollection.add("Mango");
		myCollection.forEach(t -> System.out.println(t)); // only lambda here 
		
		Iterator <String> iterator = myCollection.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
