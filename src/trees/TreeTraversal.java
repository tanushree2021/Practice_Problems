package trees;

/*
 * Traversal in a given binary tree
 * 
			  1
            /   \
           /     \
          2       3
         / \     / \
        4   5   6   7
               /     \
              8       9
 */
public class TreeTraversal {

	public static void main(String[] args) {
		Node node = new Node(1);
		TreeUtility.createTree(node);

		// PreOrder - Root, Left, Right
		System.out.println("PreOrder Traversal - ");
		preOrderTraverse(node);
		System.out.println();
		System.out.println("In Order Traversal - ");
		InOrderTraverse(node);
		System.out.println();
		System.out.println("Post Order Traversal - ");
		postOrderTraverse(node);

	}

	public static void postOrderTraverse(Node node) {
		if( node == null)
			return;
		postOrderTraverse(node.left);
		postOrderTraverse(node.right);
		System.out.print(node.data+" ");
	}

	public static void InOrderTraverse(Node node) {
		if(node == null)
			return;
		
		InOrderTraverse(node.left);
		System.out.print(node.data+" ");
		InOrderTraverse(node.right);
		
	}

	public static void preOrderTraverse(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data+" ");
		preOrderTraverse(node.left);
		preOrderTraverse(node.right);
	}

}
