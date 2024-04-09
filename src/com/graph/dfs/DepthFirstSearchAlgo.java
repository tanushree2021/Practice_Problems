package com.graph.dfs;

import com.graph.GraphUtility;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

/**
 * Depth-first search is an algorithm for traversing or searching tree or graph data structures.
 * The algorithm starts at the root node (selecting some arbitrary node as the root node in the case of a graph) and
 * explores as far as possible along each branch before backtracking
 *
 *  0 --> 1,2,3
 *  2 --> 0,3,4
 *  3 --> 0,2
 *
 * Step1: Initially stack and visited arrays are empty.
 *  visited[5] = [];
 *  stack[5] = [];
 *
 * Step 2: Visit 0 and put its adjacent nodes which are not visited yet into the stack.
 *  visited = [0];
 *  stack = [1,2,3]
 *
 *  Step 3: Now, Node 1 at the top of the stack, so visit node 1 and pop it from the stack and
 *  put all of its adjacent nodes which are not visited in the stack.
 *  visited [0,1];
 *  stack [2,3]
 *
 *  Step 4: Now, Node 2 at the top of the stack, so visit node 2 and pop it from the stack and
 *  put all of its adjacent nodes which are not visited (i.e, 3, 4) in the stack.
 *  visited [0,1, 2];
 *  stack [4,3]
 *
 *  Step 5: Now, Node 4 at the top of the stack, so visit node 4 and pop it from the stack and
 *  put all of its adjacent nodes which are not visited in the stack.
 *  visited [0,1, 2,4];
 *  stack [3]
 *
 *  Step 6: Now, Node 3 at the top of the stack, so visit node 3 and pop it from the stack and
 *  put all of its adjacent nodes which are not visited in the stack.
 *  visited [0,1, 2,4,3];
 *  stack []
 */
public class DepthFirstSearchAlgo {

    private static List[] graph;


    public static void main(String[] args) {

        graph = GraphUtility.initGraphAdjList(4);
        GraphUtility.addEdge(0,1,graph);
        GraphUtility.addEdge(0,2,graph);
        GraphUtility.addEdge(1,2,graph);
        GraphUtility.addEdge(2,0,graph);
        GraphUtility.addEdge(2,3,graph);
        GraphUtility.addEdge(3,3,graph);
        GraphUtility.printGraph(graph, graph.length);
        System.out.println("Expected Output : 2 0 1 3");
        depthFirstTraversal(graph, 2);

        System.out.println("\n=================");
        DFS(graph, 2);
        System.out.println("\n=================");

        depthFirstTraversalPreservingOrder(graph, 2);
    }

    /*
Time complexity: O(V + E), where V is the number of vertices and E is the number of edges in the graph.
Auxiliary Space: O(V + E), since an extra visited array of size V is required, And stack size for iterative call to DFS function.
     */
    private static void DFS(List<Integer>[] graph, int start) {
        boolean[] visited = new boolean[graph.length];
        DFSUtil(start, visited);
    }

    private static void DFSUtil(int n, boolean[] visited) {
        visited[n] = true;
        System.out.print(n +" ");
        Iterator<Integer> neighbourItr = graph[n].listIterator();
        while(neighbourItr.hasNext()) {
            int neighbour = neighbourItr.next();
            if(!visited[neighbour]) {
                DFSUtil(neighbour, visited);
            }
        }

    }

    /**
     * Preserving order
     * 0 --> 1,2
     * 1 --> 2
     * 2 --> 0, 3
     * 3 --> 3
     *
     * @param graph
     * @param start
     */
    private static void depthFirstTraversalPreservingOrder(List<Integer>[] graph, int start) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[graph.length];
        stack.push(start);
        System.out.println("Preserving Order: Depth First Traversal from start node=" +start+" is :");
        while(!stack.isEmpty()) { // 2
            int currentNode = stack.pop(); // 2
            visited[currentNode] = true; // [0,0, 1, 0]
            System.out.print(currentNode +" ");
            List<Integer> neighbourList = graph[currentNode];
            ListIterator<Integer> neighbourIterator = neighbourList.listIterator(neighbourList.size());
            while(neighbourIterator.hasPrevious()) {
                int neighbour = neighbourIterator.previous();
                if(!visited[neighbour]) {
                    stack.push(neighbour);
                }
            }
        }
    }

    /**
     * Without considering the order
     * @param graph
     * @param start
     */
    private static void depthFirstTraversal(List<Integer>[] graph, int start) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[graph.length];
        stack.push(start);
        System.out.println("Depth First Traversal starting from start node=" +start+" is :");
        while(!stack.isEmpty()) {
            int currentNode = stack.pop();
            visited[currentNode] = true;
            System.out.print(currentNode +" ");
            for(Integer neighbour: graph[currentNode]) {
                if(!visited[neighbour]) {
                    stack.push(neighbour);
                }
            }
        }
    }


}
