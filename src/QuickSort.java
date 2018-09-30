/**
 * This class sorts the array via a quick sort, unlike selection sort, it takes 2 functions
 */
public class QuickSort {

    /**
     * This function gets the array length and calls the actual sorting function
     * @param theArray the array to sort
     * @return the sorted array
     */
    public static int [] call_qSort(int[] theArray){
        // Get the length
        int len = theArray.length - 1;

        // Return the array after calling the function
        qSort(theArray, 0, len);
        return theArray;
    }

    /**
     * This is the actual sorting function
     * @param theArray the array unsorted
     * @param min the bottom index of the array
     * @param max the length of the array minus 1
     * @return the sorted array
     */
    public static void qSort(int[] theArray, int min, int max){
        if(theArray.length == 0 || theArray == null || min >= max){
            return;
        }

        // Find the pivot point and the pivot spot in the array
        int pivot = min + (max - min) / 2;
        int spot = theArray[pivot];

        // Save the min and max
        int i = min;
        int j = max;

        // Now loop
        while(i <= j) {
            while (theArray[i] < spot) {
                i += 1;
            }
            while (theArray[j] > spot) {
                j -= 1;
            }

            // Make a swap if necessary
            if (i <= j) {
                int k = theArray[i];
                theArray[i] = theArray[j];
                theArray[j] = k;
                j -= 1;
                i += 1;
            }
        }

        // Lastly make the recursive calls
        if(min < j){
            qSort(theArray, min, j);
        }
        if(max > i){
            qSort(theArray, i, max);
        }
    }
}
