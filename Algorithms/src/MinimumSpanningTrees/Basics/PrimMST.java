package MinimumSpanningTrees.Basics;

import java.util.PriorityQueue;

public class PrimMST
{
	private Edge[] edgeTo;
	private double[] distTo;
	private boolean[] marked;
	private PriorityQueue<VertexDist> pq;
	
	public PrimMST(EdgeWeightedGraph g)
	{
		edgeTo = new Edge[g.V()];
		distTo = new double[g.V()];
		marked = new boolean[g.V()];
		pq = new PriorityQueue<VertexDist>();
		for (int v = 0; v < g.V(); v++)
		{
			distTo[v] = Double.POSITIVE_INFINITY;
		}
		
		distTo[0] = 0.0;
		pq.add(new VertexDist(0, 0));
		while (!pq.isEmpty())
		{
			visit(g, pq.remove().v);
		}
	}
	
	private void visit(EdgeWeightedGraph g, int v)
	{
		marked[v] = true;
		for (Edge e: g.adj(v))
		{
			int w = e.other(v);
			if (marked[w]) continue;
			if (e.weight() < distTo[w])
			{
				edgeTo[w] =e;
				distTo[w] = e.weight();
				if (pq.contains(w))
				{
					pq.remove(new VertexDist(w, 0));
					pq.add(new VertexDist(w, distTo[w]));
				}
				
				else
				{
					pq.add(new VertexDist(w, distTo[w]));
				}
				
			}
		}
	}
	
	
}

class VertexDist implements Comparable<VertexDist>
{
	int v;
	double distance;
	
	public VertexDist(int v, double distance)
	{
		this.v = v;
		this.distance = distance;
	}
	
	@Override
	public boolean equals(Object that)
	{
		if (that instanceof VertexDist)
		{
			return this.v == ((VertexDist) that).v;
		}
		
		return false;
	}

	@Override
	public int compareTo(VertexDist o)
	{
		if (this.distance > o.distance) return 1;
		else if (this.distance < o.distance) return -1;
		else return 0;
	}
}