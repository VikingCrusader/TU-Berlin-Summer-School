package day10;

public class TestCustomException {

	public static void validate (int age) throws InvalidAgeException {
		if (age < 18) {
			throw new InvalidAgeException ("Age is not valid to vote");
		} else {
			System.out.println("Welcome to vote");

		}
	}

}
