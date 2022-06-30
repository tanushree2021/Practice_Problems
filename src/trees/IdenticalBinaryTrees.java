package trees;

public class IdenticalBinaryTrees {

	public static void main(String[] args) {
		Node t1 = new Node(1);
		t1 = TreeUtility.createBinaryTree(t1, 2);
		Node t2 = new Node(1);
		t2 = TreeUtility.createBinaryTree(t2, 2);
		System.out.println("Traversals--");
		TreeTraversal.preOrderTraverse(t1);
		System.out.println();
		TreeTraversal.preOrderTraverse(t2);

		// TreeUtility.createBTree1(t1);

		System.out.println("\nAre trees Identical - " + treeIdentical(t1, t2));
	}

	public static boolean treeIdentical(Node node1, Node node2) {
		if (node1 == node2 && node2 == null) {
			return true;
		}
		if (node1 != null && node2 != null && node1.data == node2.data) {
			if (treeIdentical(node1.left, node2.left) && treeIdentical(node1.right, node2.right)) {
				return true;
			}
		}
		return false;
	}

}
