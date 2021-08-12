import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("can i pls get corona ");
        System.out.println("can u pls get for me hehehehe");
        
        stackStringExample("?uoy era woh");
    }

    public static void stackStringExample(String list) {
        Stack<Character> stack = new Stack<Character>();
        for (int i=0; i<list.length(); i++) {
            stack.push(list.charAt(i));
        }
        while (!stack.isEmpty()) {
            char letter = stack.lastElement();
            stack.pop();
            System.out.print(letter);
        }
    }

    // Data Structures KEY IDEAS 
    /* 
        Hashtable is a data structure
            HashSet is a set (data structure) that implements a Hashtable
            HashMap is a map (data structure) that implements a Hashtable

        
    */

}
