package com.graph.dfs;

import com.graph.Graph;
import com.graph.GraphUtility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Detect Cycle in a Directed Graph
 * https://www.geeksforgeeks.org/detect-cycle-in-a-graph/?ref=lbp
 * <p>
 * It is based on the idea that there is a cycle in a graph only if there is a back edge [i.e., a node points to one of its ancestors] present in the graph.
 * <p>
 * To detect a back edge, we need to keep track of the nodes visited till now and the nodes that are in the
 * current recursion stack [i.e., the current path that we are visiting].
 * If during recursion, we reach a node that is already in the recursion stack, there is a cycle present in the graph.
 */
public class DetectCycleInGraph {

    static List<Integer>[] graph;

    public static void main(String[] args) {

        /*
        0 --> 1,2
        1 --> 2
        2 --> 0,3
        3 --> 3

        Cycle : 0,2,0 ; 0,1,2,0
         */

        int vertices = 4;
        graph = GraphUtility.initGraphAdjList(vertices);

        GraphUtility.addEdge(0, 1, graph);
        GraphUtility.addEdge(0, 2, graph);
        GraphUtility.addEdge(1, 2, graph);
        GraphUtility.addEdge(2, 0, graph);
        GraphUtility.addEdge(2, 3, graph);
        GraphUtility.addEdge(3, 3, graph);
        int start = 2;
        GraphUtility.printGraph(graph, vertices);
        detectCycle(graph);
        System.out.println("==========================");
        cyclicGraphDetectionUsingTwoBooleanArrays();

        vertices = 4;
        graph = GraphUtility.initGraphAdjList(vertices);

        GraphUtility.addEdge(0, 1, graph);
        GraphUtility.addEdge(0, 2, graph);
        GraphUtility.addEdge(1, 2, graph);
        GraphUtility.addEdge(2, 3, graph);
        start = 2;
        GraphUtility.printGraph(graph, vertices);
        detectCycle(graph);
        cyclicGraphDetectionUsingTwoBooleanArrays();
    }

    private static void cyclicGraphDetectionUsingTwoBooleanArrays() {
        boolean isCyclicGraph = isCyclic();
        if(isCyclicGraph) {
            System.out.println("Cycle exists !!");
        } else {
            System.out.println("Cycle does not exists..!");
        }
    }

    /*
    GeeksForGeeks
    https://www.geeksforgeeks.org/detect-cycle-in-a-graph/?ref=lbp
     */
    private static boolean isCyclic () {
        boolean[] visited = new boolean[graph.length];
        boolean[] pathTracingStack = new boolean[graph.length];

        for(int j = 0; j< graph.length; j++) {
            if(isCyclicUtil(j, visited, pathTracingStack)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCyclicUtil(int node, boolean[] visited, boolean[] pathTracingStack) {
        if(pathTracingStack[node]) {
            return true;
        }

        if(visited[node]) return false;

        visited[node] = true;
        pathTracingStack[node] = true;
        Iterator<Integer> neighbourItr = graph[node].listIterator();
        while(neighbourItr.hasNext()) {
            int neighbour = neighbourItr.next();
            if(isCyclicUtil(neighbour, visited, pathTracingStack))
                return true;
        }
        pathTracingStack[node] = false;
        return false;
    }

    /*
    This is my way using Integer stack and boolean array as visited array
     */
    private static void detectCycle(List<Integer>[] graph) {
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> index = new Stack<>();
        boolean cycleExits = false;
        for( int i = 0; i< graph.length; i++) { // 0
            if(!visited[i]) {
                cycleExits = detectCycleRecursively(i, index, visited);
                visited[i] = true;
                System.out.println("----");
                if(cycleExits) break;
            }
        }
        if (cycleExits) {
            System.out.println("Cycle Exists...");
        } else
            System.out.println("Cycle does not Exists!");

    }

    private static boolean detectCycleRecursively(int current, Stack indexMarking, boolean[] visited) { // 0; 1; 2
        indexMarking.push(current); // [0] ; [0,1]; [0 1 2]

        if(!visited[current]) {
            visited[current] = true;
        }

        System.out.print(current + " ");
        boolean cycleExist = false;
        Iterator<Integer> neighbourItr = graph[current].listIterator();
        while(neighbourItr.hasNext()) {
            int neighbour = neighbourItr.next(); // 1,2 [1] ; 2 ; 0, 1 [0]
            if(!indexMarking.contains(neighbour)) {
                cycleExist = detectCycleRecursively(neighbour, indexMarking, visited);
            } else {
                cycleExist = true;
                return cycleExist;
            }
        }
        if(!cycleExist) {
            indexMarking.pop();
        }
        return cycleExist;
    }

}
