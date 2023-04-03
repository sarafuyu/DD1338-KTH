import java.util.Arrays;

/**
 * Class to make empirical evaluations of the Quicksort implementations.
 * 
 * @author Sara Rydell
 * @version 2023-03-06
 */
public final class TimingQuicksort {
    /**
     * Enviroment to do time testing of the different quicksort algorithms
     */
    public static void main(String[] args) {

        /* Variables for problem scaling */
        final int SMALLEST_ARRAY_SIZE = 100;
        final int SMALL_ARRAY_SIZE = 1000;
        final int MEDIUM_ARRAY_SIZE = 10000;
        final int LARGE_ARRAY_SIZE = 100000;
        final int LARGEST_ARRAY_SIZE = 1000000;

        /* Instances of the different quicksort algorithms */
        InsertionSort insertion = new InsertionSort();
        QuicksortFixedPivot QsV1 = new QuicksortFixedPivot();
        QuicksortFixedPivotInsertion QsV2 = new QuicksortFixedPivotInsertion();
        QuicksortRandomPivot QsV3 = new QuicksortRandomPivot();
        QuicksortRandomPivotInsertion QsV4 = new QuicksortRandomPivotInsertion();

        /* Part where to tailor the tests to each algorithm and problem size */
        int size = 1000;
        QuicksortRandomPivotInsertion algorithm = QsV4;
        Data data = new Data(size, size/2, Data.Order.ASCENDING); // RANDOM, ASCENDING, DESCENDING

        /* Test set up */
        final int reps = 10;
        int jvm = 5; // Discard results that are anomalous or affected by JVM warmup
        final Stopwatch clock = new Stopwatch();
        long timeSum = 0;
        int count = 0;
        long avgerageTime = 0;

        for (int i=0; i<reps+jvm; i++) {
            /* Clones the generated data */
            int[] array = data.get();

            /* Creates an arrey with equal elements for the equal data test */
            //int[] array = new int[size];
            //Arrays.fill(array, 1);

            clock.reset().start(); // Starts the timer
            {
                /* Sorts the array with the choosen algorithm */
                //algorithm.sort(array); 

                /* Uses optimisatized sorting algorithm from the Java standard library */
                Arrays.sort(array);
            }
            long time = clock.stop().nanoseconds(); // Stops the timer

            /* Adds the run times to calculate the average after the five first complations (excluding results affected by the JVM warmup) */
            if (i >= jvm) { 
                timeSum += time;
                count++;

                /* Prints the run times used for calculating the average */
                System.out.printf("%s size %d: %d ns%n", algorithm.toString(), size, time); 
            }
        }
        /* Calculates the average run time */
        avgerageTime = timeSum/count; 
        /* Prints the final results */
        System.out.printf("Average %s size %d: %d ns%n", algorithm.toString(), size, avgerageTime);
    }
}
