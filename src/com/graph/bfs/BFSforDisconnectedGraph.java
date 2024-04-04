package com.graph.bfs;

import com.graph.GraphUtility;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 *      0
 *    /   \
 *  dwn   dwn
 *   1 --> 2        5
 *    \           up  \
 *     dwn       /    dwn
 *     3        4 ---> 6
 *
 *  As in the above graph vertex 1 is unreachable from all vertex, so simple BFS wouldn’t work for it.
 *  Just to modify BFS, perform simple BFS from each unvisited vertex of given graph.
 *
 *      0   1   2   3   4   5   6
 * 0    0   1   1   0   inf inf inf
 * 1    0   0   1   1   inf inf inf
 * 2    0   0   0   0   inf inf inf
 * 3    0   0   0   0   inf inf inf
 * 4   inf  inf inf inf 0   1   1
 * 5   inf  inf inf inf 0   0   1
 * 6   inf  inf inf inf 0   0   0
 *
 */
public class BFSforDisconnectedGraph {

    public static void main(String[] args) {
        int vertices = 7;
        List<Integer>[] adjListArray = GraphUtility.initGraphAdjList(vertices);
        GraphUtility.addEdge(0,1,adjListArray);
        GraphUtility.addEdge(0,2,adjListArray);
        GraphUtility.addEdge(1,2,adjListArray);
        GraphUtility.addEdge(1,3,adjListArray);
        GraphUtility.addEdge(4,5,adjListArray);
        GraphUtility.addEdge(4,6,adjListArray);
        GraphUtility.addEdge(5,6,adjListArray);

        GraphUtility.printGraph(adjListArray, vertices);

        BFS(adjListArray, vertices);
    }

    private static void BFS(List<Integer>[] adjListArray,int vertices) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        System.out.println("BFS: ");
        for (int i = 0; i <vertices ; i++) {
            if(!visited[i]) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    Integer currentNode = queue.poll();
                    System.out.println(currentNode +" ");
                    if(!visited[currentNode]) {
                        visited[currentNode]= true;
                        for(Integer neighbour : adjListArray[currentNode]) {
                            if(!visited[neighbour]) {
                                visited[neighbour] = true;
                                queue.add(neighbour);
                            }
                        }
                    }
                }
            }
        }
    }
}
