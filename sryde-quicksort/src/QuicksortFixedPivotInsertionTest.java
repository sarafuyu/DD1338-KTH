/**
 * QuicksortFixedPivotInsertionTest is a test class that extends the abstract test class IntSorterTest.
 * 
 * @author Sara Rydell
 * @version 2023-03-01 
 */
public class QuicksortFixedPivotInsertionTest extends IntSorterTest{
    /**
     * Overrides the corresponding method in the parent class and returns an instance of the QuicksortFixedPivotInsertion class.
     */
    @Override
    protected IntSorter getIntSorter() {
        return new QuicksortFixedPivotInsertion();
    }   
}