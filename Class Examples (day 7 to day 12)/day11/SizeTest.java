package day11;

public class SizeTest {

	public static void main(String[] args) {
		// print the enum Size
		for (Size t : Size.values()) {
			System.out.println(t.getDescription());
		}
	}

}
