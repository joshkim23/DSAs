package LinkedLists;

// ListNode is a class for storing a single node of a linked list. This node class is for a list of integer values.
public class ListNode {
    public int data; //data stored in this node
    public ListNode next; // link to next node in the list

    // constructs a node with data 0 and null link
    public ListNode() {
        this(0, null);
    }

    // constructs a node with given data and null link
    public ListNode(int data) {
        this(data, null);
    }

    // MAIN CONSTRUCTOR
    // constructs a node with given data and given link
    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }
}
