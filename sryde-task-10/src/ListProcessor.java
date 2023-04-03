// Task 10 by Sara Rydell

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ListProcessor {
    // instance methods

    // task 10.1: Code by Richard Glassey modified by Sara Rydell
    public int[] arraySequence(int from, int to) {
        // gets the size of the array
        int size = to - from;
        // checks condition
        if(size<0) {
            throw new IllegalArgumentException("The first number should be smaller than the second number!");
        }
        // creates empty array
        int[] sequence = new int[size];
        // populates array from X to Y
        for(int i=0; i<size; i++) {
            sequence[i] = from;
            from++;
        }
        return sequence;
    }
    public List<Integer> listSequence(int from, int to) {
        // gets the size of the list
        int size = to - from;
        // checks condition
        if(size<0) {
            throw new IllegalArgumentException("The first number should be smaller than the second number!");
        }
        // creates empty list
        List<Integer> sequence = new ArrayList<Integer>(); // List<Integer> sequence = new LinkedList<Integer>();
        // populates list from X to Y
        for(int i=0; i<size; i++) {
            sequence.add(from);
            from++;
        }
        return sequence;
    }

    // task 10.2: Code by Sara Rydell
    public int[] shuffled(int[] numbers) {
        // gets the size of the array
        int size = numbers.length;
        // creates empty array
        int[] shuffledList = new int[size];
        // creates an array dublicate for shuffled list
        for(int i=0; i<size; i++) {
            shuffledList[i] = numbers[i];
        }
        // initializes methods for random 
        Random rand = new Random();
        // creates randomized array by swithching element's indexes
        for(int i=0; i<size; i++) {
            // creates a random number
            int j = rand.nextInt(size-1);
            // saves the values that will switch places
            int numberi = shuffledList[i];
            int numberj = shuffledList[j];
            // switches places
            shuffledList[i] = numberj;
            shuffledList[j] = numberi;
        }
        return shuffledList;
    }
    public List<Integer> shuffled(List<Integer> numbers) {
        // gets the size of the list
        int size = numbers.size();
        // creates empty list
        List<Integer> shuffledList = new ArrayList<Integer>();
        // creates a list dublicate for shuffled list
        for(int i=0; i<size; i++) {
            int j = numbers.get(i);
            shuffledList.add(j);
        }
        // initializes methods for random 
        Random rand = new Random();
        // creates randomized list by swithching element's indexes
        for(int i=0; i<size; i++) {
            // creates a random number
            int j = rand.nextInt(size-1);
            // saves values that will switch places
            int numberi = shuffledList.get(i);
            int numberj = shuffledList.get(j);
            // switches places
            shuffledList.set(i, numberj);
            shuffledList.set(j, numberi); 
            // prints to test
            System.err.println(shuffledList);
        }
        return shuffledList;
    }

    // task 10.3
    public int sumIterative(int[] numbers) {
        int sum = 0;
        int size = numbers.length;
        // an empty array gives the sum 0
        if(size==0) {
            return sum;
        }
        // adding each element iteratively
        for(int i=0; i<size; i++) {
            sum = sum + numbers[i];
        }
        return sum;
    }
    public int sumIterative(List<Integer> numbers) {
        int sum = 0;
        int size = numbers.size();
        // an empty list gives the sum 0
        if(size==0) {
            return sum;
        }
        // adding each element iteratively
        for(int i=0; i<size; i++) {
            sum = sum + numbers.get(i);
        }
        return sum;
    }

    // task 10.4
    public int sumRecursive(int[] numbers) {
        int size = numbers.length;
        // base cases size = 0 or size = 1
        if(size==0){
            return 0;
        } 
        else if(size==1) {
            return numbers[0];
        } 
        // creating a new array without the last element
        else {
            int[] smallerArray = new int[size-1];
            for(int i=0; i<size-1; i++) {
                int number = numbers[i];
                smallerArray[i] = number; 
            }
            // recursion
            return numbers[size-1] + sumRecursive(smallerArray);
        }
    }
    public int sumRecursive(List<Integer> numbers) {
        int size = numbers.size();
        // base cases size = 0 or size = 1
        if(size==0){
            return 0;
        } else if(size==1) {
            return numbers.get(0);
        } 
        // creating a new list without the last element
        else {
            List<Integer> smallerList = new ArrayList<Integer>();
            for(int i=0; i<size-1; i++) {
                int number = numbers.get(i);
                smallerList.add(number); 
            }
            // recursion
            return numbers.get(size-1) + sumRecursive(smallerList);
        }
    }

    // task 10.5
    public static void main(String[] args) {
        // task 10.1
        System.out.println("Task 10.1: populating arrays:");
        ListProcessor lp = new ListProcessor();
        int[] array = lp.arraySequence(2, 6);
        for(int i : array) {
            System.err.println(i);
        }
        List<Integer> list = lp.listSequence(2, 6);
        System.err.println(list);

        // task 10.2
        System.out.println("Task 10.2: shuffling lists:");
        int[] arrayShuffled = lp.shuffled(array);
        List<Integer> listShuffled = lp.shuffled(list);

        // task 10.3
        System.out.println("Task 10.3: summing lists iteratively:");
        int sumitarray = lp.sumIterative(array);
        System.out.println(sumitarray);
        int sumitlist = lp.sumIterative(list);
        System.out.println(sumitlist);

        // task 10.4
        System.out.println("Task 10.4: summing lists recursively:");
        int sumrecarray = lp.sumRecursive(array);
        System.out.println(sumrecarray);
        int sumreclist = lp.sumRecursive(list);
        System.out.println(sumreclist);
    }
}