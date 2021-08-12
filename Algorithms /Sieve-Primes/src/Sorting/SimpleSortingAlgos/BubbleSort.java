package Sorting.SimpleSortingAlgos;
import java.util.*;

// Bubble sort is notoriously slow, but a very simple sorting algorithm. It runs at O(N^2) time
// The concept is, you start at the beginning of an array and compare two adjacent values and if the first > second you swap them and you iterate through the list
// At the end of each pass, the last element is guaranteed to be sorted. You continue this and swap the values up until N-1 were N is the last known sorted value index
public class BubbleSort {
    public static void main(String[] args) {
        System.out.println();

        int[] list = getRandomUniqueArray(10, 30);
        System.out.println("unsorted list of unique integers: " + Arrays.toString(list));
        bubbleSort(list);
        System.out.println("sorted list using bubble sort algorithm " + Arrays.toString(list));

        System.out.println();
    }

    public static void bubbleSort(int[] list) {
        int lastKnownSortedElementIndex, i;

        int comparisons = 0;

        for(lastKnownSortedElementIndex = list.length-1; lastKnownSortedElementIndex>1; lastKnownSortedElementIndex--) { // outer loop, need to run swapping algorithm up to last known sorted element -1; with this algorithm the elements are sorted right to left
            for (i=0; i<lastKnownSortedElementIndex; i++) { // inner loop running the swap algorithm from the first index to the last known sorted element -1;
                if(list[i] > list[i+1]) {
                    swap(list, i, i+1);
                }
                comparisons++;
            }
        }
        System.out.println("Total number of comparisons: " + comparisons);
    }

    public static void swap(int[] list, int first, int second) {
        int temp = list[first];
        list[first] = list[second];
        list[second] = temp;
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
