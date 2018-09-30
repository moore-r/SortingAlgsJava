public class SelectionSort {
    public static int[] sSort(int[] theArray){
        // Save the length
        int count =  theArray.length;

        // Outer loop goes through each element of the unsorted part of the array
        for(int i = 0; i < (count-1); i += 1){

            // Set the smallest element to the first one, may be replaced in inner loop
            int smallest = i;

            // Inner loop finds the minimum element in the unsorted part of the array
            for(int j = (i + 1); j < count; j += 1){
                if(theArray[j] < theArray[smallest]){
                    smallest = j;
                }
            }

            // Save the smallest in a temp var
            int tempMin = theArray[smallest];

            //Swap it with the current place
            theArray[smallest] = theArray[i];
            theArray[i] = tempMin;
        }

        return theArray;
    }
}
