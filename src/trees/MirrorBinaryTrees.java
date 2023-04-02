package trees;

/*
 * Create mirror of below tree
 * 		 1
 * 		/ \
 * 	   3   2
 * 		  / \
 * 		 5   4
 * 
 * Pre order - 1,3,2,5,4
 * 
 * Mirror result
 * 		 1
 * 		/ \
 * 	   2   3
 * 	  / \
 * 	 4	 5 
 * 
 * Pre order - 1,2,4,5,3
 */
public class MirrorBinaryTrees {

	public static void main(String[] args) {
		Node treeNode = new Node(1);

		TreeUtility.createBTreeOfHeight2(treeNode);
//		TreeUtility.createTree(treeNode);
		TreeTraversal.preOrderTraverse(treeNode);

		System.out.println("Mirror Tree Creation..");

//		Node mirrorTreeNode = createMirrorBT(treeNode);
		Node mirrorTreeNode = createMirror(treeNode);

		TreeTraversal.preOrderTraverse(mirrorTreeNode);
	}

	private static Node createMirror(Node treeNode) {
		if (treeNode == null)
			return treeNode;
		Node rightNode = createMirrorBT(treeNode.right);
		Node leftNode = createMirrorBT(treeNode.left);
		treeNode.right = leftNode;
		treeNode.left = rightNode;
		return treeNode;
	}

	private static Node createMirrorBT(Node treeNode) {
		if (treeNode == null)
			return treeNode;
		else if (treeNode.left != null && treeNode.right == null) {
			createMirrorBT(treeNode.left);
			treeNode.right = treeNode.left;
			treeNode.left = null;
		} else if (treeNode.right != null && treeNode.left == null) {
			createMirrorBT(treeNode.right);
			treeNode.left = treeNode.right;
			treeNode.left = null;
		} else {
			Node treeNodeRight = createMirrorBT(treeNode.right);
			Node treeNodeLeft = createMirrorBT(treeNode.left);
			treeNode.right = treeNodeLeft;
			treeNode.left = treeNodeRight;
			return treeNode;
		}
		return treeNode;
	}

}
