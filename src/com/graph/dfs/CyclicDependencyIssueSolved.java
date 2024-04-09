package com.graph.dfs;

import com.graph.GraphUtility;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 *
 * https://www.geeksforgeeks.org/detect-cycle-in-a-graph/?ref=lbp
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
 * Inputs :
 *
 * 1. [(0, 2), (1, 0), (2 ,1)]
 * 2. [(0, 2), (1, 3), (2 ,1) (3, 0)]
 * 3. [(0, 1), (1, 2), (2, 3), (3, 1)]
 * 4. [(0, 1), (1, 2), (3, 4),(4,5),(5,3)]
 * 5. [(0, 1), (1, 2), ... (50, 51), ... (99, 100), (100, 101), (101, 50)]
 *      OR [(0, 1), (1, 2), (2,3), (3, 4),(4,5),(5,3)]
 *
 * Outputs :
 *
 * 1) 0, 2, 1 or 2, 1, 0 or 1, 0, 2
 * 2) 0, 2, 1, 3
 * 3) 1, 2, 3
 * 4) 3, 4, 5
 * 5) 3, 4, 5
 *
 * <p>
 * Hint: Use Dept-First Search
 */
public class CyclicDependencyIssueSolved {

    static List<Integer>[] graph;
    static int vertices;

    public static void main(String[] args) {
        vertices = 3;
        graph = GraphUtility.initGraphAdjList(vertices);
        GraphUtility.addEdge(0, 2, graph);
        GraphUtility.addEdge(1, 0, graph);
        GraphUtility.addEdge(2, 1, graph);

        GraphUtility.printGraph(graph, vertices);
        System.out.println("Expected O/P : 0,2,1");

        issueDependency();

        /********************************/

        /*
        [(0, 2), (1, 3), (2 ,1) (3, 0)]
        O/P : 0,2,1,3
         */
        vertices = 4;
        graph = GraphUtility.initGraphAdjList(vertices);
        GraphUtility.addEdge(0, 2, graph);
        GraphUtility.addEdge(1, 3, graph);
        GraphUtility.addEdge(2, 1, graph);
        GraphUtility.addEdge(3, 0, graph);

        issueDependency();

        /********************************/

        /*
        [(0, 1), (1, 2), (2, 3), (3, 1)]
        O/P: 1,2,3
         */
        vertices = 4;
        graph = GraphUtility.initGraphAdjList(vertices);
        GraphUtility.addEdge(0, 1, graph);
        GraphUtility.addEdge(1, 2, graph);
        GraphUtility.addEdge(2, 3, graph);
        GraphUtility.addEdge(3, 1, graph);
        //Check this use case
        issueDependency();

        /********************************/

        /*
        [(0, 1), (1, 2), ... (50, 51), ... (99, 100), (100, 101), (101, 50)]
        [(0, 1), (1, 2), ... (3, 4),(4,5),(5,3)]

        O/P: 3,4,5
         */
        vertices = 6;
        graph = GraphUtility.initGraphAdjList(vertices);
        GraphUtility.addEdge(0, 1, graph);
        GraphUtility.addEdge(1, 2, graph);
        GraphUtility.addEdge(3, 4, graph);
        GraphUtility.addEdge(4, 5, graph);
        GraphUtility.addEdge(5, 3, graph);
        //Debug and see the O/P this use case
        issueDependency();

        /********************************/

        /*
        [(0, 1), (1, 2), ... (50, 51), ... (99, 100), (100, 101), (101, 50)]
        [(0, 1), (1, 2), (2,3), (3, 4),(4,5),(5,3)]

        O/P: 3,4,5
         */
        vertices = 6;
        graph = GraphUtility.initGraphAdjList(vertices);
        GraphUtility.addEdge(0, 1, graph);
        GraphUtility.addEdge(1, 2, graph);
        GraphUtility.addEdge(2, 3, graph);
        GraphUtility.addEdge(3, 4, graph);
        GraphUtility.addEdge(4, 5, graph);
        GraphUtility.addEdge(5, 3, graph);
        //Debug and see the O/P this use case
        issueDependency();
    }


    private static void issueDependency() {
        boolean dependencyExists = false;
        boolean[] visited = new boolean[vertices];
        Stack<Integer> blockerDependency = new Stack<>();
        for (int i = 0; i < vertices; i++) {
            dependencyExists = issuesBlockerDependency(i, visited, blockerDependency);
            if (dependencyExists) break;
        }
        if (dependencyExists)
            System.out.println("Blocker List: " + blockerDependency);
        else {
            System.out.println("No dependency for issues");
        }
        System.out.println("=======================");
    }

    private static boolean issuesBlockerDependency(int vertex, boolean[] visited, Stack<Integer> blockerDependency) {
        if (!blockerDependency.isEmpty()) {
            if (blockerDependency.get(0) == vertex) {
                return true;
            } else if (blockerDependency.contains(vertex)) {
                int startOfLoop = blockerDependency.indexOf(vertex);
                for(int k = 0 ; k< startOfLoop; k++) {
                    blockerDependency.remove(0);
                }
                return true;
            }
        }

        if (visited[vertex]) return false;
        visited[vertex] = true;
        blockerDependency.push(vertex);
        Iterator<Integer> issueDependencyLists = graph[vertex].listIterator();
        while (issueDependencyLists.hasNext()) {
            int dependentIssue = issueDependencyLists.next();
            if (issuesBlockerDependency(dependentIssue, visited, blockerDependency))
                return true;
        }
        blockerDependency.pop();
        return false;
    }
}
