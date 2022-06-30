package recursion;

/*
 * Find the length of the linked list
 */
public class FindTheLastNodeInLinkedList {

	public static void main(String[] args) {
		Node n1 = new Node(2);
		Node n2 = new Node(3);
		Node n3 = new Node(1);
		Node n4 = new Node(8);
		Node n5 = new Node(9);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		int length = findLength(n1);
		System.out.println("Length is "+length);
	}

	// 2 -> 3 -> 1 -> 8 -> 9 -> null
	private static int findLength(Node node) {
		if(node.next == null)
			return 1;
		return 1+findLength(node.next);
	}

}
