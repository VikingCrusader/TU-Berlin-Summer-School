package day3;

public class Ex8 {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
		
		System.out.println(".....................");

		for (int i = 0; i < 10; i += 2) {
			System.out.println(i);

		}
		
		// do not change the index inside the loop
		
		// nested loop : loop inside a loop
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(i);
				System.out.println(j);

			}
		}
	}
}
