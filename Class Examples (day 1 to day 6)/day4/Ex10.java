package day4;
import java.util.ArrayList;
import java.util.List;

public class Ex10 {
	public static void main(String[] args) {
		List <Double> myList = new ArrayList();
		double sum = 0;
		myList.add(3.4);
		myList.add(8.8);
		myList.add(7.9);
		myList.add(9.0);
		myList.add(10.0);
		myList.add(12.0);
		myList.add(0.0);
		myList.add(-13.0);
		System.out.println(myList);
		
		for (int i = 0; i < myList.size(); i++) {
			sum += (double) myList.get(i);
		}
		System.out.println(sum);

	}
}
