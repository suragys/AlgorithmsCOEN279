/**
 * 
 */
package DS;

/**
 * @author Surag Suresh Yalaburgi
 *
 */
//Java program to print BFS traversal from a given source vertex.
//BFS(int s) traverses vertices reachable from s.
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

//This class represents a directed graph using adjacency list
//representation

class Graph {
  private static Map<Integer, LinkedList<Integer>> uniquePaths = new HashMap<Integer, LinkedList<Integer>>();
  private static ArrayList<Integer> connectedComponents = new ArrayList<Integer>();
  private static int key = 0;
  private int V; // No. of vertices
  private LinkedList<Integer> adj[]; // Adjacency Lists

  // Constructor
  Graph(int v) {
    V = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; ++i)
      adj[i] = new LinkedList();
  }

  // Function to add an edge into the graph
  void addEdge(int v, int w) {
    adj[v].add(w);
  }

  // Driver method to
  public static void main(String args[]) {
    Graph g = new Graph(6);

    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);
    g.addEdge(4, 4);
    g.addEdge(4, 5);

    for (int i = 0; i < g.V; i++) {
      connectedComponents.add(-1);
    }

    for (int i = 0; i < connectedComponents.size(); i++) {
      if (connectedComponents.get(i) == -1) {
        g.BFS(i);
      }

      // = generateMatrix();

    }
    int[][] matrix = new int[g.V][g.V];
    for (int j = 0; j < matrix.length; j++) {
      for (int k = 0; k < matrix.length; k++) {
        if (connectedComponents.get(j) == connectedComponents.get(k)) {
          matrix[j][k] = 1;
        } else {
          matrix[j][k] = 0;
        }
        System.out.print(matrix[j][k]);
      }
      System.out.println();
    }
    System.out.println("cc =" + connectedComponents);
    for (Integer path : uniquePaths.keySet()) {
      System.out.println(uniquePaths.get(path));
    }

  }

  /**
   * 
   */
  private static int[][] generateMatrix() {
    // for()

    return null;

  }

  void BFS(int s) {
    // Mark all the vertices as not visited(By default
    // set as false)
    boolean visited[] = new boolean[V];

    // Create a queue for BFS
    LinkedList<Integer> queue = new LinkedList<Integer>();

    // Mark the current node as visited and enqueue it
    visited[s] = true;
    queue.add(s);
    LinkedList<Integer> path = new LinkedList<Integer>();

    while (queue.size() != 0) {
      // Dequeue a vertex from queue and print it
      s = queue.poll();
      path.add(s);

      // Get all adjacent vertices of the dequeued vertex s
      // If a adjacent has not been visited, then mark it
      // visited and enqueue it
      Iterator<Integer> i = adj[s].listIterator();
      while (i.hasNext()) {
        int n = i.next();
        if (!visited[n]) {
          visited[n] = true;
          queue.add(n);
        }
      }
      connectedComponents.set(s, key);
    }
    System.out.println("unique path" + path);
    uniquePaths.put(key, path);
    key++;
  }
}