import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
public class RadixSortTest {

    @Test
    void testRadixSort() {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        int[] expected = {2, 24, 45, 66, 75, 90, 170, 802};
        RadixSort.radixSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testRadixSortWithDuplicateValues() {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66, 90};
        int[] expected = {2, 24, 45, 66, 75, 90, 90, 170, 802};
        RadixSort.radixSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testRadixSortMax() {
        int[] arr = {6, -7, 88, 120, 99, 100, -301};
        int expected = 120;

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        assertEquals(expected, max);
    }
}