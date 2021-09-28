package sorting;

/**
 * @author jmgimeno
 */

public class IntArraySorter {

    private final int[] array;

    public IntArraySorter(int[] array) {
        this.array = array;
    }

    public boolean isSorted() {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public void swap(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public void insertionSort() {
        // Invariant: The prefix [0, end) is a sorted array
        for (int end = 1; end < array.length; end++) {
            // We insert element at end into this prefix

            // Invariant: arrays sorted in the ranges [0, insert)
            // and [insert, end] and all elements in [0, insert)
            // are lower than or equal to those in [insert+1, end]


            for (int insert = end; insert >= 1; insert--) {
                if (array[insert - 1] > array[insert]) {
                    swap(insert - 1, insert);
                } else {
                    break;
                }
            }
        }
    }

    public void bubbleSort() {
        for (int sorted = array.length; sorted > 0; sorted--) {
            for (int pos = 0; pos < sorted - 1; pos++) {
                if (array[pos] > array[pos + 1]) {
                    swap(pos + 1, pos);
                }
            }
        }
    }

    public void selectionSort() {
        int compare = 0;
        for (int pos = 0; pos < array.length; pos++) {
            compare = pos;
            for (int i = pos; i < array.length; i++) {
                if (array[i] < array[compare]) {
                    compare = i;
                }
            }
            swap(pos, compare);
        }
    }

    public void quickSort() {
        quickSort(0, array.length);
    }

    public void quickSort(int left, int right) {
        int leftLimit = left;
        int rightLimit = right - 2;
        int pivot = array[right - 1];

        while (leftLimit < rightLimit ) {
            while (array[leftLimit] < pivot) {
                leftLimit++;
            }
            while (array[rightLimit] >= pivot && rightLimit > leftLimit) {
                rightLimit--;
            }
        }
        if (rightLimit != right - 1) {
            swap(leftLimit, right - 1);

            if (leftLimit - left > 1) {
                quickSort(left, leftLimit);
            }
            if (right - rightLimit > 1) {
                quickSort(rightLimit + 1, right - 1);
            }
        }
    }

}
