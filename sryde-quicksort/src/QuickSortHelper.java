import java.util.Random;

/**
 * QuickSortHelper contaning helper methods used in the classes implementing IntSorter.
 * 
 * @author Sara Rydell
 * @version 2023-03-02
 */
public class QuickSortHelper {
    /**
     * Helper method used by the Quicksort algorithms to swap two elements in an integer array.
     * 
     * @param array An array of ints.
     * @param i First element index.
     * @param j Second element index.
     */
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Helper method to the partition methods that chooses the next pivot element of a subarray.
     * 
     * @param array The subarray to choose pivot element from.
     * @param low The lowest subarray index.
     * @param high The highets subarray index.
     * @return
     */
    protected static int pivot(int[] array, int low, int high, boolean fixedPivot) {
        // Chooses mid fixed or randomly
        int mid = (high + low) / 2;
        if (!fixedPivot) mid = low + new Random().nextInt(high-low); 
        // Chooses the middle element of mid, low and high
        if (array[mid] < array[low]) swap(array, mid, low);
        if (array[high] < array[low]) swap(array, high, low);
        if (array[high] < array[mid]) swap(array, high, mid);
        return mid;
    }

    /**
     * Helper method to QuicksortFixedPivot that partitions an array into three groups:
     * elements smaller than the pivot, elements equal to the pivot, and elements greater than the pivot.
     * 
     * @param array The array to partition.
     * @param low The lowest subarray index.
     * @param high The highest subarray index.
     * @param fixedPivot A boolean flag indicating whether to use a fixed pivot or not.
     * @return An integer array containing two elements: the start and end indices of the group of elements equal to the pivot.
     */
    protected static int[] partition(int[] array, int low, int high, boolean fixedPivot) {
        // Choosing the pivot element
        int pivotIndex = pivot(array,low,high,fixedPivot);
        int pivot = array[pivotIndex];
        // Initializing indices to partition the array into three groups
        int i = low;
        int j = high;
        int eqStart = low;
        int eqEnd = high;
        // Iterating through the array and partitioning it into the three groups
        while (i <= j) {
            if (array[i] < pivot) {
                swap(array, i, eqStart);
                i++;
                eqStart++;
            } else if (array[i] > pivot) {
                swap(array, i, j);
                j--;
            } else {
                i++;
            }
        }
        // Updating the end index of the group of elements equal to the pivot
        eqEnd = i - 1;
        // Returning an integer array containing the start and end indices of the group of elements equal to the pivot
        return new int[] {eqStart, eqEnd};        
    }

    /**
     * Helpermethod to Quicksort that implements insertionsort on sub arrays.
     * 
     * @param array The array to partition.
     * @param low The lowest subarray index.
     * @param high The highest subarray index.
     */
    protected static void insertionSort(int[] array, int low, int high) {
        for (int i=low; i<=high; i++) {
            int j = i;
            while (j>0 && array[j-1]>array[j]) {
                int temp = array[j];
                array[j] = array[j-1];
                array[j-1] = temp;
                j--;
            }
        }
    }

    /**
     * Helper method to Quicksort that implements the Hoare partition scheme.
     * 
     * Partitions an array by selecting a pivot value and rearranging the elements such that all elements 
     * smaller than the pivot are on the left and all elements greater than the pivot are on the right.
     * 
     * @param array The array to partition.
     * @param low The lowest subarray index.
     * @param high The highest subarray index.
     * @param fixedPivot A boolean flag indicating whether to use a fixed pivot or not.
     * @return The index of the pivot element after partitioning.
     */
    protected static int hoare_partition(int[] array, int low, int high, boolean fixedPivot) {
        // Choosing the pivot element index
        int pivotIndex = pivot(array,low,high,fixedPivot);
        // Swaping of elements
        int i = low - 1;
        int j = high + 1;
        while (true) { 
            do {
                i++;
            } while (array[i] < array[pivotIndex]);
            do {
                j--;
            } while (array[j] > array[pivotIndex]);
            if (i >= j) {
                return j;
            }
            swap(array,i,j);
        }
    }

    /**
     * Helper method to QuicksortFixedPivot.
     * 
     * This method implements the Lomuto partition scheme, which is used by the quicksort 
     * algorithm to partition an array into two parts around a chosen pivot element.
     * 
     * @param array The array to partition.
     * @param low The lowest subarray index.
     * @param high The highest subarray index.
     * @param fixedPivot A boolean flag indicating whether to use a fixed pivot or not.
     * @return The index of the pivot element after partitioning.
     */
    protected static int lomuto_partition(int[] array, int low, int high, boolean fixedPivot) {
        // Choosing the pivot element
        int pivot = pivot(array,low,high,fixedPivot);
        int i = low-1;
        for (int j=low; j<high; j++) {
            if (array[j]<=pivot) {
                i++;
                swap(array,i,j);
            }
        }
        swap(array,i+1,high);
        return i+1;
    }
}