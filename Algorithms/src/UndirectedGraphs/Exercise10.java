package UndirectedGraphs;

public class Exercise10 {

	private boolean marked[];
	private int vertexToRemove;
	
	public Exercise10(Graph g, int v){
		marked = new boolean[g.V()];
		dfs(g, v);
	}
	
	private void dfs(Graph g, int v) {
		marked[v] = true;
		boolean neighborsVisited = false;
		
		for (int adjV : g.adj().get(v)) {
			if (!marked[v]) {
				dfs(g, adjV);
				neighborsVisited = true;
			}
		}
		
		if (neighborsVisited) {
			vertexToRemove = v;
		}
	}
	
	private boolean connected(int w) {
		return marked[w];
	}
}
