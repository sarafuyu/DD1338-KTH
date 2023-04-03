import java.util.List;
import java.util.ArrayList;

/**
 * A class for reversing List and array types.
 *
 * @author Sara Rydell
 * @version 2022-12-10
 */

public class Reverse {
    /**
     * Return a reversed copy of the argument array.
     * The passed array is NOT mutated.
     *
     * @param array An array.
     * @return A reversed copy of array.
     */
    public int[] reversed(int[] array) {
        // gets the size of the array
        int size = array.length;
        // creates an empty array
        int[] reversed = new int[size];
        // counter for number of basic operations
        int n = 0;
        // creates the reversed list by adding the list elements backwards to reversed
        int j = 0;
        for (int i=size-1; i>=0; i--) {
            reversed[i] = array[j];
            j++;
            n++; // increments the counter since the for-loop is our basic operation
        }
        System.out.println(n); // shows the operation count
        return reversed;
        // Remove this exception and implement your algorithm
        // new UnsupportedOperationException("Method not implemented!");
    }

    /**
     * Return a reversed copy of the argument List.
     * The passed List is NOT mutated.
     *
     * @param list A List.
     * @return A reversed copy of list.
     */
    public List<Integer> reversed(List<Integer> list) {
        // creates an empty list
        List<Integer> reversed = new ArrayList<>();
        // counter for number of basic operations
        int n = 0;
        // creates the reversed list by adding the list elements backwards to reversed
        for (int i=list.size()-1; i>=0; i--) {
            reversed.add(list.get(i));
            n++; // increments the counter since the for-loop is our basic operation
        }
        System.out.println(n); // shows the operation count
        return reversed;
        // Remove this exception and implement your algorithm    
        // throw new UnsupportedOperationException("Method not implemented!");
    }
}
