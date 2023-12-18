package UndirectedGraphs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GraphTest {

	@Test
	void test() {
		Graph graph = new Graph("input/undirected1");
		System.out.println(graph.toString());
	}

}
