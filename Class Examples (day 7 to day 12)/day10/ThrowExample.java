package day10;

public class ThrowExample {

    public static void checkAge(int age) {
        if (age < 18) {
            // 手动抛出一个 IllegalArgumentException 异常
            throw new IllegalArgumentException("Access denied: You must be at least 18 years old.");
        } else {
            System.out.println("Access granted: You are old enough.");
        }
    }

    public static void main(String[] args) {
        try {
            checkAge(16);  // 测试：小于 18 会抛异常
        } catch (IllegalArgumentException e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }

        System.out.println("Program continues...");
    }
}
