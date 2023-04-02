package trees;

/*
 *
 * 		5
 * 	   / \
 * 	  3   8
 *	 	 / \
 * 		7   9
 * 	   /
 * 	  6
 */
public class DeleteNodeWithKey {

	public static void main(String[] args) {

		Node root1 = new Node(5);
		root1.left = new Node(3);
		root1.right = new Node(8);
		root1.right.left = new Node(7);
		root1.right.right = new Node(9);
		root1.right.left.left = new Node(6);

		TreeTraversal.InOrderTraverse(root1);
//        AtomicBoolean result = new AtomicBoolean();
//		deleteNode(root1, 6); // Case 1: Given node is a Leaf Node, Eg 3,6,9
//        deleteNode(root1, 7); // Case 2: Node to be deleted has only one child
        deleteNode(root1, 8); // Case 3: Node to be deleted has two children
//        deleteNode(root1, 5); // Case 3 : -do-
		System.out.println();
		TreeTraversal.InOrderTraverse(root1);
//		System.out.println("\n" + findInorderSuccessor(root1.right));
	}

	private static Node deleteNode(Node root, int i) {
		if (root == null) {
			return null;
		}
		if (i < root.data) {
			root.left = deleteNode(root.left, i);
		} else if (i > root.data) {
			root.right = deleteNode(root.right, i);
		} else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
			
			root.data = findInorderSuccessor(root.right);
			root.right = deleteNode(root.right, root.data);
		}
		return root;
	}

	private static int findInorderSuccessor(Node node) {
		int minVal = node.data;
		while(node.left!=null) {
			if(node.left.data < minVal)
				minVal = node.left.data;
			node = node.left;
		}
		return minVal;
//		if (node.left == node.right && node.left == null) {
//			return node.data;
//		} else if (node.left != null) {
//			return findInorderSuccessor(node.left);
//		} else {
//			return node.data;
//		}
	}
}