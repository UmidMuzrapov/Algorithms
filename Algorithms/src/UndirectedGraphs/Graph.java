package UndirectedGraphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Graph {

  private int v;
  private int e;
  private ArrayList<LinkedList<Integer>> adj;

  public Graph(int v) {
    this.v = v;
    initializeAdj();
  }

  /**
   * This is a solution to exercise 4.1.3
   *
   * @param g graph that needs to be copied
   */
  public Graph(Graph g) {
    this.v = g.V();
    this.e = g.E();
    this.adj = new ArrayList<LinkedList<Integer>>();

    for (int i = 0; i < v; i++) {
      int adjIndex = i;
      adj.add(new LinkedList<Integer>());
      g.adj.get(i).forEach(e -> adj.get(adjIndex).add(e));
    }
  }

  public Graph(String path) {
    File inputFile = new File(path);
    if (!inputFile.exists()) {
      System.err.printf("The file %s does not exist.\n", path);
    }

    try {
      Scanner inputStream = new Scanner(inputFile);
      // read the number of vertices and edges
      this.v = inputStream.nextInt();
      this.e = inputStream.nextInt();
      initializeAdj();

      while (inputStream.hasNext()) {
        int a = inputStream.nextInt();
        int b = inputStream.nextInt();
        addEdge(a, b);
      }

      inputStream.close();
    } catch (FileNotFoundException e) {
      System.err.println(e.getMessage());
    }
  }

  public void addEdge(int a, int b) {
    // disallowing self-loops and parallel edges is 4.1.5
    // disallow self-loops
    if (a == b) return;
    // disallow parallel edges
    if (adj.get(a).contains(b)) return;
    adj.get(a).add(b);
    adj.get(b).add(a);
  }

  public int V() {
    return v;
  }

  public int E() {
    return e;
  }

  public ArrayList<LinkedList<Integer>> adj() {
    return adj;
  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder("*Undirected Graph*\n");

    for (int i = 0; i < v; i++) {
      str.append(i + ": ");
      adj.get(i).forEach(e -> str.append(e + " "));
      str.append('\n');
    }

    return str.toString();
  }

  private void initializeAdj() {
    adj = new ArrayList<LinkedList<Integer>>();

    for (int i = 0; i < v; i++) {
      adj.add(new LinkedList<Integer>());
    }
  }
}
