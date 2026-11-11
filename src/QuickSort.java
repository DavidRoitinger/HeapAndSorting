public class QuickSort implements IQuickSort{

    @Override
    public void quicksortMot(int[] array, int size, int left, int right) {
        if(left < right){
            int p = partition(array, size, left, right);
            quicksortMot(array, size, left, p);
            quicksortMot(array, size, p + 1, right);
        }
    }

    private int partition(int[] array, int size, int left, int right) {
        int mid = (left + right) / 2;

        int leftVal = array[left];
        int midVal = array[mid];
        int rightVal = array[right];

        // Median of three
        int pivot;

        if ((leftVal <= midVal && midVal <= rightVal) ||
                (rightVal <= midVal && midVal <= leftVal)) {
            pivot = midVal;
        } else if ((midVal <= leftVal && leftVal <= rightVal) ||
                (rightVal <= leftVal && leftVal <= midVal)) {
            pivot = leftVal;
        } else {
            pivot = rightVal;
        }

        int i = left - 1;
        int j = right + 1;

        while (true) {
            do {
                i++;
            } while (array[i] < pivot);

            do {
                j--;
            } while (array[j] > pivot);

            if (i >= j) {
                return j;
            }

            // Swap
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
