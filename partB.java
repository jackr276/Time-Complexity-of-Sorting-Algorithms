/**
 * @author Jack Robbins
 * CMP-233
 * Professor Sawh
 * Assignment 4 Part B
 *
 * This part of the assignment programatically generates arrays of integers of varying sizes, uses 4 sorting algorithms
 * to test them, and records the individual times taken and the average time for each of the 4 sorting algorithms
 * acros all of the arrays
 */
import java.util.Random;


public class partB {


    /**
     * The main method simply calls testSorting ten times and records the time for each sorting algorithm. Then uses
     * the helper function findAvgTime to find and print the average time to the console
     * @param args not used
     */
    public static void main(String[] args){
        long[] times_bbsort = new long[10];
        long[] times_isort = new long[10];
        long[] times_ssort = new long[10];
        long[] times_msort = new long[10];

        //Test array of size 100
        long[] time100 = testSorting(100);
        times_bbsort[0] = time100[0];
        times_isort[0] = time100[1];
        times_ssort[0] = time100[2];
        times_msort[0] = time100[3];

        //Test array of size 1000
        long[] time1000 = testSorting(1000);
        times_bbsort[1] = time1000[0];
        times_isort[1] = time1000[1];
        times_ssort[1] = time1000[2];
        times_msort[1] = time1000[3];

        //Test array of size 10000
        long[] time10000 = testSorting(10000);
        times_bbsort[2] = time10000[0];
        times_isort[2] = time10000[1];
        times_ssort[2] = time10000[2];
        times_msort[2] = time10000[3];

        //Test array of size 30000
        long[] time30000 = testSorting(30000);
        times_bbsort[3] = time30000[0];
        times_isort[3] = time30000[1];
        times_ssort[3] = time30000[2];
        times_msort[3] = time30000[3];

        //Test array of size 50000
        long[] time50000 = testSorting(50000);
        times_bbsort[4] = time50000[0];
        times_isort[4] = time50000[1];
        times_ssort[4] = time50000[2];
        times_msort[4] = time50000[3];

        // Test array of size 90000
        long[] time90000 = testSorting(90000);
        times_bbsort[5] = time90000[0];
        times_isort[5] = time90000[1];
        times_ssort[5] = time90000[2];
        times_msort[5] = time90000[3];

        // Test array of size 100000
        long[] time100000 = testSorting(100000);
        times_bbsort[6] = time100000[0];
        times_isort[6] = time100000[1];
        times_ssort[6] = time100000[2];
        times_msort[6] = time100000[3];

        // Test array of size 300000
        long[] time300000 = testSorting(300000);
        times_bbsort[7] = time300000[0];
        times_isort[7] = time300000[1];
        times_ssort[7] = time300000[2];
        times_msort[7] = time300000[3];

        // Test array of size 500000
        long[] time500000 = testSorting(500000);
        times_bbsort[8] = time500000[0];
        times_isort[8] = time500000[1];
        times_ssort[8] = time500000[2];
        times_msort[8] = time500000[3];

        // Test array of size 800000
        long[] time800000 = testSorting(800000);
        times_bbsort[9] = time800000[0];
        times_isort[9] = time800000[1];
        times_ssort[9] = time800000[2];
        times_msort[9] = time800000[3];

        // Find the average time for Bubblesort
        System.out.println("Average time for BubbleSort(Milliseconds): " + findAvgTime(times_bbsort));
        System.out.println("Average time for InsertionSort(Milliseconds): " + findAvgTime(times_isort));
        System.out.println("Average time for SelectionSort(Milliseconds): " + findAvgTime(times_ssort));
        System.out.println("Average time for MergeSort(Milliseconds): " + findAvgTime(times_msort));



    }


    /**
     * A simple helper function that finds the average time given an array filled with long time values
     * @param timeArr the array to be averaged
     * @return the average time
     */
    private static double findAvgTime(long[] timeArr){
        double sum = 0;
        for (int i = 0; i<timeArr.length; i++){
            sum += timeArr[i];
        }
        return sum / timeArr.length;
    }


    /**
     * The testSorting method will call generateRandomArr of the specified size, then it will systematically
     * test all of the four sorting algorithms on the same array and calculate the time required for the
     * system to complete. These times are printed to the console in a formatted way.
     * @param listSize the desired size of the list
     * @return a long[] filled with the times for Bubblesort, InsertionSort, SelectionSort, and Mergesort,
     * in said order
     */
    private static long[] testSorting(int listSize){
        int[] testing = createRandArr(listSize);
        int[] sorted;
        long[] times =  new long[4];
        System.out.println("Testing array of size: " + listSize);
        System.out.println();

        // Test Bubblesort and record time
        System.out.print("Using Bubble sort(Milliseconds): ");
        long bubbleCounterStart = System.currentTimeMillis();
        sorted = bubbleSort(testing);
        long bubbleCounterStop = System.currentTimeMillis();
        times[0] = bubbleCounterStop-bubbleCounterStart;
        System.out.println(Long.toString(times[0]));

        // Test Insertionsort and record time
        System.out.print("Using Insertion sort(Milliseconds): ");
        long InsertionCounterStart = System.currentTimeMillis();
        sorted = insertionSort(testing);
        long InsertionCounterStop = System.currentTimeMillis();
        times[1] = InsertionCounterStop-InsertionCounterStart;
        System.out.println(Long.toString(times[1]));

        // Test Selectionsort and record time
        System.out.print("Using Selection sort(Milliseconds): ");
        long SelectionCounterStart = System.currentTimeMillis();
        sorted = selectionSort(testing);
        long SelectionCounterStop = System.currentTimeMillis();
        times[2] = SelectionCounterStop-SelectionCounterStart;
        System.out.println(Long.toString(times[2]));

        // Test Mergesort and record time
        System.out.print("Using Merge sort(Milliseconds): ");
        int[] unsortedMergeArr = testing.clone();
        long MergeCounterStart = System.currentTimeMillis();
        sorted = mergeSort(unsortedMergeArr, 0, testing.length-1);
        long MergeCounterStop = System.currentTimeMillis();
        times[3] = MergeCounterStop-MergeCounterStart;
        System.out.println(Long.toString(times[3]));
        System.out.println("_________________________________________________________________________________________");

        return times;
    }


    /**
     * Creates an array of a specified size filled with numbers ranging from -10000 to 10000. All numbers are
     * generated randomly to ensure that our sorting algorithms actually have something to do
     * @param arraySize the size for the array
     * @return an array of size arraySize full of random, out of order integers
     */
    private static int[] createRandArr(int arraySize){
        Random rand = new Random();
        int[] randArr = new int[arraySize];
        int i = 0;
        while (i < arraySize){
            randArr[i] = rand.nextInt(-10000, 10000);
            i++;
        }
        return randArr;
    }


    /**
     * An implementation of an improved bubbleSort algorithm for this project
     * @param unsortedArr the initial, unsorted array
     * @return a sorted array
     */
    private static int[] bubbleSort(int[] unsortedArr){
        int[] internalArr = unsortedArr.clone();
        boolean sorted = false;
        int temp;

        for (int i = 1; (i<internalArr.length) && !sorted; i++){
            sorted = true;
            for (int j = 0; j<internalArr.length-i; j++){
                if (internalArr[j] > internalArr[j+1]){
                    int temp2 = internalArr[j];
                    internalArr[j] = internalArr[j+1];
                    internalArr[j+1] = temp2;
                    sorted = false;
                }
            }
        }
        return internalArr;
    }


    /**
     * The insertion sort implementation for this project
     * @param unsortedArr the initial, unsorted array
     * @return the sorted array
     */
    private static int[] insertionSort(int[] unsortedArr){
        int[] internalArr = unsortedArr.clone();
        for (int unsorted = 1; unsorted < internalArr.length; unsorted++){
            int nextItem = internalArr[unsorted];
            int location = unsorted;
            while ((location > 0) && (internalArr[location-1] > nextItem)) {
                internalArr[location] = internalArr[location-1];
                location--;
            }
            internalArr[location] = nextItem;
        }
        return  internalArr;
    }


    /**
     * The selection sort implementation for this project
     * @param unsortedArr the initial, unsorted array
     * @return the sorted array
     */
    private static int[] selectionSort(int[] unsortedArr){
        int[] internalArr = unsortedArr.clone();
        for (int i = 0; i < internalArr.length-1; i++){

            int minIndex = i;
            for (int j = i+1; j < internalArr.length; j++){
                if (internalArr[j] < internalArr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = internalArr[minIndex];
            internalArr[minIndex] = internalArr[i];
            internalArr[i] = temp;
        }
        return internalArr;
    }


    /**
     * The merge sort implementation for this project
     * @param internalArr the internal array
     * @param first the starting index for the entire array
     * @param last the ending index for the entire array
     * @return a sorted array
     */
    private static int[] mergeSort(int[] internalArr, int first, int last){

        if (first < last){
            int mid = (first + last)/2;

            mergeSort(internalArr, first, mid);
            mergeSort(internalArr, mid+1, last);

            merge(internalArr, first, mid, last);
        }
        return internalArr;
    }


    /**
     * Merge is a helper function for merge sort. It merges the arrays that were split up by the recursive process
     * of merge sort
     * @param internalArr the array to be sorted
     * @param first the starting index
     * @param mid the middle index
     * @param last the ending index
     */
    private static void merge(int[] internalArr, int first, int mid, int last) {
      int size1 = mid - first + 1;
      int size2 = last - mid;

      //Create temp arrays
      int[] leftArr = new int[size1];
      int[] rightArr = new int[size2];

      for (int i = 0; i < size1; i++){
          leftArr[i] = internalArr[first+i];
      }
      for (int j = 0; j < size2; j++){
          rightArr[j] = internalArr[mid + 1 + j];
      }

      int i = 0, j = 0;

      int k = first;
      while((i < size1) && (j < size2)){
          if (leftArr[i] <= rightArr[j]){
              internalArr[k] = leftArr[i];
              i++;
          } else {
              internalArr[k] = rightArr[j];
              j++;
          }
          k++;
      }

      while (i < size1){
          internalArr[k] = leftArr[i];
          i++;
          k++;
      }

      while (j < size2){
          internalArr[k] = rightArr[j];
          j++;
          k++;
      }
    }
}



