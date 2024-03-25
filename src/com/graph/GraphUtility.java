package com.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphUtility {

	public static Graph createGraph() {
	    Graph graph = new Graph();
	    graph.addVertex("Bob");
	    graph.addVertex("Alice");
	    graph.addVertex("Mark");
	    graph.addVertex("Rob");
	    graph.addVertex("Maria");
	    graph.addEdge("Bob", "Alice");
	    graph.addEdge("Bob", "Rob");
	    graph.addEdge("Alice", "Mark");
	    graph.addEdge("Rob", "Mark");
	    graph.addEdge("Alice", "Maria");
	    graph.addEdge("Rob", "Maria");
	    return graph;
	}

	static List<Integer>[] initGraph(int[][] arr) {
		@SuppressWarnings("unchecked")
		List<Integer>[] graph = new ArrayList[arr.length];
		for (int a = 0; a < arr.length; a++) {
			graph[a] = new ArrayList<>();
			for (int j = 0; j < arr[a].length; j++) {
				int val = arr[a][j];
				if (a == j);
				else {
					if (val == 1)
						graph[a].add(j);
				}
			}
			System.out.println("For vertex=" + a + " edges=" + graph[a]);
		}
		return graph;
	}
}
