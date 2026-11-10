import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestMyMinHeap {

    @Test
    void isEmpty() {
        MinHeap<Integer> heap = new MinHeap<>(16);

        assertTrue(heap.isEmpty());

        heap.insert(10);

        assertFalse(heap.isEmpty());

        heap.removeMin();

        assertTrue(heap.isEmpty());
    }

    @Test
    void size() {
        MinHeap<Integer> heap = new MinHeap<>(16);

        assertEquals(0, heap.size());

        heap.insert(10);
        assertEquals(1, heap.size());

        heap.insert(5);
        heap.insert(20);
        assertEquals(3, heap.size());

        heap.removeMin();
        assertEquals(2, heap.size());

        heap.removeMin();
        heap.removeMin();
        assertEquals(0, heap.size());
    }

    @Test
    void insert() {
        MinHeap<Integer> heap = new MinHeap<>(16);

        heap.insert(10);
        assertEquals(10, heap.min());

        heap.insert(5);
        assertEquals(5, heap.min());

        heap.insert(20);
        assertEquals(5, heap.min());

        heap.insert(2);
        assertEquals(2, heap.min());

        assertEquals(4, heap.size());
    }

    @Test
    void removeMin() {
        MinHeap<Integer> heap = new MinHeap<>(16);

        heap.insert(10);
        heap.insert(5);
        heap.insert(20);
        heap.insert(2);
        heap.insert(8);

        assertEquals(2, heap.removeMin());
        assertEquals(5, heap.removeMin());
        assertEquals(8, heap.removeMin());
        assertEquals(10, heap.removeMin());
        assertEquals(20, heap.removeMin());

        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
    }

    @Test
    void min() {
        MinHeap<Integer> heap = new MinHeap<>(16);

        heap.insert(15);
        assertEquals(15, heap.min());

        heap.insert(10);
        assertEquals(10, heap.min());

        heap.insert(5);
        assertEquals(5, heap.min());

        heap.insert(20);
        assertEquals(5, heap.min());

        assertEquals(5, heap.min());
        assertEquals(4, heap.size());
    }

    @Test
    void toArray() {
        MinHeap<Integer> heap = new MinHeap<>(16);

        assertEquals(0, heap.toArray().length);

        heap.insert(10);
        heap.insert(5);
        heap.insert(20);
        heap.insert(2);

        Object[] result = heap.toArray();

        assertEquals(4, result.length);

        assertTrue(java.util.Arrays.asList(result).containsAll(
                java.util.Arrays.asList(10, 5, 20, 2)
        ));

        assertEquals(4, heap.size());
        assertEquals(2, heap.min());
    }

    @Test
    void toStringTest() {
        MinHeap<Integer> heap = new MinHeap<>(16);

        assertEquals("[]", heap.toString());

        heap.insert(10);
        assertEquals("[10]", heap.toString());

        heap.insert(5);
        heap.insert(20);
        heap.insert(2);

        assertEquals("[2, 5, 20, 10]", heap.toString());

        assertEquals(4, heap.size());
    }
}