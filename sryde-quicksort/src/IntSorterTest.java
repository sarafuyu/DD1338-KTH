 import org.junit.Test;
 import org.junit.Before;
 import static org.junit.Assert.*;

 import static org.hamcrest.MatcherAssert.assertThat;
 import static org.hamcrest.CoreMatchers.*;

 import java.util.Arrays;
 import java.util.Random;
 /**
  * Abstract test class for Quicksort implementations.
  *
  * Implementing test classes must override the getIntSorter method.
  *
  * @author Sara Rydell
  * @version 2023-03-01
  */
 public abstract class IntSorterTest {

    /* Length of the even array in these tests */
    private final int EVEN_ARRAY_LENGTH = 10000;
    /* Length of the odd array in these tests */
    private final int ODD_ARRAY_LENGTH = 10001;
    /* Maximum value of the array elements */
    private final int MAX_VALUE = 5000;

    /* Instance of QuickSort */
    IntSorter qs;

     /**
      * Returns an implementation of the IntSorter interface. Extending classes
      * must override this method.
      *
      * @return An implementation of IntSorter.
      */
     protected abstract IntSorter getIntSorter();

     @Before
     public void setUp() {
        qs = getIntSorter();
     }
    
     // Tests on small arrays (edge cases)

    @Test
    public void sortEmptyArrayHasNoEffect() {
        // Arrange
        int[] array = new int[0];
        // Act
        getIntSorter().sort(array);
        // Assert
        assertArrayEquals(new int[0], array);
    }

    @Test
    public void sortArrayOfOneHasNoEffect() {
        // Arrange
        int[] array = new int[] {1};
        // Act
        getIntSorter().sort(array);
        // Assert
        assertArrayEquals(new int[] {1}, array);
    }

    @Test
    public void sortSortedEvenArrayHasNoEffect() {
        // Arrange
        int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // Act
        getIntSorter().sort(array);
        // Assert
        assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, array);
    }

    @Test
    public void sortSortedOddArrayHasNoEffect() {
        // Arrange
        int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // Act
        getIntSorter().sort(array);
        // Assert
        assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, array);
    }

    @Test
    public void sortReversedEvenArray() {
        // Arrange
        int[] array = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        // Act
        getIntSorter().sort(array);
        // Assert
        assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, array);
    }

    @Test
    public void sortReversedOddArray() {
        // Arrange
        int[] array = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1};
        // Act
        getIntSorter().sort(array);
        // Assert
        assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, array);
    }

    @Test
    public void sortEvenArrayOfAllEqualElementsHasNoEffect() {
        // Arrange
        int[] array = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        // Act
        getIntSorter().sort(array);
        // Assert
        assertArrayEquals(new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, array);
    }

    @Test
    public void sortOddArrayOfAllEqualElementsHasNoEffect() {
        // Arrange
        int[] array = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1};
        // Act
        getIntSorter().sort(array);
        // Assert
        assertArrayEquals(new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1}, array);
    }

    @Test
    public void sortRecurringElementsEvenArray() {
        // Arrange
        int[] actual = new int[] {1, 8, 4, 9, 4, 1, 2, 8, 5, 9};
        int[] expected = actual.clone();
        // Act
        getIntSorter().sort(actual);
        Arrays.sort(expected);
        // Assert
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void sortRecurringElementsOddArray() {
        // Arrange
        int[] actual = new int[] {1, 8, 4, 9, 1, 4, 2, 8, 1, 5, 9};
        int[] expected = actual.clone();
        // Act
        getIntSorter().sort(actual);
        Arrays.sort(expected);
        // Assert
        assertArrayEquals(expected, actual);
    }
   
    @Test
    public void sortLargeRandomEvenArray() {
        // Arrange
        Data data = new Data(EVEN_ARRAY_LENGTH, MAX_VALUE, Data.Order.RANDOM);
        int[] actual = data.get();
        int[] expected = actual.clone();
        // Act
        getIntSorter().sort(actual);
        Arrays.sort(expected);
        for (int i=0; i<EVEN_ARRAY_LENGTH; i++) {
            System.out.println(expected[i]);
        }
        // Assert
        assertArrayEquals(actual, expected);
    }

    @Test
    public void sortLargeRandomOddArray() {
        // Arrange
        Data data = new Data(ODD_ARRAY_LENGTH, MAX_VALUE, Data.Order.RANDOM);
        int[] actual = data.get();
        int[] expected = actual.clone();
        // Act
        getIntSorter().sort(actual);
        Arrays.sort(expected);
        // Assert
        assertArrayEquals(actual, expected);
    }
    
    @Test
    public void sortLargeEvenAscendingArray() {
        // Arrange
        Data data = new Data(EVEN_ARRAY_LENGTH, MAX_VALUE, Data.Order.ASCENDING);
        int[] actual = data.get();
        int[] expected = actual.clone();
        // Act
        getIntSorter().sort(actual);
        // Assert
        assertArrayEquals(expected, actual);
    }

    @Test
    public void sortLargeOddAscendingArray() {
        // Arrange
        Data data = new Data(ODD_ARRAY_LENGTH, MAX_VALUE, Data.Order.ASCENDING);
        int[] actual = data.get();
        int[] expected = actual.clone();
        // Act
        getIntSorter().sort(actual);
        // Assert
        assertArrayEquals(expected, actual);
    }

    @Test
    public void sortLargeEvenDescendingArray() {
        // Arrange
        Data data = new Data(EVEN_ARRAY_LENGTH, MAX_VALUE, Data.Order.DESCENDING);
        int[] actual = data.get();
        int[] expected = actual.clone();
        // Act
        getIntSorter().sort(actual);
        Arrays.sort(expected);
        // Assert
        assertArrayEquals(expected, actual);
    }

    @Test
    public void sortLargeOddDescendingArray() {
        // Arrange
        Data data = new Data(ODD_ARRAY_LENGTH, MAX_VALUE, Data.Order.DESCENDING);
        int[] actual = data.get();
        int[] expected = actual.clone();
        // Act
        getIntSorter().sort(actual);
        Arrays.sort(expected);
        // Assert
        assertArrayEquals(expected, actual);
    }
 }