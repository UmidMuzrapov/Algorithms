package MinimumSpanningTrees.Basics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class EdgeWeightedGraph {
  // number of vertices and edges
  private int v, e;
  private ArrayList<LinkedList<Edge>> adj;

  public EdgeWeightedGraph(int v) {
    this.v = v;
    this.e = 0;
    initializeAdj();
  }

  public EdgeWeightedGraph(String path) {
    readInStream(path);
  }

  public int V() {
    return this.v;
  }

  public int E() {
    return this.e;
  }

  public LinkedList<Edge> adj(int v) {
    return adj.get(v);
  }

  public LinkedList<Edge> edges() {
    LinkedList<Edge> result = new LinkedList<Edge>();
    adj.forEach(e -> result.addAll(e));
    return result;
  }

  public void addEdge(Edge e) {
    int vertex1 = e.either();
    int vertex2 = e.other(vertex1);
    adj.get(vertex1).addFirst(e);
    adj.get(vertex2).addFirst(e);
    this.e++;
  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < this.v; i++) {
      str.append(i + ": ");
      adj.get(i).forEach(e -> str.append(e.toString() + " "));
      str.append('\n');
    }

    return str.toString();
  }

  private void readInStream(String path) {
    File file = new File(path);

    try {
      Scanner inStream = new Scanner(file);
      this.v = inStream.nextInt();
      this.e = inStream.nextInt();
      this.e = 0;
      initializeAdj();

      while (inStream.hasNext()) {
        int vertex1 = inStream.nextInt();
        int vertex2 = inStream.nextInt();
        double weight = inStream.nextDouble();
        addEdge(new Edge(vertex1, vertex2, weight));
      }

      inStream.close();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      System.out.println("The input file could not be opened");
    }
  }

  private void initializeAdj() {
    adj = new ArrayList<LinkedList<Edge>>(v);

    for (int i = 0; i < v; i++) {
      adj.add(new LinkedList<Edge>());
    }
  }
}
