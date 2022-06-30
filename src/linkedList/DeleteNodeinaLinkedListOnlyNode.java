package linkedList;

public class DeleteNodeinaLinkedListOnlyNode {

	public static void main(String[] args) {
		Node n1 = new Node(2);
		n1.next = new Node(3);
		n1.next.next = new Node(1);
		n1.next.next.next = new Node(7);
		n1.next.next.next.next = new Node(9);
		n1.next.next.next.next.next = new Node(5);

		LinkedListTraversal.travelThroughLinkedList(n1);
		deleteNodeWithKey(n1.next.next);
		System.out.println();
		LinkedListTraversal.travelThroughLinkedList(n1);
	}

	// 2 -> 3 -> 1 -> 7 -> 9 -> 5
	private static void deleteNodeWithKey(Node node) { // Node(1)
		node.info = node.next.info;
		node.next = node.next.next;
	}

}
