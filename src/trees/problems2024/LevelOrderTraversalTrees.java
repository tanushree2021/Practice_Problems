package trees.problems2024;

import trees.Node;
import trees.TreeHeight;
import trees.TreeUtility;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/level-order-tree-traversal/
 *
 * Level Order Traversal (Breadth First Search or BFS) of Binary Tree
 * Level Order Traversal technique is defined as a method to traverse a Tree such that all nodes present
 * in the same level are traversed completely before traversing the next level.
 *
 * Two ways:
 * 1. the naive one (finding the height of the tree and traversing each level and printing the nodes of that level)
 * 2. efficiently using a queue.
 */
public class LevelOrderTraversalTrees {
    /**
                1
              /  \
             2    3
            / \
           4   5
     * @param args
     */
    public static void main(String[] args) {
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);

        System.out.println("Level order traversal of binary tree is ");

        traverselevelOrderUsingHeight(tree);

        System.out.println("\n========================");

        /*
                1
              /  \
             2    3
            / \    \
           4   5    6
         */
        Node tree2 = new Node(1);
        tree2.left = new Node(2);
        tree2.right = new Node(3);
        tree2.left.left = new Node(4);
        tree2.left.right = new Node(5);
        tree2.right.right = new Node(6);

        traverselevelOrderUsingHeight(tree2);
        System.out.println("\n========================");
        /*
        We need to visit the nodes in a lower level before any node in a higher level.
        Push the nodes of a lower level in the queue.
        When any node is visited, pop that node from the queue and push the child of that node in the queue.
         */
        efficientLevelOrderTraversal(tree);
        System.out.println("\n========================");
        efficientLevelOrderTraversal(tree2);
        System.out.println("\n========================");
        Node tree3 = new Node(1);
        TreeUtility.createTree(tree3);
        efficientLevelOrderTraversal(tree3);
    }

    /*
    Time Complexity: O(N) where N is the number of nodes in the binary tree.
    Auxiliary Space: O(N) where N is the number of nodes in the binary tree.
     */
    private static void efficientLevelOrderTraversal(Node tree) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) { // 1 ; 2,3 ; 3,4,5
            Node currNode = queue.poll(); // 1 ; 2 ; 3
            System.out.print(currNode.data+" ");
            if(currNode.left != null) queue.add(currNode.left); // 2 ; 4
            if(currNode.right != null) queue.add(currNode.right); // 3 ; 5 ; 6
        }
    }

    /*
Time Complexity: O(N), where N is the number of nodes in the skewed tree.
Auxiliary Space: O(1) If the recursion stack is considered the space used is O(N).
     */
    private static void traverselevelOrderUsingHeight(Node tree) {
        int height = TreeHeight.findTreeHeight(tree);
        for(int i = 0; i< height ; i++) {
            printCurrentLevelNode(tree, i);
        }
    }

    private static void printCurrentLevelNode(Node tree, int level) {
        if(tree == null)
            return;
        if(level == 0) {
            System.out.print(tree.data +" ");
        }
        else {
            printCurrentLevelNode(tree.left, level-1);
            printCurrentLevelNode(tree.right, level-1);
        }
    }
}
