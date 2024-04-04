package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://www.baeldung.com/java-graphs
 * A graph is a data structure for storing connected data such as a network of people on a social media platform.
 * A graph consists of vertices and edges. A vertex represents the entity (e.g., people) and
 * an edge represents the relationship between entities (e.g., a person’s friendships).
 *
 * https://github.com/eugenp/tutorials/blob/master/data-structures/src/main/java/com/baeldung/graph/Graph.java
 */
public class Graph<T> {
	
	private Map<Vertex, List<Vertex>> adjVertices;

	Graph() {
		this.adjVertices = new HashMap<Vertex, List<Vertex>>();
	}
	
	// Mutation Operations
	
	void addVertex(T label){
		adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
	}
	
	void removeVertex(T label) {
		Vertex vertex = new Vertex(label);
		adjVertices.values().stream().forEach(e -> e.remove(vertex));
		adjVertices.remove(vertex);
	}
	
	void addEdge(T label1, T label2) {
		Vertex v1 = new Vertex(label1);
		Vertex v2 = new Vertex(label2);
		adjVertices.get(v1).add(v2);
		adjVertices.get(v2).add(v1);
	}
	
	void removeEdge(T label1, T label2) {
	    Vertex v1 = new Vertex(label1);
	    Vertex v2 = new Vertex(label2);
	    List<Vertex> eV1 = adjVertices.get(v1);
	    List<Vertex> eV2 = adjVertices.get(v2);
	    if (eV1 != null)
	        eV1.remove(v2);
	    if (eV2 != null)
	        eV2.remove(v1);
	}

	List<Vertex> getAdjVertices(T label) {
		return adjVertices.get(new Vertex(label));
	}

	String printGraph() {
		StringBuffer sb = new StringBuffer();
		for(Vertex v : adjVertices.keySet()) {
			sb.append(v.label);
			sb.append("-->");
			List<Vertex> edges = adjVertices.get(v);
			edges.stream().forEach(e ->
				sb.append(e.label + ",")
//				if (!(e.label.equals(edges.size() - 1))) {
//					sb.append(",");
//					}
//				}
			);
//			if(!v.label.equals(sb.length()-1))
			sb.append(" ; ");
		}
		return sb.toString();
	}
}
