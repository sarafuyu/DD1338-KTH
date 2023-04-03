/**
 * The class QuicksortFixedPivot that implements the IntSorter interface using helper methods from QuickSortHelper.
 * 
 * @author Sara Rydell
 * @version 2023-03-02
 */
public class QuicksortFixedPivot extends QuickSortHelper implements IntSorter {
    /**
     * Sorts the array in-place into ascending numerical order.
     *
     * @param v An array of ints.
     */
    public void sort(int[] v) {
        QuicksortFixedPivot(v, 0, v.length - 1);
    }

    /**
     * Implementation of Quicksort that uses a fixed pivot.
     * 
     * @param array An array of ints.
     */
    public static void QuicksortFixedPivot(int[] array, int low, int high) {
        if (low < high) {
            int[] pivotIndices = partition(array, low, high, true);
            QuicksortFixedPivot(array, low, pivotIndices[0] - 1);
            QuicksortFixedPivot(array, pivotIndices[1] + 1, high);
        }
    }

    public String toString() {
        return "QuicksortFixedPivot";
    }

    public static void main(String[] args) {
        // Arrange
        int size = 2000;
        int range = 1000;
        Data data = new Data(size, range, Data.Order.RANDOM);
        int[] actual = data.get();
        // Act
        QuicksortFixedPivot(actual,0,size-1);
        // Assess
        StringBuilder str = new StringBuilder();
        for (int i=0; i<size; i++) {
            str.append(actual[i]);
            str.append(" ");
        }
        System.out.println(str.toString());
    }
}