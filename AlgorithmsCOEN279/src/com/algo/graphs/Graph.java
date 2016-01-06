/**
 * 
 */
package com.algo.graphs;

import java.util.*;

/**
 * @author Surag Suresh Yalaburgi
 * 
 */
public class Graph {

  private int V; // No. of vertices

  // Constructor
  Graph(int v) {
    V = v;
    HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<Integer, ArrayList<Integer>>();
    for (int i = 0; i < V; i++) {
      ArrayList<Integer> list = new ArrayList<Integer>();
      adjList.put(i, list);
    }

  }

  public boolean addEdge(int u, int v) {
    return false;
  }

  public boolean addEdge(int u, int v, int weight) {
    return false;
  }

  public boolean addEdge(int u, int v, int weight, boolean directed) {
    return false;
  }

  public static void main(String[] args) {

  }

}
