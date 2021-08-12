package LinkedLists;
import java.util.*;

public class LinkedIntList {
    private ListNode head; 
    // private ListNode end; 

    // constructs an empty list
    public LinkedIntList() {
        this.head = null;
    }

    // returns the current number of elements (nodes) in the list
    public int size() {
        int count = 0;
        ListNode current = this.head;
        while(current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    // returns the value of a node at a given index
    public int get(int index) {
        if(index < this.size()) {
            return nodeAt(index).data;
        } 
        return -1;
    }

    // returns comma separated, bracketed version of list
    public String toString() {
        if (this.head == null) {
             return "[]";
        } else {
            String result = "[ " + this.head.data;
            ListNode current = this.head.next;
            while (current != null) { // can't be current.next != null here because the last node won't be printed then! It always will have a null pointer
                result += ", " + current.data;
                current = current.next;
            }
            result += " ]";
            return result;
        }
    }

    // appends the given value to the end of the list
    public void add(int value) {
        if (this.head == null) {
            this.head = new ListNode(value);
        } else {
            ListNode current = head;
            while (current.next != null) { // needs to be current.next HERE specifically because you want to traverse every node EXCEPT the last one so you can add to it! ONLY the last node of the list will have a next field of null!
                current = current.next;
            }
            current.next = new ListNode(value);
        }
    }

    // add a given value to a specific index of the list
    public void add(int index, int value) {
        if (index == 0) {
            this.head = new ListNode(value, this.head);
        } else {
            ListNode nodeBeforeIndex = this.nodeAt(index-1);
            ListNode nodeAtIndex = nodeBeforeIndex.next;
            
            nodeBeforeIndex.next = new ListNode(value, nodeAtIndex);
        }
    }

    // removes the node at a particular index of the list
    public void remove(int index) {
        if (index == 0) {
            this.head = this.head.next;
        } else {
            ListNode nodeBeforeIndex = this.nodeAt(index-1);
            ListNode nodeAfterIndex = nodeBeforeIndex.next.next;
            nodeBeforeIndex.next = nodeAfterIndex;
        }
    }

    public int indexOf(int value) {
        int index = 0;
        ListNode currentNode = head;
        while(currentNode != null) { // traverse through entire list and run a test for each one, if it matches return index otherwise return -1 (no such value exists in the list)
            if (currentNode.data == value) {
                return index;
            }
            index++;
            currentNode = currentNode.next;
        }
        return -1;
    }

    // private utlity method to grab the node object at a specific index
    private ListNode nodeAt(int index) {
        ListNode current = head;
        for (int i=0; i < index; i++) {
            current = current.next;
        }
        return current; 
    }

    /* Cracking the Coding Interview Problems */
    // 2.1 Remove Duplicates
    // Description: Write code to remove duplicates from an unsorted linked list. 
    public String deleteDuplicates() {
        HashSet<Integer> previouslySeenValues = new HashSet<Integer>();
        
        ListNode previous = null; // keep track of the previous node so you can reference its next to the next one after current when current is a duplicate
        ListNode current = head;

        while (current != null) {
            if (!previouslySeenValues.contains(current.data)) {
                previouslySeenValues.add(current.data);
                previous = current;
            } else {
                previous.next = current.next;
            }

            current = current.next;
        }
        System.out.println(previouslySeenValues.toString());
        return this.toString();
    }





    /* For Leet code, custom methods */
    //returns the middle node of a linked list
    public ListNode getMid() {
        if (this.head == null || this.head.next == null) return null;

        ListNode oneStepCurrentNode = this.head;
        ListNode twoStepCurrentNode = this.head;

        while (twoStepCurrentNode != null && twoStepCurrentNode.next != null) {
            twoStepCurrentNode = twoStepCurrentNode.next.next;
            oneStepCurrentNode = oneStepCurrentNode.next;
        }
        return oneStepCurrentNode;
    }

    // deletes the middle node of a linked list
    public String deleteMid() {
        if (this.head == null || this.head.next == null) return null;

        ListNode oneStepCurrentNode = this.head;
        ListNode twoStepCurrentNode = this.head;

        while (twoStepCurrentNode != null && twoStepCurrentNode.next != null) {
            // if the two step pointer is on the last node before pointing to a null node two steps ahead, you are at the node before the middle point with the single step pointer. Grab this and make it point to the node after the middle, effectively removing any reference to the initial middle node 
            if (twoStepCurrentNode.next.next == null || twoStepCurrentNode.next.next.next == null) {
                oneStepCurrentNode.next = oneStepCurrentNode.next.next;
            }

            twoStepCurrentNode = twoStepCurrentNode.next.next; // this will either point to the last node (.next = null) or will be a null node (node = null)
            oneStepCurrentNode = oneStepCurrentNode.next;
        } 

        return this.toString();

    }
}
  