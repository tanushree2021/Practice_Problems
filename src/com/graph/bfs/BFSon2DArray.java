package com.graph.bfs;

import com.graph.GraphUtility;

import java.util.List;

/**
 * Breadth First Traversal ( BFS ) on a 2D array
 *
 * Given a matrix of size M x N consisting of integers, the task is to print the matrix elements using
 * Breadth-First Search traversal.
 *
 * Examples:
 *
 * Input: grid[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}
 * Output: 1 2 5 3 6 9 4 7 10 13 8 11 14 12 15 16
 *
 * Input: grid[][] = {{-1, 0, 0, 1}, {-1, -1, -2, -1}, {-1, -1, -1, -1}, {0, 0, 0, 0}}
 * Output: -1 0 -1 0 -1 -1 1 -2 -1 0 -1 -1 0 -1 0 0
 */
public class BFSon2DArray {
    public static void main(String[] args) {
        int vertices = 4;
        List[] adjList = GraphUtility.initGraphAdjList(vertices);
        int[][] arr2D = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};



    }
}
