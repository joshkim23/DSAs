package LinkedLists;

// import java.util.*;

// Feel free to add new properties and methods to the class.
class Program {
  static class DoublyLinkedList {
    public Node head;
    public Node tail;

    public void setHead(Node node) {
        node.next = head; 
        node.prev = null;
        head.prev = node; 
        head = node; 
    }

    public void setTail(Node node) {
        node.prev = tail; 
        node.next = null;
     	tail.next = node; 
        tail = node;
    }

    public void insertBefore(Node node, Node nodeToInsert) {
         Node current = head; 
			
        // this goes until current.next is equal to node. aka one before the node
        while (current.next != node) {
            current = current.next;
        }
        node.prev = nodeToInsert; 
        nodeToInsert.next = node; 
        nodeToInsert.prev = current;
        current.next = nodeToInsert;
    }

    public void insertAfter(Node node, Node nodeToInsert) {
         Node current = head; 
			
        while (current != node) {
            current = current.next;
        }
        // current is equal to node here
        Node temp = current.next; // store the next node after node
        current.next = nodeToInsert;
        nodeToInsert.prev = current;
        nodeToInsert.next = temp;
    }

    public void insertAtPosition(int position, Node nodeToInsert) {
         Node current = head; 
        int nodeNumber = 1; 
        if (position == 1) {
            setHead(nodeToInsert);
        } else {
            while (nodeNumber < position-1) {
                current = current.next;
                nodeNumber++;
            }
            // current is at the node before the position 
            nodeToInsert.next = current.next; 
            nodeToInsert.prev = current;
            current.next = nodeToInsert;
        }
    }

    public void removeNodesWithValue(int value) {
        Node current = head; 
			
        while (current.next != null) {
            if (current.value == value) {
                remove(current);
            } 
            current = current.next;
        }
    }

    public void remove(Node node) {
        Node current = head; 
        if (current == node) {
            setHead(node.next);
        } else {
            while (current.next != node) {
                current = current.next; 
                if (current.next == node) {
                    current.next = current.next.next; 
                    current.next.next.prev = current.next;
                }
            }	
        }
    }

    public boolean containsNodeWithValue(int value) {
        Node current = head; 
        if (current.value == value) return true; 
        
        while (current.next != null) {
            if (current.value == value) return true;
            current = current.next; 
        }
			
        return false;
    }
  }

  // Do not edit the class below.
  static class Node {
    public int value;
    public Node prev;
    public Node next;

    public Node(int value) {
        this.value = value;
    }
  }
}

