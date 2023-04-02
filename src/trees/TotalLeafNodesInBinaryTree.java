package trees;

/*
 * count the number of leaf nodes in a given binary tree
 * 
			  1
            /   \
           /     \
          2       3
         / \     / \
        4   5   6   7
               /     \
              8       9
              
 * Pre order - 1,2,4,5,3,6,8,7,9
 */
public class TotalLeafNodesInBinaryTree {

	public static void main(String[] args) {
		Node node = new Node(1);
		TreeUtility.createTree(node);
		int leafCount = getLeafNodes(node);
		System.out.println("Leaf Nodes count "+ leafCount);
		TreeTraversal.preOrderTraverse(node);
	}

	private static int getLeafNodes(Node node) { // 1, 2, 3, 4, 5,6
		if(node == null) {
			return 0;
		}
		if(node.left == null && node.right == null) {
			return 1;	// 4-> 1, 5-> 1
		}
		return getLeafNodes(node.left)+getLeafNodes(node.right); // f(2) + f(3), f(4)+f(5)+f(6)+f(7)
																//	1+1+f(8)+f(null)+f(null)+f(9)
																// 2+1+0+0+1
	}

	

}
