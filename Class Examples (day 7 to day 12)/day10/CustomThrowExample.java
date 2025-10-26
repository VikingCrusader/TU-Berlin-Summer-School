package day10;

public class CustomThrowExample {
    public static void checkAge(int age) throws UnderAgeException {
        if (age < 18) {
            throw new UnderAgeException("Custom Exception: Must be 18+");
        } else {
            System.out.println("Welcome!");
        }
    }

    public static void main(String[] args) {
        try {
            checkAge(15);
        } catch (UnderAgeException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}

class UnderAgeException extends Exception {
    public UnderAgeException(String message) {
        super(message);
    }
}
