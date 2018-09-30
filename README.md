Java Sorting Algorithms

This is just a simple project I did to get more practice writing some sorting algorithms. I mainly wanted to implement quick sort and merge sort, as they're both very useful and have great run times (superlinear - O(nlogn)) when implemented well. I wanted to time them so I could compare the two, so I added a selection sort just to show the difference between effecient and uneffecient sorting algorithms. I used System.nanotime calls to record the times, just for simplicity.

This program was written in Intellj using Java.

What is being sorted is just a simple array of ints. Its length and the range of its elements are retrieved via command line arguments. There are a total of 3 command line args: array length, element minimum number, & element maximum number. The arrays contents are then randomly generated within the provided range. Each of the three sorting algorithms are then run on a copy of the array and timed.

The results are pretty much as expected. With an array size of 50,000 with elements rangin from 1 to 100, the results on a single test are:
Selection sort: 2,420 milliseconds
Quick sort: 8 milliseconds
Merge sort: 14 milliseconds

Merge sort best, average, and worst case time complexity are all quadratic so of course it runs way slower then the other 2. Merge and quick sort both have the same average case time complexity, but quick sort runs a little bit faster becuase of its inner loop. 

Of the 3 sorting algorithms selection was of course the easiest to implement, with merge sort being slightly more difficult then quick sort. However, quick sort was my favorite to write. Having not implemented any of the three since my algorithms and complexity course made this a pretty fun little refresher that only took around 2 hours.
