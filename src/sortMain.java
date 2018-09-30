/**
 * Ryan Moore - 9/29/18 - This program is just a coding exercise for me
 *
 * This class will be the main class, it will generate an array to be sorted
 * and call the sorting functions located in other classes.
 *
 * This will be written as simply and readable as possible, so I may reference it
 * in the future.
 */

import java.util.Arrays;


/**
 * The SortMain class will parse command line arguments, like the size and contents
 * of the array that it will randomly generate.
 */
public class sortMain {
    // Declare variables, array size, min and max content value
    static int size;
    static int min;
    static int max;
    static int[] toSort;

    /**
     * The main method for this program, parses command line, and
     * generates the array within the bounds of the passed in args
     * @param args the args passed in from the command line
     */
    public static void main(String... args){
        // Make sure the correct number of args were passed it from the command line
        if(args.length != 3){
            System.err.print("Incorrect number of command line arguments");
            System.exit(1);
        }

        // Parse the args
        size = Integer.parseInt(args[0]);
        min = Integer.parseInt(args[1]);
        max = Integer.parseInt(args[2]);

        // Now generate the array
        toSort = generateArrayContents(size, min, max);

        // Display the array
        System.out.println("The unsorted array: ");
        displayArray(toSort);

        // Make copies of the array to be sorted
        System.out.println("The unsorted arrays:");
        int[] selectionSortArray = toSort.clone();
        int[] quickSortArray = toSort.clone();
        int[] mergeSortArray = toSort.clone();

        // Now call the sorting algorithms and create some simple timers
        SelectionSort sort1 = new SelectionSort();
        long selectionStart = System.nanoTime();
        int[] sorted1 = sort1.sSort(selectionSortArray);
        long selectionEnd = System.nanoTime();

        QuickSort sort2 = new QuickSort();
        long quickStart = System.nanoTime();
        int[] sorted2 = sort2.call_qSort(quickSortArray);
        long quickEnd = System.nanoTime();

        MergeSort sort3 = new MergeSort();
        long mergeStart = System.nanoTime();
        int[] sorted3 = sort3.mSort_Caller(mergeSortArray);
        long mergeEnd = System.nanoTime();

        // Now display the sorted arrays
        System.out.println("The now sorted arrays:");
        System.out.println("The selection sorted array");
        displayArray(sorted1);
        System.out.println("The quick sorted array");
        displayArray(sorted2);
        System.out.println("The merge sorted array");
        displayArray(sorted3);

        // Now display how long they each took
        long selectionTime = ((selectionEnd - selectionStart) / 1000000);
        long quickTime = ((quickEnd - quickStart) / 1000000);
        long mergeTime = ((mergeEnd - mergeStart) / 1000000);

        System.out.println("Selection sort ran in: " + selectionTime + " milliseconds.");
        System.out.println("Quick sort ran in: " + quickTime + " milliseconds.");
        System.out.println("Merge sort ran in: " + mergeTime + " milliseconds.");
    }

    /**
     * The function that generates the array
     * @param arraySize user decided size of the array
     * @param contentMinValue user decided min value of an array item
     * @param contentMaxValue user decided max value of an array item
     * @return the array itself
     */
    public static int[]  generateArrayContents(int arraySize, int contentMinValue, int contentMaxValue){
        // Generate empty array of correct size
        int[] theArray = new int[arraySize];

        // Now fill the array
        for(int i = 0; i < theArray.length; i++){
            theArray[i] = (int)(Math.random() * ((contentMaxValue - contentMinValue) + 1)) + contentMinValue;
        }

        return theArray;
    }

    /**
     * Just a simple printing function
     * @param theArray the array to print
     */
    public static void displayArray(int[] theArray){
        System.out.println(Arrays.toString(theArray));
    }

}
