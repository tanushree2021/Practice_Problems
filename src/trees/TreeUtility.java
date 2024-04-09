package trees;

/*
 * createTree creates below tree -
 * 
 * 			  1
            /   \
           /     \
          2       3
         / \     / \
        4   5   6   7
               /     \
              8       9
              
  * Pre order - 1,2,4,5,3,6,8,7,9
  * 
  * Mirror Pre Order
  * 
  * 	1,3,7,9,6,8,2,5,4
  *		
  *			  1
            /   \
           /     \
          3       2
         / \     / \
        7   6   5   4
       /     \
      9		  8
 */
public class TreeUtility {

	public static void createTree(Node node) {
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		Node n9 = new Node(9);

		n2.left = n4;
		n2.right = n5;
		node.left = n2;

		n6.left = n8;
		n7.right = n9;

		n3.left = n6;
		n3.right = n7;
		node.right = n3;
	}

	/*
	 * 		1
	 * 	   / \
	 * 	  3   2
	 * 		 / \
	 * 		5   4
	 * 
	 * 1,3,2,5,4
	 */
	public static void createBTreeOfHeight2(Node node) {
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		node.left = n3;
		node.right = n2;

		n2.left = n5;
		n2.right = n4;
	}
	
	public static void createNotFull_NotComplete_BTreeOfHeight2(Node node) {
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n5 = new Node(5);
		node.left = n3;
		node.right = n2;

		n2.left = n5;
	}
	
	public static void createNotFull_ButComplete_BTreeOfHeight2(Node node) {
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n5 = new Node(5);
		node.left = n2;
		node.right = n3;

		n2.left = n5;
	}
	
	public static void createFull_ButNotComplete_BTreeOfHeight2(Node node) {
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		node.left = n2;
		node.right = n3;

		n3.left = n4;
		n3.right = n5;
	}

	public static Node createRandomBTWithGivenHeight(Node node, int height) {
		if (height == 0) {
			return node;
		}
		height--;
		node.left = new Node((int) (Math.random() * 10));

		node.right = new Node((int) (Math.random() * 10));

		createRandomBTWithGivenHeight(node.left, height);
		createRandomBTWithGivenHeight(node.right, height);
		return node;
	}
}
