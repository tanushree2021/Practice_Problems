package linkedList;

/*
 * 2 -> 3 -> 1 -> 7 -> 9 -> 5 -> null
 * 
 * delete 1
 * 
 * 2 -> 3 -> 7 -> 9 -> 5 -> null
 */
public class DeleteNodeInALinkedList {

	public static void main(String[] args) {
		Node n1 = new Node(2);
		n1.next = new Node(3);
		n1.next.next = new Node(1);
		n1.next.next.next = new Node(7);
		n1.next.next.next.next = new Node(9);
		n1.next.next.next.next.next = new Node(5);
		
		LinkedListTraversal.travelThroughLinkedList(n1);
		Node newHead = deleteNodeWithKey(n1,1);
		if(newHead!=null) {
			n1=newHead;
		}
		System.out.println();
		LinkedListTraversal.travelThroughLinkedList(n1);
	}

	private static Node deleteNodeWithKey(Node head, int i) {
		if(head == null) {
			return null;
		}
		if(head.info == i)
			return head.next;
		
		if(deleteNodeWithKey(head.next, i)!=null)
			head.next = deleteNodeWithKey(head.next, i);
		
		return null;
	}

}
