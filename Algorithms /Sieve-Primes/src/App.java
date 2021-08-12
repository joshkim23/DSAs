import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
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
