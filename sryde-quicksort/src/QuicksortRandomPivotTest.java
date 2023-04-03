/**
 * QuicksortRandomPivotTest is a test class that extends the abstract test class IntSorterTest.
 * 
 * @author Sara Rydell
 * @version 2023-03-01 
 */
public class QuicksortRandomPivotTest extends IntSorterTest {
    /**
     * Overrides the corresponding method in the parent class and returns an instance of the QuicksortRandomPivot class.
     */
    @Override
    protected IntSorter getIntSorter() {
        return new QuicksortRandomPivot();
    } 
}
