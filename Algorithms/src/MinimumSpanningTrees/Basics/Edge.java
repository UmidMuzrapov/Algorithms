package MinimumSpanningTrees.Basics;

public class Edge implements Comparable<Edge> {
  private int v, w;
  private double weight;

  public Edge(int v, int w, double weight) {
    this.v = v;
    this.w = w;
    this.weight = weight;
  }

  public double weight() {
    return weight;
  }

  public int either() {
    return v;
  }

  public int other(int v) {
    return this.v == v ? this.w : this.v;
  }

  public int compareTo(Edge that) {
    if (this.weight() > that.weight()) return 1;
    else if (this.weight() < that.weight()) return -1;
    else return 0;
  }

  @Override
  public String toString() {
    return String.format("Edge from %d to %d, with weight %.2f", this.v, this.w, this.weight);
  }
}
