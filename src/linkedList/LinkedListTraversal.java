package linkedList;

public class LinkedListTraversal {

	public static void main(String[] args) {
		Node n1 = new Node(2);
		n1.next = new Node(3);
		n1.next.next = new Node(1);
		n1.next.next.next = new Node(8);
		n1.next.next.next.next = new Node(9);
		
		travelThroughLinkedList(n1);
	}

	public static Node travelThroughLinkedList(Node node) {
		if(node == null) {
			System.out.print("null");
			return null;
		}
		System.out.print(node.info+" -> ");
		return travelThroughLinkedList(node.next);
	}

}
