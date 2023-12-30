package MinimumSpanningTrees.Basics;

public class EdgeWeightedGraphClient {
  public static void main(String[] args) {
    args = new String[1];
    args[0] = "input/tinyEWG.txt";
    if (args.length != 1) {
      System.err.println("Too few arguments");
      System.exit(-1);
    }

    EdgeWeightedGraph myGraph = new EdgeWeightedGraph(args[0]);
    System.out.println(myGraph.toString());
  }
}
