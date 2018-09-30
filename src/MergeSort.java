/**
 * This class sorts the array via a merge sort
 */
public class MergeSort {

    // First two functions to split the array into a right and left half
    /**
     * Get the arrays 'left' half
     * @param theArray full unsorted array
     * @return the 'left' side of the array
     */
    public static int [] left(int[] theArray){
        // Get the size of the new array and create it
        int lSize = theArray.length / 2;
        int[] leftSide = new int[lSize];

        // Now fill the array
        for(int i = 0; i < lSize; i += 1){
            leftSide[i] = theArray[i];
        }

        // Return the new array
        return leftSide;
    }

    /**
     * Get the arrays 'right' side
     * @param theArray the full unsorted array
     * @return the 'right' side of the array
     */
    public static int [] right(int[] theArray){
        // Get the size of the new array and create it
        int halfSize = theArray.length / 2;
        int rSize = theArray.length - halfSize;
        int[] rightSide = new int[rSize];

        // Now fill the array
        for(int i = 0; i < rSize; i += 1){
            rightSide[i] = theArray[i + halfSize];
        }

        // Return the new array
        return rightSide;
    }

    /**
     * This is the function that actually does the sorting
     * @param theArray the full array
     * @param leftSide left part of the array
     * @param rightSide right part of the array
     */
    public static void mSort(int[] theArray, int[] leftSide, int[] rightSide){
        // Index for 'sides' of the array
        int left =0;
        int right = 0;

        // Now loop through the whole array
        for(int i = 0; i < theArray.length; i += 1){
            if(right >= rightSide.length || (left < leftSide.length && leftSide[left] <= rightSide[right])){
                theArray[i] = leftSide[left];
                left += 1;
            }
            else{
                theArray[i] = rightSide[right];
                right += 1;
            }
        }
    }

    /**
     * A recursive function, to repetitvely halve the array, and then call the actual sort
     * @param theArray the array to be sorted
     */
    public static void call_mSort(int[] theArray){
        // First we have to make sure the array is big enough
        if(theArray.length > 1){
            // Then split the array into two new arrays
            int[] lSide = left(theArray);
            int[] rSide = right(theArray);

            // Now comes the recursive call, we keep on dividing the array into smaller halves
            call_mSort(lSide);
            call_mSort(rSide);

            // Lastly call the actual mSort function
            mSort(theArray, lSide, rSide);
        }
    }

    /**
     * This ones pretty much just a wrapper so I can return the array
     * @param theArray unsorted array
     * @return sorted array
     */
    public static int[] mSort_Caller(int[] theArray){
        // Call the sort
        call_mSort(theArray);

        // Return the new value
        return theArray;
    }
}
