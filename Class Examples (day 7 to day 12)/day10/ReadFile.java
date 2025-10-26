package day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ReadFile {

	public static void main(String[] args) {
		
		String url = "/Users/hallowelt/eclipse-workspace/TUB.project/src/data/data";
		
		List <Integer> myList = new ArrayList<>();
		
		try {
			
			//create a file object
			File file = new File (url);
			//Scanner
			Scanner scanner = new Scanner (file);
			
			while(scanner.hasNext()) {
				myList.add(scanner.nextInt());
			}
			
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);

		} catch (InputMismatchException e) {
			System.out.println("File has an error data");

		}
		
		System.out.println(myList);

		
		
	}

}
