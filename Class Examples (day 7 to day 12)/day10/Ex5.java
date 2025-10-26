package day10;

public class Ex5 {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};

        try {
            System.out.println("Accessing element at index 5: " + numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index out of bounds! The array length is " + numbers.length);
        }

        System.out.println("Program continues running...");
    }
}
