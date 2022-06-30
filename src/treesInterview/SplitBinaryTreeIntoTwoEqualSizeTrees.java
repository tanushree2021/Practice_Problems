package treesInterview;

import java.util.concurrent.atomic.AtomicBoolean;

/*
 * Check if removing an edge can split a binary tree into two equal size trees
 * 
 * Tree 1:
 * 
   	   1			
     /	 \
    2	  3
		 /		
	    4				
	  /	 \
	 5	  6
	
	Tree 2:
	 
 	   1
      /	 \
    2	  3
    	 / \
        4   5
       /
      6

 */
public class SplitBinaryTreeIntoTwoEqualSizeTrees {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(4);
		root.right.left.left = new Node(5);
		root.right.left.right = new Node(6);

		Node root2 = new Node(1);
		root2.left = new Node(2);
		root2.right = new Node(3);
		root2.right.left = new Node(4);
		root2.right.right = new Node(5);
		root2.right.left.left = new Node(6);

		int size = size(root);

		if (size % 2 == 0) {
			System.out.println("Yes size is even...");
		}
		System.out.println("--n2 time complexity : my logic --");
		System.out.println("Tree 1 can be split ? " + (size % 2 == 0 && equalNodesSubtreesExists(root, size / 2)));
		size = size(root2);
		System.out.println("Tree 2 can be split ? " + (size % 2 == 0 && equalNodesSubtreesExists(root2, size / 2)));

		System.out.println("\n--- time complexity is O(n2),---");

		boolean canTreeBeSplit = false;

		size = size(root);
		canTreeBeSplit = size % 2 == 0 && checkSizeOfSubtrees(root, size);
		System.out.println(" Tree 1 can be split ? " + canTreeBeSplit);

		size = size(root2);
		canTreeBeSplit = size % 2 == 0 && checkSizeOfSubtrees(root2, size);
		System.out.println(" Tree 2 can be split ? " + canTreeBeSplit);

		System.out.println("\n O(n) time - postorder traversal on the binary tree...");

		boolean splitTree = splitTree(root);
		System.out.println(" Tree 1 can be split ? " + splitTree);

		splitTree = splitTree(root2);
		System.out.println(" Tree 2 can be split ? " + splitTree);
	}

	private static boolean splitTree(Node root) {
		int n = size(root);

		// check n is even
		if ((n & 1) == 1) {
			return false;
		}
		AtomicBoolean result = new AtomicBoolean();
		checkSize(root, n, result);
		return result.get();

//		boolean result = false;
//		checkSizeNew(root, n, result);
//		return result;
	}

//	private static int checkSizeNew(Node root, int n, boolean result) {
//		if (root == null || result) {
//			return 0;
//		}
//		int size = 1 + checkSizeNew(root.left, n, result) + checkSizeNew(root.right, n, result);
//		if (result==false) {
//			result = (2 * size) == n;
//		}
//		return size;
//	}

	private static int checkSize(Node root, int n, AtomicBoolean result) {
		if (root == null || result.get()) {
			return 0;
		}
//		System.out.println(" root - " + root.data + " - " + result.get());
		int size = 1 + checkSize(root.left, n, result) + checkSize(root.right, n, result);
		if (!result.get()) {
			result.set(2 * size == n);
		}
		return size;
	}

	static boolean checkSizeOfSubtrees(Node node, int size) {
		if (node == null)
			return false;
		if (2 * size(node) == size)
			return true;

		return checkSizeOfSubtrees(node.left, size) || checkSizeOfSubtrees(node.right, size);
	}

	static boolean equalNodesSubtreesExists(Node root, int size) {
		if (root == null) {
			return false;
		}
//		if (root.left == null & root.right == null) {
//			return false;
//		} 
		else {
			if (size(root.left) == size || size(root.right) == size)
				return true;
			return equalNodesSubtreesExists(root.left, size) || equalNodesSubtreesExists(root.right, size);
		}
	}

	static int size(Node n) {
//		if (n == null)
//			return 0;
//		if (n.left == null & n.right == null)
//			return 1;
		return n != null ? 1 + size(n.left) + size(n.right) : 0;
	}

}
