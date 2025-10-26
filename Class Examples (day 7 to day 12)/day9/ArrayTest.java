package day9;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayTest {

    public static int[] addArrays(int[] a, int[] b) {
        if (a == null || b == null) throw new IllegalArgumentException("null array");
        if (a.length != b.length) throw new IllegalArgumentException("length mismatch");
        int[] c = new int[a.length];
        for (int i = 0; i < a.length; i++) c[i] = a[i] + b[i];
        return c;
    }

    @Test
    public void testAdd() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};
        int[] expected = {5, 7, 9};
        assertArrayEquals(expected, addArrays(arr1, arr2));
    }
}
