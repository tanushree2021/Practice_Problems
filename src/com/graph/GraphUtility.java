package com.graph;

import java.util.ArrayList;
import java.util.LinkedList;
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

	// Adjacency List frm 2D Matrix
	public static List<Integer>[] initGraph(int[][] arr) {
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

	public static List[] initGraphAdjList(int vertices)
	{
		List<Integer>[] adjList = new LinkedList[vertices];
		for (int i = 0; i < vertices; ++i)
			adjList[i] = new LinkedList<>();
		return adjList;
	}

	// Function to print the graph representation, for Adjacency List
	public static void printGraph(List[] list, int vertices)
	{
		for(int i = 0; i < vertices; i++)
		{
			System.out.print(i + "--> ");
			for(int j = 0; j < list[i].size(); j++)
				System.out.print(list[i].get(j) + " ");
			System.out.println();
		}
	}

	/**
	 *
	 * 	0 --> 2
	 * 	1 --> 0
	 * 	2 --> 3 , 1
	 * 	3 -->
	 *
	 * @param u
	 * @param v
	 */
	public static void addEdge(int u, int v, List[] adjList) {
		adjList[u].add(v);
	}
}
