package LinkedLists; // need to add package 'folder name' when its inside a folder within src!
// import java.util.*;

public class LinkedListPractice {
    public static void main(String[] args) {
        // Section 16.1 from Java textbook
        ListNode list = new ListNode(3, new ListNode(7, new ListNode(12)));

        String listTraversalVersionOne = printValuesWithWhileLoop(list);
        // System.out.println(listTraversalVersionOne); 

        String listTraversalVersionTwo = printValuesWithForLoop(list);
        // System.out.println(listTraversalVersionTwo);

        // Section 16.2 - using linkedIntList class
        LinkedIntList linkedList = new LinkedIntList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        System.out.println(linkedList.toString());
        System.out.println(linkedList.deleteDuplicates());
        // System.out.println(linkedList.deleteMid());


        // linkedList.add(1, 55);
        // System.out.println(linkedList.toString());

        // linkedList.remove(2);
        // System.out.println(linkedList.toString());

        // // System.out.println(linkedList.indexOf(100));
        // // System.out.println(linkedList.size());

        // System.out.println(linkedList.get(55));
        


    }

    public static String printValuesWithWhileLoop(ListNode list) {
        String printedList = "";
        ListNode current = list;
        while (current != null) {
            printedList += current.data + "\n";
            current = current.next;
        }
        return printedList;
    }

    public static String printValuesWithForLoop(ListNode list) {
        String printedList = "";
        for (ListNode current = list; current != null; current = current.next) {
            printedList += current.data + "\n";
        }
        return printedList;
    }
}
