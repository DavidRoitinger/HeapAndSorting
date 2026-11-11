import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void testNormalArray() {
        int[] array = {5, 2, 8, 1, 3};
        QuickSort qs = new QuickSort();
        qs.quicksortMot(array, array.length, 0, array.length - 1);
        assertArrayEquals(new int[]{1, 2, 3, 5, 8}, array);
    }

    @Test
    void testAlreadySorted() {
        int[] array = {1, 2, 3, 4, 5};
        QuickSort qs = new QuickSort();
        qs.quicksortMot(array, array.length, 0, array.length - 1);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    void testReverseSorted() {
        int[] array = {5, 4, 3, 2, 1};
        QuickSort qs = new QuickSort();
        qs.quicksortMot(array, array.length, 0, array.length - 1);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    void testDuplicates() {
        int[] array = {4, 2, 4, 1, 2};
        QuickSort qs = new QuickSort();
        qs.quicksortMot(array, array.length, 0, array.length - 1);
        assertArrayEquals(new int[]{1, 2, 2, 4, 4}, array);
    }
}