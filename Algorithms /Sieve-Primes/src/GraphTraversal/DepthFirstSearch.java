import java.util.*;

// Represent a graph by adding vertices and defining edges between vertices - create an adjacency matrix and then run traversal algorithms using the adjacency matrix
// Rules for depth first search: 
// 1. If possible, visit an adjacent unvisited vertex, mark it as being visited, push it onto the stack
// 2. If you can't follow 1, then, if possible, pop a vertex off the stack 
// 3. if you can't follow 1 or 2, you're done.

public class DepthFirstSearch {
    public static void main(String[] args) {
        Graph theGraph = new Graph();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');

        theGraph.addEdge(0, 1); //AB
        theGraph.addEdge(1, 2); //BC
        theGraph.addEdge(0, 3); //AD
        theGraph.addEdge(3, 4); //DE

        System.out.println();
        System.out.println("Depth First Search: ");
        // System.out.println("Vertices: " + Arrays.toString(theGraph.vertexList));
        System.out.println("Adjaceny matrix: " + Arrays.deepToString(theGraph.adjMat)); // used for 2d arrays

        System.out.print("Visits: ");
        theGraph.depthFirstSearch();
        System.out.println();
    }
}

// ** public class allows the class to be accessed from other files in the src ie other PACKAGES. just class makes it only accessible to code in this package!
// Stack class
class StackX {
    private final int SIZE = 20;
    private int[] st;
    private int top;

    // constructor
    public StackX() {       
        st = new int[SIZE]; // make array
        top = -1;
    }
    
    // put item on stack
    public void push(int j) {
        st[++top] = j; // ++top vs. top++ return different things! ++top returns the value of top plus one, top++ returns the value of top and then increments it by one
    }

    // take item off stack
    public int pop() {
        return st[top--];
    }

    // peek at top of stack
    public int peek() {
        return st[top];
    }

    // true if nothing on stack ie top = -1
    public boolean isEmpty() {
        return (top == -1);
    }
}

// Vertex Class
class Vertex {
    public char label; 
    public boolean wasVisited;

    // constructor
    public Vertex(char lab) {
        label = lab;
        wasVisited = false;
    }
}

class Graph {
    private final int MAX_VERTS = 5;
    public Vertex[] vertexList; //list of vertices
    public int adjMat[][]; //adjacency matrix for graph
    private int nVerts; // current number of vertices
    private StackX theStack;

    // graph constructor - constructs a 2d matrix with all 0s to start
    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS]; // make n x n matrix
        nVerts = 0;
        for (int j=0; j<MAX_VERTS; j++) {
            for (int k=0; k<MAX_VERTS; k++) {
                adjMat[j][k] = 0;
            }
        }
        theStack = new StackX();
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1; // since adjacency matrix is symmetrical
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    // returns an unvisited vertex adjacent to vertex, v
    public int getAdjUnvisitedVertex(int v) {
        for (int j=0; j<nVerts; j++) {
            if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false) {
                return j;
            }
        }
        return -1;
    }

    public void depthFirstSearch() {
        vertexList[0].wasVisited = true; // mark the first vertex as visited, add it to the stack
        displayVertex(0);
        theStack.push(0);

        while (!theStack.isEmpty()) { // continue until the stack is empty
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1) { // if there are no unvisited adjacent vertices, pop the vertex off the stack
                theStack.pop();
            } else { // add the adjacent vertex to the stack, mark it as true
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }

        // stack is empty, so you're done searching
        for (int j=0; j<nVerts; j++) { // reset flags to run dfs again later
            vertexList[j].wasVisited = false;
        }
    }
}