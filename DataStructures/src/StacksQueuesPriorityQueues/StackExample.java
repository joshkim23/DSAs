import java.util.*;

import LinkedLists.LinkedIntList;
import LinkedLists.ListNode;

/* 
A stack is a collection that allows access only to the top of a list, providing "Last In First Out (LIFO)" access
Used more as a programmer tool rather than a data storage device. Its lifetime is typically shorter than database type structures 
and are created/used to carry out a particular task during the operation of a program, then when the task is completed they're discarded.
Common operations include: 
    - adding (push) to top of the list
    - removing (pop) from top of the list
    - checking if the stack is empty
    - asking for the stack's size
    - "peeking" at the top element without removing it
Common implementations: 
    - Traverse through the nodes of a tree or vertices of a graph
        -Depth First Search for Trees and graphs
    - Checking parentheses/braces/brackets are balanced
    - Reversing strings/lists 
    - Recursive backtracking for maze/sudoku solvers etc.
Implemented using Linked List! 
*/

public class StackExample {
    private int maxSize = 20;
    private int size = 0;
    private LinkedIntList topOfStack;
    private int top; // top of stack

    public StackExample() {}

    public void push(int value) {
        if (this.size == 1) {
            topOfStack.add(value);
        } else {
            ListNode newTop = new ListNode(value); 
            topOfStack.next = newTop;
            topOfStack = newTop;
        }
    }

    public int pop() {
        if (this.size > 1) {

        }
    }

}



