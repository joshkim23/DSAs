package Sorting.SimpleSortingAlgos;
import java.util.*;

// Insertion sort works on the basis that in an array there is a partially sorted group of elements within it. You sort it by grabbing elements that are not in the partial sort and you INSERT them by shifting the values accordingly to get it in the right position. 
// From a random array of integers, you can create the partially sorted array by starting at the first value and then comparing the next value to it and adding it before it or leaving it etc. and gradually sorting and inserting new elements!
// Best of the simple sorting algorithms - still O(n^2) but 2x faster than bubble sort and generally faster than selection sort
// Very powerful out of the three basic sorting algorithms, particularly for a small input and with partially sorted data. 
// For larger amounts of data, quicksort is generally considered the fastest approach;
public class InsertionSort extends BubbleSort{
    public static void main(String[] args) {
        System.out.println();

        int[] list = getRandomUniqueArray(10, 30);
        System.out.println("unsorted list of unique integers: " + Arrays.toString(list));
        insertionSort(list);
        System.out.println("sorted list using bubble sort algorithm " + Arrays.toString(list));

        System.out.println();
    }

    public static void insertionSort(int[] list) {
        int nextIntInsertionIndex; // index of value that is gonna undergo the test: either be INSERTED in the virtual sorted array before it, or be left alone

        for(int j=1; j<list.length; j++) {
            int temp = list[j]; // store the value that is going to be inserted because the shift after inserting it will overwrite this index. 
            nextIntInsertionIndex = j;
            
            // loop backwards checking to see if you find the index that the value should be inserted it. Until then, swap the temp value with the next value going backwards. Comparing two things at a time!
            while (nextIntInsertionIndex > 0 && list[nextIntInsertionIndex-1] >= temp) { // go backwards in the array until you find the element that is smaller than the temp data, then insert it and shift the rest of the elements upwards
                swap(list, nextIntInsertionIndex, nextIntInsertionIndex-1);
                nextIntInsertionIndex--;
            }
        }
    }
}
