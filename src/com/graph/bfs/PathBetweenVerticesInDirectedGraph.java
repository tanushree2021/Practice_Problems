package com.graph.bfs;

import com.graph.GraphUtility;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Find if there is a path between two vertices in a directed graph

Either Breadth First Search (BFS) or Depth First Search (DFS) can be used to find path between two vertices.

 */
public class PathBetweenVerticesInDirectedGraph {

    /*
    0 --> [1,2]
    1 --> [2]
    2 --> [0,3]
    3 --> [3]

Input : (u, v) = (1, 3)
Output: Yes
Explanation: There is a path from 1 to 3, 1 -> 2 -> 3

Input : (u, v) = (3, 6)
Output: No
Explanation: There is no path from 3 to 6
     */
    public static void main(String[] args) {
        int vertices = 4;
        List<Integer>[] adjListArray = GraphUtility.initGraphAdjList(vertices);
        GraphUtility.addEdge(0, 1, adjListArray);
        GraphUtility.addEdge(0, 2, adjListArray);
        GraphUtility.addEdge(1, 2, adjListArray);
        GraphUtility.addEdge(2, 0, adjListArray);
        GraphUtility.addEdge(2, 3, adjListArray);
        GraphUtility.addEdge(3, 3, adjListArray);

        int u , v;
        u = 1; v=3;
        pathExistsMyLogic(adjListArray, u, v);
        pathExistsGeeksForGeeks(adjListArray, u, v);

        u = 3; v=6;

        pathExistsMyLogic(adjListArray, u, v);
        pathExistsGeeksForGeeks(adjListArray, u, v);
    }

    private static void pathExistsGeeksForGeeks(List<Integer>[] adjListArray, int u, int v) {
        if(pathExists(adjListArray, u, v)){
            System.out.println("Path exists between u="+ u +" and v="+ v);
        } else {
            System.out.println("Path does not exists between u="+ u +" and v="+ v);
        }
        System.out.println("------------------------");
    }

    private static void pathExistsMyLogic(List<Integer>[] adjListArray, int u, int v) {
        boolean pathExists = doesPathExistsBetweenTwoVertices(adjListArray, u, v);
        System.out.println("Path exists between u="+ u +" , v="+ v +" ? "+pathExists);
        System.out.println("=======================");
    }

    private static boolean pathExists (List<Integer>[] adjListArray, int u, int v) {
        boolean pathExists = false;
        int vertices = adjListArray.length;
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[u] = true;
        queue.add(u);
        while (!queue.isEmpty()) {
          int currNode = queue.poll();
          for(int neighbour : adjListArray[currNode]) {
              if(neighbour == v)
                  return true;
              if(!visited[neighbour]) {
                  visited[neighbour] = true;
                  queue.add(neighbour);
              }
          }
        }
        return pathExists;
    }

    private static boolean doesPathExistsBetweenTwoVertices(List<Integer>[] adjListArray, int u, int v) {

        int vertices = adjListArray.length;
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> pathOfVertices = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        boolean first = false;
        boolean last = false;
        while(!queue.isEmpty()) {
            int currentVertex = queue.poll();
            if(currentVertex == u) {
                first = true;
            }
            if(currentVertex == v) {
                last=true;
                break;
            }
            for(Integer neighbour: adjListArray[currentVertex]) {
                if(!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }

        return (first && last);
    }
}
