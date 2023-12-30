package MinimumSpanningTrees.Basics;

public class MSTClient {
  public static void main(String[] args) {
    args = new String[1];
    args[0] = "input/tinyEWG.txt";
    if (args.length == 1) {
      EdgeWeightedGraph graph = new EdgeWeightedGraph(args[0]);
      LazyPrimMST mst = new LazyPrimMST(graph);

      for (Edge e : mst.edges()) {
        System.out.println(e);
      }

      System.out.println(mst.weight());
    } else {
      System.err.println("Too few arguments");
      System.exit(-1);
    }
  }
}
