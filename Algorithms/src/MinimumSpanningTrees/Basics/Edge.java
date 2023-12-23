package MinimumSpanningTrees.Basics;

public class Edge implements Comparable<Edge>
{
	private int v, w;
	private double weight;
	
	public Edge(int v, int w, double weight)
	{
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public double weight()
	{
		return weight;
	}
	
	public int either()
	{
		return v;
	}
	
	public int other(int v)
	{
		return this.v == v ? this.w : this.v;
	}
	
	public int compareTo(Edge that)
	{
		int vertex1 = that.either();
		int vertex2 = that.other(vertex1);
		
		if (vertex2 == this.other(vertex1) && vertex1 == this.other(vertex2)) return 0;
		
		return 1;
	}
	
	@Override
	public String toString()
	{
		return String.format("Edge from %d to %d, with weight %f", this.v, this.w, this.weight);
	}
}
