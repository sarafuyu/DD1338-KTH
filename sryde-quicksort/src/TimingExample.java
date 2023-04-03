import java.util.ArrayList;

/**
 * An example demonstrating the effects of just-in-time compilation
 * on time measurements.
 *
 * @author Sara Rydell
 * @version 2023-03-06
 */
public final class TimingExample {
    /**
     * If you're using a JVM with just-in-time compilation,
     * chanses are that the first reported time is much
     * larger than the rest: during most of the first
     * invocation of the sum() method, the code has yet
     * to be compiled and optimized.
     */
    public static void main(String[] args) {
        final int reps = 5;
        final int n = 1000000;
        final Stopwatch clock = new Stopwatch();

        /* New variables to calculate average */
        int jvm = 5; // Discard results that are anomalous or affected by JVM warmup
        long timeSum = 0;
        int count = 0;

        /* New variables to find max and min run times */
        ArrayList<Long> timeList = new ArrayList<Long>();
        long avgerageTime = 0;
        long min, max;

        for (int i = 0; i < reps + jvm; i++) {

            clock.reset().start();
            {
                long dummy = sum(n);
            }
            long time = clock.stop().nanoseconds();

            if (i >= jvm) {
                timeSum += time;
                count++;
                timeList.add(time);
                //System.out.printf("Time to run sum(%d): %d ns%n", n, time);
            }
        }
        /* Calculates the average run time */
        avgerageTime = timeSum/count; 
        min = min(timeList); // gets the min element
        max = max(timeList); // gets the max element
        
        /* Prints the final results */
        System.out.printf("Run times for sum(%d) -> Minimum: %d ns, Average: %d ns, Maximum %d ns %n", n, min, avgerageTime, max);
    }

    /**
     * Returns the sum 1 + 2 + ... + n.
     */
    private static long sum(int n) {
       long sum = 0;
       for (int i = 1; i <= n; i++) {
           sum += i;
       }
       return sum;
    }

    /**
     * Returns the minimum value of the given arraylist.
     * 
     * @param timeList
     * @return
     */
    private static long min(ArrayList<Long> timeList) {
        long minElement = timeList.get(0); // Starts with the first element
        for (int i = 1; i < timeList.size(); i++) {
            if (timeList.get(i) < minElement) {
                minElement = timeList.get(i);
            }
        }
        return minElement;
    }

    /**
     * Returns the maximum value of the given arraylist.
     * 
     * @param timeList
     * @return
     */
    private static long max(ArrayList<Long> timeList) {
        long maxElement = timeList.get(0); // Starts with the first element
        for (int i = 1; i < timeList.size(); i++) {
            if (timeList.get(i) > maxElement) {
                maxElement = timeList.get(i);
            }
        }
        return maxElement;
    }

}
