/**
 * InsertionSort implements the interface IntSorter.
 * 
 * @author Sara Rydell
 * @version 2023-02-28
 */
public class InsertionSort implements IntSorter {
    /**
     * Insertion sort implementation.
     * 
     * @param array An array of ints.
     */
    public void sort(int[] array) {
        for (int i=1; i<array.length; i++) {
            int j = i;
            while (j>0 && array[j-1]>array[j]) {
                int temp = array[j];
                array[j] = array[j-1];
                array[j-1] = temp;
                j--;
            }
        }
    }

    public String toString() {
        return "Insertion Sort";
    }
}
