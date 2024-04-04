package com.graph.bfs;

import com.graph.GraphUtility;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Breadth First Search (BFS) is a graph traversal algorithm that explores all the vertices in a graph at the
current depth before moving on to the vertices at the next depth level
The only catch here is, that, unlike trees, graphs may contain cycles, so we may come to the same node again.
To avoid processing a node more than once, we divide the vertices into two categories:

Visited and
Not visited.

https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/?ref=lbp

Algorithm:
Let’s discuss the algorithm for the BFS:

1. Initialization: Enqueue the starting node into a queue and mark it as visited.
2. Exploration: While the queue is not empty:
    - Dequeue a node from the queue and visit it (e.g., print its value).
    - For each unvisited neighbor of the dequeued node:
        - Enqueue the neighbor into the queue.
        - Mark the neighbor as visited.
3. Termination: Repeat step 2 until the queue is empty.

Example - 1
    0   1   2   3   4
 0  0   1   1   0   0
 1  0   0   0   1   1
 2  0   0   0   0   4
 3  0   0   0   0   0
 4  0   0   0   0   0

Output : 0, 1, 2, 3, 4

 Example - 2
    0   1   2   3   4   5
 0  0   1   1   0   0   0
 1  0   0   1   1   0   0
 2  0   0   0   1   0   0
 3  0   0   0   0   1   0
 4  1   1   0   0   0   1
 5  0   0   0   0   0   0

 Output: 0,1,2,3,4,5

 */
public class BreadthFirstSearchAlgo {

    static int vertices = 5;

    public static void main(String[] args) {

        List<Integer>[] adjList = new ArrayList[vertices];
        //Create Graph
        for( int i =0; i< vertices; i++) {
            adjList[i] = new ArrayList<>();
        }

        /*
        Example - 1
    0   1   2   3   4
 0  0   1   1   0   0
 1  0   0   0   1   1
 2  0   0   0   0   4
 3  0   0   0   0   0
 4  0   0   0   0   0

Output : 0, 1, 2, 3, 4
         */
        GraphUtility.addEdge(0, 1, adjList);
        GraphUtility.addEdge(0, 2, adjList);
        GraphUtility.addEdge(1, 3, adjList);
        GraphUtility.addEdge(1, 4, adjList);
        GraphUtility.addEdge(2, 4, adjList);

        breadthFirstTraversal(adjList, 0);
        System.out.println("=========================");
        /*
        Example - 2
 rc 0   1   2   3   4   5
 0  0   1   1   0   0   0
 1  0   0   1   1   0   0
 2  0   0   0   1   0   0
 3  0   0   0   0   1   0
 4  1   1   0   0   0   1
 5  0   0   0   0   0   0
 Output: 0,1,2,3,4,5

         */
        int[][] example2 = {{0,1,1,0,0,0},{0,0,1,1,0,0},{0,0,0,1,0,0},{0,0,0,0,1,0},{1,1,0,0,0,1},{0,0,0,0,0,0}};

        adjList = GraphUtility.initGraph(example2);
        breadthFirstTraversal(adjList, 0);
    }

    /**
     * 0 --> 1,2
     * 1 --> 3,4
     * 2 --> 4
     *
     * @param adjList
     * @param start
     */
    private static void breadthFirstTraversal(List<Integer>[] adjList, int start) {
        Queue<Integer>  queue = new LinkedList<>();
        boolean[] visited = new boolean[adjList.length];
        visited[start]=true;

        List<Integer> visitedList = new ArrayList<>();
        visitedList.add(start);

        queue.add(start);
        while(!queue.isEmpty()) { //[0] 0 ; [1,2] 1 ; [2,3,4] 2; [3,4] 3
            Integer currentV = queue.poll(); // 0; 1; 2; 3
            System.out.println("Current Node "+currentV);
            if(currentV != null) {
//                List<Integer> list = adjList[currentV]; //0-> 1,2 ; 1-> 3, 4; 2 -> 4
                for(Integer v : adjList[currentV]) { // 1,2 ; 3,4
                    if(visited[v] != true)
                    {
                        queue.add(v); // queue : 1,2 ; 2,3,4
                        visited[v] = true; // [true, true, true, false, false]; [true, true, true, true, true]
                        visitedList.add(v);
                    }
                }
            }
        }

        System.out.println("Breath first visited List --> "+visitedList);
    }
}
