package Searching;
import java.util.*;
import Sorting.MergeSort;
import java.util.concurrent.ThreadLocalRandom;

// Binary search is an O(log N) algorithm that searches for a value in a sorted list by repeatedly dividing the search space in half and evaluating the value of the list at that index and checking if it's equal to the value the client is looking for
public class BinarySearch extends MergeSort{
    public static void main(String[] args) {
        ArrayList<Integer> list = getRandomUniqueArray(30);
        System.out.println("randomized list of integers, not sorted" + list.toString());
        Collections.sort(list);
        System.out.println("post-sorted array list: " + list.toString());
        
        int desiredValue = 20;
        int indexOfDesiredValue = binarySearch(list, desiredValue);
        int textbookIndexOfDesiredValue = textbookBinarySearch(list, desiredValue);
        System.out.println("index of desired value " + desiredValue + " is " + indexOfDesiredValue + " || textbook version index: " + textbookIndexOfDesiredValue);
    }

    public static int binarySearch(ArrayList<Integer> list, int value) {
        // keep track of the start index, end index, and the midpoint index
        int startIndex = 0;
        int endIndex = list.size()-1;
        int midpointIndex = list.size()/2;

        // if the midpoint value is equal to value return the middle index
        if(list.get(midpointIndex) == value) return list.size()/2;

        // if the midpoint value is less than the value, move the start pointer to the midpoint index and re-evaluate the midpoint value. 
        // If the midpoint value is greater than the value, move the end pointer to the midpoint index and re-evalutate the midpoint value. 
        // Continue this until you either find the value, or until the start/end pointers are adjacent meaning that the value doesn't exist in the list.
        while (list.get(midpointIndex) != value && endIndex-startIndex > 1) {
            if(list.get(midpointIndex) < value) {
                startIndex = midpointIndex;
            } else {
                endIndex = midpointIndex;
            }
            midpointIndex = (startIndex + endIndex)/2;

            if(list.get(midpointIndex) == value) {
                return midpointIndex;
            } 
        }
        // if you get here, the start/end pointers are adjacent in the list. Return -1 signifying that the value doesn't exist in the list anywhere.
        return -1;
    }

    // from java textbook;
    public static int textbookBinarySearch(ArrayList<Integer> numbers, int target) {
        int min = 0;
        int max = numbers.size()-1;

        while (min<=max) {
            int mid = (max+min)/2;
            if (numbers.get(mid) == target) {
                return mid;
            } else if (numbers.get(mid) < target) {
                min = mid + 1;
            } else  {
                max = mid -1;
            }
        }
        return -1;
    }

    public static ArrayList<Integer> getRandomUniqueArray(int length) {
        HashSet<Integer> previousValues = new HashSet<Integer>();
        ArrayList<Integer> randomArray = new ArrayList<Integer>();
        
        while (randomArray.size() != length) {
            int newValue = ThreadLocalRandom.current().nextInt(0, 60);
            if(!previousValues.contains(newValue)){
                previousValues.add(newValue);
                randomArray.add(newValue);
            } 
        }
        return randomArray;
    }
}
