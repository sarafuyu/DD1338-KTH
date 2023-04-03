/**
 * The class QuicksortFixedPivotInsertion that implements the IntSorter interface using helper methods from QuickSortHelper.
 * 
 * @author Sara Rydell
 * @version 2023-03-02
 */
public class QuicksortFixedPivotInsertion extends QuickSortHelper implements IntSorter {
    /**
     * Sorts the array in-place into ascending numerical order.
     *
     * @param v An array of ints.
     */
    public void sort(int[] v) {
        QuicksortFixedPivotInsertion(v, 0, v.length - 1);
    }

    /**
     * Implementation of Quicksort that uses a fixed pivot with a cut-off to insertion sort at smaller sub array lengths.
     * 
     * @param array An array of ints.
     */
    public static void QuicksortFixedPivotInsertion(int[] array, int low, int high) {
        if (low < high) {
            if (high - low < 1000) {
                insertionSort(array, low, high);
            }
            else {
                int[] pivotIndices = partition(array, low, high, true);
                QuicksortFixedPivotInsertion(array, low, pivotIndices[0] - 1);
                QuicksortFixedPivotInsertion(array, pivotIndices[1] + 1, high);
            }
        }        
    }

    public String toString() {
        return "QuicksortFixedPivotInsertion";
    }
    
    public static void main(String[] args) {
        // Arrange
        int size = 2000;
        int range = 1000;
        Data data = new Data(size, range, Data.Order.RANDOM);
        int[] actual = data.get();
        // Act
        QuicksortFixedPivotInsertion(actual,0,size-1);
        // Assess
        StringBuilder str = new StringBuilder();
        for (int i=0; i<size; i++) {
            str.append(actual[i]);
            str.append(" ");
        }
        System.out.println(str.toString());
    }
}