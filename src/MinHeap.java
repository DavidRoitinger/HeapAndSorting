import java.util.NoSuchElementException;

public class MinHeap<T extends Comparable<T>> implements  MyMinHeap<T>{

    private T[] heap;

    private int length = 0;
    private int capacity = 0;

    public MinHeap(int initCapacity) {
        capacity = initCapacity;
        //Todo: check for better looking init...
        heap = (T[]) new Comparable[capacity];
    }

    @Override
    public boolean isEmpty() {
        if (length == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public void insert(T val) throws IllegalArgumentException {
        if(length == capacity){
            increaseCapacity(2);
        }
        int valPos = length;
        heap[valPos] = val;
        length++;

        upHeap(valPos);
    }



    @Override
    public T removeMin() throws NoSuchElementException {
        T minElement = heap[0];

        heap[0] = heap[length - 1];
        heap[length - 1] = null;
        length--;

        downHeap(0);
        return minElement;
    }

    @Override
    public T min() throws NoSuchElementException {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return heap[0];
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[length];
        for (int i = 0; i < length; i++) {
            array[i] = heap[i];
        }
        return array;
    }

    @Override
    public String toString(){
        String erg = "[";
        for (int i = 0; i < length; i++) {
            erg += heap[i].toString();
            if(i < length - 1){
                erg += ", ";
            }
        }
        erg += "]";

        return erg;
    }

    private void upHeap(int index){
        int parentIndex = parent(index);
        T child = heap[index];
        T parent = heap[parentIndex];
        if(child.compareTo(parent) < 0){
            swap(index, parentIndex);
            upHeap(parentIndex);
        }
    }
    private void downHeap(int index){

        int leftChildIndex = leftChild(index);
        int rightChildIndex = rightChild(index);

        T parent = heap[index];
        T smallestChild = null;
        int smallestChildIndex = -1;

        if(leftChildIndex >= length){
            //No more children...
            return;

        } else if(rightChildIndex >= length){
            //only left child...
            smallestChild = heap[leftChildIndex];
            smallestChildIndex = leftChildIndex;

        }else {
            //both children exist -> find smaller one...
            T leftChild = heap[leftChildIndex];
            T rightChild = heap[rightChildIndex];

            if(leftChild.compareTo(rightChild) < 0){
                smallestChild = leftChild;
                smallestChildIndex = leftChildIndex;
            }else {
                smallestChild = rightChild;
                smallestChildIndex = rightChildIndex;
            }
        }

        if(parent.compareTo(smallestChild) > 0){
            swap(index, smallestChildIndex);
            downHeap(smallestChildIndex);
        }
    }
    private int parent(int index){
        return (index - 1) / 2;
    }
    private int leftChild(int index){
        return 2 * index + 1;
    }
    private int rightChild(int index){
        return 2 * index + 1;
    }
    private void swap(int index1, int index2){
        T element1 = heap[index1];
        heap[index1] = heap[index2];
        heap[index2]  = element1;
    }

    private void increaseCapacity(int factor) {
        capacity *= factor;
        T[] newHeap = (T[]) new Comparable[capacity];
        for (int i = 0; i < length; i++) {
            newHeap[i] = heap[i];
        }
        heap = newHeap;
    }
}
