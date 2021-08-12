package Sorting.SimpleSortingAlgos;
import java.util.*;

// The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.
    // 1) The subarray which is already sorted.
    // 2) Remaining subarray which is unsorted.
// In every iteration of selection sort, the minimum element (considering ascending order) from the unsorted subarray is picked and moved to the sorted subarray.

// Selection sort works by making a pass through a list and identifying the smallest value and then swapping its location with the first index of the list (assuming it isn't already at the first index). 
// With this method, the sorted elements are filled from left to right - after the swap the left most element is sorted. 
// It is still O(n^2) time, but the number of swaps necessary did improve from O(n^2) to O(n). The comparisons remains as O(n^2)
public class SelectionSort extends BubbleSort{
    public static void main(String[] args) {
        System.out.println();

        int[] list = getRandomUniqueArray(10, 30);
        System.out.println("unsorted list of unique integers: " + Arrays.toString(list));
        selectionSort(list);
        System.out.println("sorted list using selection sort: " + Arrays.toString(list));


        System.out.println();
    }

    public static void selectionSort(int[] list) {
        int indexOfLastSortedElement;
        int indexOfSmallestValue;

        for (indexOfLastSortedElement= -1; indexOfLastSortedElement<list.length; indexOfLastSortedElement++) {
            indexOfSmallestValue = indexOfLastSortedElement + 1; // store the smallest value by default as the first index of the rest of the unsorted portion of the array
            for (int j = indexOfLastSortedElement+1; j<list.length; j++) {
                if(list[j] < list[indexOfSmallestValue]) { // flipping the < and > makes it ascending/descending
                    swap(list, indexOfLastSortedElement+1, j);
                }
            }
        }
    }
}
