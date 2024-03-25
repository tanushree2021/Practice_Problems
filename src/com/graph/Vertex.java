package com.graph;

/**
 * https://www.baeldung.com/java-graphs
 *
 * Graph Representations
 * A graph can be represented in different forms such as adjacency matrix and adjacency list
 *
 * An adjacency matrix is a square matrix with dimensions equivalent to the number of vertices in the graph.
 * @param <T>
 */
class Vertex<T> {
    T label;
    
    Vertex(T label) {
        this.label = label;
    }
    
 // equals and hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}    
}