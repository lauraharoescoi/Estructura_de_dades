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
        for (int i = array.length; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(j + 1, j);
                }
            }
        }
    }

    public void selectionSort() {
        int aux = 0;
        for (int i = 0; i < array.length; i++) {
            aux = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[aux]) {
                    aux = j;
                }
            }
            swap(i, aux);
        }
    }

    public void quickSort() {
        if (array.length > 1) {
            quickSort(0, array.length - 1);
        }
    }

    public void quickSort(int left, int right) {
        int leftLimit = left;
        int rightLimit = right;
        int pivot = array[right];

        while (leftLimit < rightLimit ) {
            while (array[leftLimit] < pivot) {
                leftLimit++;
            }
            while (array[rightLimit] >= pivot && rightLimit > leftLimit) {
                rightLimit--;
            }
            if (leftLimit < rightLimit) {
                swap(leftLimit, rightLimit);
            }
        }
        swap(right, rightLimit);

        if (left < rightLimit -  1) {
            quickSort(left, rightLimit - 1);
        }
        if (rightLimit + 1 < right) {
            quickSort(rightLimit + 1, right);
        }
    }
}
