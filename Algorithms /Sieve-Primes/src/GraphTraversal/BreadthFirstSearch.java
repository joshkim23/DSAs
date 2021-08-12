import java.util.*;

// Implements a queue instead of a stack. 
// Rules for breadth first search
// 1. Visit the next unvisited vertex (if there is one) that's adjacent to the curent vertex, mark it, and insert it into the queue
// 2. If you can't carry out Rule 1 because there are no more unvisited vertices, remove a vertex from the queue (if possible) and make it the current vertex
// 3. If you can't varry out Rule 1 or 2 because the queue is empty, you're done
public class BreadthFirstSearch {
    public static void main(String[] args) {
        GraphX theGraph = new GraphX();
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
        System.out.println("Breadth First Search: ");
        // System.out.println("Vertices: " + Arrays.toString(theGraph.vertexList));
        System.out.println("Adjaceny matrix: " + Arrays.deepToString(theGraph.adjMat)); // used for 2d arrays

        System.out.print("Visits: ");
        theGraph.breadthFirstSearch();
        System.out.println();
    }
}


// Queue class
class QueueX {
    private final int SIZE = 20;
    private int[] queue;
    private int front;
    private int rear;

    public QueueX() {
        queue = new int[SIZE];
        front = 0;
        rear = -1;
    }

    // put item at rear of queue
    public void insert(int j) {
        if (rear == SIZE-1) {
            rear = -1;
        }
        queue[++rear] = j;
    }

    // take item from front of queue
    public int remove() {
        int temp = queue[front++];
        if (front == SIZE) {
            front = 0;
        }
        return temp;
    }

    public boolean isEmpty() {
        return (rear + 1 == front || (front + SIZE - 1 == rear));
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

class GraphX {
    private final int MAX_VERTS = 5;
    public Vertex[] vertexList; //list of vertices
    public int adjMat[][]; //adjacency matrix for graph
    private int nVerts; // current number of vertices
    private QueueX theQueue;

    // graph constructor - constructs a 2d matrix with all 0s to start
    public GraphX() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS]; // make n x n matrix
        nVerts = 0;
        for (int j=0; j<MAX_VERTS; j++) {
            for (int k=0; k<MAX_VERTS; k++) {
                adjMat[j][k] = 0;
            }
        }
        theQueue = new QueueX();
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

    public void breadthFirstSearch() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theQueue.insert(0);
        int v2;

        while (!theQueue.isEmpty()) {
            int v1 = theQueue.remove();

            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                theQueue.insert(v2);
            }
        }

        for (int j=0; j<nVerts; j++) {
            vertexList[j].wasVisited = false;
        }
    }

}