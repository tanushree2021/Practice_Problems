package com.graph;

import linkedList.Node;

import java.util.*;

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
public class CyclicDependencyIssue {

    public static void main(String[] args) {
        //Linked List Approach
        int[][] issueBlockerArr = {{0, 0, 1}, {1, 0, 0}, {0, 1, 0}};
//        List<Integer>[] issueBlockerList = GraphUtility.initGraph(issueBlockerArr);
//        findCyclicIssueBlockerList(issueBlockerArr);

        // Create Graph
        Graph issueBlocker = new Graph();
        int r = 0;
        for (int[] row : issueBlockerArr) {
            issueBlocker.addVertex(r);
            r++;
        }
        r = 0;
        for (int[] row : issueBlockerArr) {
            int c = 0;
            for (int col : row) {
                if (col == 1) {
                    issueBlocker.addEdge(r, c);
                }
                c++;
            }
            r++;
        }
//        issueBlocker.addVertex(0);
//        issueBlocker.addVertex(1);
//        issueBlocker.addVertex(2);
//        issueBlocker.addEdge(0,2);
//        issueBlocker.addEdge(1,0);
//        issueBlocker.addEdge(2,1);
//        issueBlocker.addEdge(0,1);
//        issueBlocker.addEdge(1,2);
//        issueBlocker.addEdge(2,0);

        // [(0, 2), (1, 0), (2 ,1)]
        System.out.println(issueBlocker.printGraph());

       // findCyclicDependencyListOfBlockers(issueBlocker, 0); // 2,1,0

//        issueBlocker = new Graph();
//        issueBlocker.addVertex(0);
//        issueBlocker.addVertex(1);
//        issueBlocker.addVertex(2);
//        issueBlocker.addVertex(3);
//        issueBlocker.addEdge(0,2);
//        issueBlocker.addEdge(1,3);
//        issueBlocker.addEdge(2,1);
//        issueBlocker.addEdge(3,0);
////        issueBlocker.addEdge(0,3);
////        issueBlocker.addEdge(1,2);
////        issueBlocker.addEdge(2,0);
////        issueBlocker.addEdge(3,1);
//
//        System.out.println(issueBlocker.printGraph());
//        // [(0, 2), (1, 3), (2 ,1) (3, 0)]
//        findCyclicDependencyListOfBlockers(issueBlocker, 0); // 0,2,1,3
//
//        issueBlocker = new Graph();
//        issueBlocker.addVertex(0);
//        issueBlocker.addVertex(1);
//        issueBlocker.addVertex(2);
//        issueBlocker.addVertex(3);
//        issueBlocker.addEdge(0,1);
//        issueBlocker.addEdge(1,2);
//        issueBlocker.addEdge(2,3);
//        issueBlocker.addEdge(3,1);
////        issueBlocker.addEdge(1,0);
////        issueBlocker.addEdge(1,3);
////        issueBlocker.addEdge(2,1);
////        issueBlocker.addEdge(3,2);
//
//        System.out.println(issueBlocker.printGraph());
//        // [(0, 1), (1, 2), (2, 3), (3, 1)]
//        findCyclicDependencyListOfBlockers(issueBlocker, 0); // 1,2,3

    }

    private static void findCyclicIssueBlockerList(int[][] issueBlockerArr) {
        for (int i = 0; i < issueBlockerArr.length; i++) {
            for (int j = 0; i < issueBlockerArr.length; j++) {
                if (issueBlockerArr[i][j] == 1 && i != j) {

                }
            }
        }
    }

    private static void findCyclicDependencyListOfBlockers(Graph issueBlocker, int vertex) {
        depthFirstTraversal(issueBlocker, vertex);
        System.out.println("=================");
    }

    static void depthFirstTraversal(Graph graph, int root) {
        Set<Integer> visitedNodes = new LinkedHashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(root);
        Integer cyclicStartPoint = null;
        while(!stack.isEmpty()) {
            Integer issue = stack.pop();
            if(visitedNodes.contains(issue)) {
                cyclicStartPoint = issue;
                break;
            } else {
                for (Object issueNode : graph.getAdjVertices(issue)) {
                    Vertex issueV = (Vertex) issueNode;
                    if (!visitedNodes.contains(issueV.label)) {
                        stack.push((Integer) issueV.label);
                        visitedNodes.add((Integer) issueV.label);
                    } else {
                        cyclicStartPoint = (Integer) issueV.label;
                        break;
                    }
                }
            }
        }
        System.out.println("cyclicStartPoint = "+cyclicStartPoint);
        List<Integer> issueBlockerList = new ArrayList<>();
        issueBlockerList.add(cyclicStartPoint);
        // Cyclic Blocker start point
        for (Object block: graph.getAdjVertices(cyclicStartPoint)) {
            // need directed graph
        }
    }

   /* static void depthFirstTraversal(Graph graph, int root) {
        Set<Integer> visitedNodes = new LinkedHashSet<>();
        Set<Integer> blockerList = new LinkedHashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Integer issue = stack.pop();
            if(!visitedNodes.contains(issue)){
                checkAdjacentNodes(graph, visitedNodes, stack, issue);
            } else {
                if(!blockerList.contains(issue)) {
                    checkAdjacentNodes(graph, blockerList, stack, issue);
                } else break;
            }
        }
        System.out.println(blockerList);
    }*/

    private static void checkAdjacentNodes(Graph graph, Set<Integer> visitedNodes, Stack<Integer> stack, Integer issue) {
        visitedNodes.add(issue);
        for (Object issueNode : graph.getAdjVertices(issue)) {
            Vertex issueV = (Vertex) issueNode;
            if (!visitedNodes.contains(issueV.label)) {
                stack.push((Integer) issueV.label);
                visitedNodes.add((Integer) issueV.label);
            }
        }
    }
}
