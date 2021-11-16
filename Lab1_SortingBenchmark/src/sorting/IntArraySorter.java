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
        for (int i = array.length; i > 0; i--) {                            // bucle per recórrer tota l'array
            for (int j = 0; j < i - 1; j++) {                               // bucle per recórrer el subarray
                if (array[j] > array[j + 1]) {                              // condició per fer el swap si el seu consecutiu és més petit
                    swap(j + 1, j);
                }
            }
        }
    }

    public void selectionSort() {
        int aux = 0;                                                        // variable auxiliar
        for (int i = 0; i < array.length; i++) {                            // bucle per recórrer l'array
            aux = i;                                                        // guardem a la variable auxiliar el primer element
            for (int j = i; j < array.length; j++) {                        // tornem a recorre l'array
                if (array[j] < array[aux]) {                                // condició per veure assignar quin es el nombre més petit per a cada posició de l'array
                    aux = j;                                                // assignar la nova posició a la variable auxiliar
                }
            }
            swap(i, aux);                                                   // canviar l'element a la posició corresponent
        }
    }

    public void quickSort() {

        if (array.length > 1) {                                             // precondició per no haver de recórrer tot el bucle
            quickSort(0, array.length - 1);                                 // crida de la subfunció recursiva
        }
    }

    public void quickSort(int left, int right) {
        int leftLimit = left;                                               // leftLimit sera la que buscarà d'esquerra a dreta (elements més grans que el pivot)
        int rightLimit = right;                                             // rightLimit sera la que buscarà de dreta a esquerra (elements més petits que el pivot)
        int pivot = array[right];                                           // triem com a pivot l'últim element de l'array o subarray

        while (leftLimit < rightLimit ) {                                   // condició per a qué el buscador pari quan es creuin

            while (array[leftLimit] < pivot) {                              // busca l'element més gran que el pivot
                leftLimit++;
            }
            while (array[rightLimit] >= pivot && rightLimit > leftLimit) {  // busca l'element més petit que el pivot
                rightLimit--;
            }
            if (leftLimit < rightLimit) {                                   // si no no s'han creuat, es fa el swap
                swap(leftLimit, rightLimit);
            }
        }
        swap(right, rightLimit);                                            // col·loquem el pivot al centre de les dues mitats que hem fet

        if (left < rightLimit -  1) {                                       // condició per dur a terme la recursivitat de la meitat cap a l'esquerra
            quickSort(left, rightLimit - 1);                                // recursivitat amb una subarray a l'esquerra
        }
        if (rightLimit + 1 < right) {                                       // condició per dur a terme la recursivitat de la meitat cap a la dreta
            quickSort(rightLimit + 1, right);                               // recursivitat amb una subarray a la dreta
        }
    }
}