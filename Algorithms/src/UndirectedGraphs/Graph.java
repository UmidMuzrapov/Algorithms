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
		adj.get(a).add(b);
		adj.get(b).add(a);
	}
	
	public int V() {
		return v;
	}
	
	public int E() {
		return e;
	}
	
	public ArrayList<LinkedList<Integer>> adj(){
		return adj;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("*Undirected Graph*\n");
		
		for (int i=0; i<v; i++) {
			str.append(i+": ");
			adj.get(i).forEach(e-> str.append(e+" "));
			str.append('\n');
		}
		
		return str.toString();
	}
	
	private void initializeAdj() {
		adj = new ArrayList<LinkedList<Integer>>();
		
		for (int i=0; i<v; i++) {
			adj.add(new LinkedList<Integer>());
		}
	}
}
