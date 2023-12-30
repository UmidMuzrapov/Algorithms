package UndirectedGraphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS {

  private int s;
  private boolean[] marked;
  private int[] distance;
  private int[] edgeTo;

  public BFS(Graph g, int s) {
    this.s = s;
    bfs(g);
  }

  private void bfs(Graph g) {
    Queue<Integer> q = new LinkedList<Integer>();
    marked[s] = true;
    q.add(s);
    distance[s] = 0;

    while (!q.isEmpty()) {
      int curVertex = q.remove();
      LinkedList<Integer> adjList = g.adj().get(curVertex);

      for (int adjV : adjList) {
        if (!marked[adjV]) {
          edgeTo[adjV] = curVertex;
          marked[adjV] = true;
          q.add(adjV);
          distance[adjV] = distance[curVertex] + 1;
        }
      }
    }
  }

  public boolean hasPathTo(int v) {
    return marked[v];
  }

  public Stack<Integer> pathTo(int v) {
    if (!hasPathTo(v)) return null;
    Stack<Integer> path = new Stack<Integer>();
    for (int x = v; x != s; x = edgeTo[x]) {
      path.push(x);
    }

    path.push(s);
    return path;
  }

  public int ditanceTo(int v) {
    if (!marked[v]) return -1;
    return distance[v];
  }
}
