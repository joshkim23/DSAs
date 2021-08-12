package Sorting;
import java.util.*;

// Quick sort works on the basis that an element in an array is in sorted position if every element before it is smaller and it and every element after it is larger than it. 
// Even if the elements before/after it are not sorted, as long as they satisfy the condition it is true!
    // It works by setting three pointers: last known sorted index which starts off as index -1, test index which starts off as index 0, and a pivot which can be any element - the best case scenario happens when the value of the pivot is in the middle of the list. Pick a random pivot. Picking the first or last one increases chances of picking the smallest or largest number giving the worst result: O(n^2)
    // You iterate by comparing j and the pivot. If j>pivot, you increment j and leave i alone. If j<pivot, you increment i, then    swap the values at i and j, then you increment j 
    // You continue this until j reaches pivot index-1; j>pivot here, you move pivot to i+1 and then you reset the pivot and j. s
// Performance: Quick sort is an O(n2) sorting algorithm used by Chrome's V8 engine that is only efficient for SMALL array size/data sets. For larger lists, merge sort is more efficient and works faster. 
// Quick Sort doesn’t require any extra storage whereas merge sort requires O(N) extra storage, N denoting the array size which may be quite expensive. Allocating and de-allocating the extra space used for merge sort increases the running time of the algorithm
    
public class QuickSort extends MergeSort{
    public static final int LIST_MAX_NUMBER = 40;
    public static final int LIST_LENGTH = 10;
    public static void main(String[] args) {
        System.out.println();

        int[] list = getRandomUniqueArray(LIST_LENGTH, LIST_MAX_NUMBER);
        System.out.println("array before sorting: \n" + Arrays.toString(list) + "\n");

        quickSort(list, 0, list.length-1);
        System.out.println("array AFTER sorting: \n" + Arrays.toString(list));

        System.out.println();
    }

    public static void quickSort(int[] list, int begin, int end) {
        if (begin < end) {
            int j = partitionList(list, begin, end);
            quickSort(list, begin, j-1);
            quickSort(list, j+1, end);
        }

    }

    // partitions a list into two, returns the value of the correct index of the pivot which is in sorted position at the end
    public static int partitionList(int[] list, int left, int right) {
        int pivot = list[right]; 
        int i = left;


        for (int j = left; j<right; j++) {
            if (list[j] < pivot ) {
                swap(list, i, j);
                i++;
            }
        }
        swap(list, i, right);

        return i;

        // doesn't work for some reason...
        // while (i < j) {
        //     do {
        //         i++;
        //     } while (
        //         list[i] < pivot
        //     );

        //     do {
        //         j--;
        //     } while (
        //         list[j] > pivot
        //     );

        //     if (i < j) {
        //         swap(list, i, j);
        //     }
        // }
        // swap(list, left, j);
        // return j;

    }

    public static void swap(int[] list, int pos1, int pos2) {
        int temp = list[pos1];
        list[pos1] = list[pos2];
        list[pos2] = temp;
    }


    public static int[] getRandomUniqueArray(int length, int maxValue) {
        HashSet<Integer> previousValues = new HashSet<Integer>(); // hashset has UNSORTED values - unlike treeset. Want unsorted here so we can sort it with quicksort
        int[] randomArray = new int[length];

        Random r = new Random(); 
        int i = 0;

        while (i != length) {
            int newValue = r.nextInt(maxValue);
            if(!previousValues.contains(newValue)){ // if Random object produces an integer that is not in the hashset, add it to the set and the arraylist. Continue until the desired length of the list is reached
                previousValues.add(newValue);
                randomArray[i] = newValue;
                i++;
            } 
        }
        return randomArray; 
    }
}
