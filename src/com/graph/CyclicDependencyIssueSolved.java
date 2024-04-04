package com.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the cyclic Dependency list of Issue with the given issue list and blockers
 * <p>
 * -   0   1   2
 * 0   0   0   1
 * 1   1   0   0
 * 2   0   1   0
 * <p>
 * Output
 * 0,2,1 or 2,1,0 or 1,0,2
 * <p>
 * More examples
 * <p>
 * [(0, 2), (1, 0), (2 ,1)]
 * [(0, 2), (1, 3), (2 ,1) (3, 0)]
 * [(0, 1), (1, 2), (2, 3), (3, 1)]
 * [(0, 1), (1, 2), ... (50, 51), ... (99, 100), (100, 101), (101, 50)]
 * <p>
 * Hint: Use Dept-First Search
 */
public class CyclicDependencyIssueSolved {

    public static void main(String[] args) {
       int vertices = 3;
        List<Integer>[] adjList = GraphUtility.initGraphAdjList(vertices);
       GraphUtility.addEdge(0,2, adjList);
       GraphUtility.addEdge(1,0, adjList);
       GraphUtility.addEdge(2,1, adjList);

       GraphUtility.printGraph(adjList, vertices);

       List<Integer> issueBlockerCycliceDepList = cyclicDependencyUsingDepthFirstTraversal(adjList);

    }

    private static List<Integer> cyclicDependencyUsingDepthFirstTraversal(List<Integer>[] adjList) {
        List<Integer> cyclicDepListOfIssueBlocker = new ArrayList<>();
        return cyclicDepListOfIssueBlocker;
    }
}
