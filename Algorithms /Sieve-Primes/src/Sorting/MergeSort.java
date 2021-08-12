package Sorting;
import java.util.*;

// Merge sort is an O(Nlog N) sorting algorithm that sorts an unordered list of values in increasing order. It achieves this by recursively splitting the list in half, sorting the halves, then merging them. The halves are also split until one element remains, then merged. 
public class MergeSort {
    public static void main(String[] args) {
        int[] list = {14, 32, 67, 76, 23, 41, 58, 85};
        // System.out.println("list before merge sort: " + Arrays.toString(list));
        mergeSort(list);

        // System.out.println("List AFTER merging: " + Arrays.toString(list));

    }

    public static void mergeSort(int[] a) {
        // base case is that the array size is 1, in that case there is no left/right side, you leave it as is
        if (a.length > 1) {
            // split array into two halves
            int[] left = Arrays.copyOfRange(a, 0, a.length/2);
            int[] right = Arrays.copyOfRange(a, a.length/2, a.length);

            // recursively sort the two halves
            // System.out.println("LEFT: " + Arrays.toString(left));
            // System.out.println("RIGHT: " + Arrays.toString(right));
            mergeSort(left);
            mergeSort(right);

            // merge the sorted halves into a sorted whole
            merge(a, left, right);
            // System.out.println("merged - completed one mergeSort function: " + Arrays.toString(a));
        }
    }

    public static void merge(int[] a, int[] left, int[] right) {
        // System.out.println("merging the following lists: " + Arrays.toString(left) + " " + Arrays.toString(right));
        // track index of each half of the array that you want to sort, left half and right half which are now sorted
        int indexOfLeft = 0;
        int indexOfRight = 0;

        // compare the values of each array at the respective index, select the lesser one and increment the corresponding array's index by one and loop until you merge the two sorted arrays        
        for(int i=0; i<a.length; i++) {
            if(indexOfRight >= right.length || (indexOfLeft < left.length && left[indexOfLeft] <= right[indexOfRight])) {
                a[i] = left[indexOfLeft];
                indexOfLeft++;
            } else {
                a[i] = right[indexOfRight];
                indexOfRight++;
            }

        }
    }

}
