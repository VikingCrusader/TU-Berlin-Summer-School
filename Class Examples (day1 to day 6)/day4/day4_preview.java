package day4;
import java.util.ArrayList;
import java.util.LinkedList;
//data structure
// extract the information, sort the data, search the data, delete the data, insert the data.

public class day4_preview {
	public static void main(String[] args) {
		// one dimension array
		int arr1 [] = {1,2,3,4,5};
		double arr2 [] = {2.2, 3.3, 4};
		char arr3 [] = {'a','b','c','d'};
		String arr4 [] = {"Alice", "Bob", "Celina", "David"};  
		
		//Iterating over array elements
		for (int i : arr1) {
			System.out.println(i);
		}
		
		System.out.println();
		
		for (double i : arr2) {
			System.out.println(i);
		}
		
		System.out.println();
		
		for (char i : arr3) {
			System.out.println(i);

		}
		
		System.out.println();
		
		for (String i : arr4) {
			System.out.println(i);
		}
		
		System.out.println();
		
		// two dimension array
		int arr5 [][] = {{1,2},{3,4},{5,6}};
		System.out.println(arr5.length);
		System.out.println();


		for (int i = 0; i < 3 ; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.println(arr5[i][j]); //i（外层循环）是长度，代表二维数组里面有几个一维数组，而j表示里面的一维数组的长度 

			}
		}
		
		// Array List
//		本质：基于数组实现的列表（动态扩容）
//		优点：查找快（通过索引）
//		缺点：插入/删除慢（需要移动元素）
		
		System.out.println("................");

		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(40);
		list.add(80);
		list.add(299);
		list.add(2, 35);  //在指定位置添加元素
		System.out.println(list.get(2));
		System.out.println(list.size());
		list.remove(list.size()-1);
		
		for (int temp : list) {
			System.out.println(temp);
		}
		
		LinkedList<String> strList = new LinkedList<>();
		strList.addLast("Paris");
		strList.addLast("Berlin");
		strList.addFirst("London");
		strList.removeFirst();
		for (String str : strList) {
			System.out.println(str);

		}
	}
}