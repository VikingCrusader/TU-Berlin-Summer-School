package day9;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ex1Test {

    @RepeatedTest(4000)
    @DisplayName("This is Surface Testing")
    public void testSurface() {
        Calculation obj1 = new Calculation(2.6, 4.8);
        double expected = Math.PI * 2.6 * 2.6;   // 更精确
        assertEquals(expected, obj1.surface(), 1e-2); // 允许 0.01 误差
    }
}
