package linkedList;

public class CheckTwoLinkedListEqual {

	public static void main(String[] args) {
		Node n1 = new Node(2);
		n1.next = new Node(3);
		n1.next.next = new Node(1);
		n1.next.next.next = new Node(7);
		n1.next.next.next.next = new Node(9);
		n1.next.next.next.next.next = new Node(5);
		
		Node n2 = new Node(2);
		n2.next = new Node(3);
		n2.next.next = new Node(1);
		n2.next.next.next = new Node(8);
		n2.next.next.next.next = new Node(9);
		n2.next.next.next.next.next = new Node(5);
		System.out.println("Linked Lists equal - "+areLinkedListsEqual(n1,n2));

	}

	private static boolean areLinkedListsEqual(Node n1, Node n2) {
		if(n1==n2 && n1==null) {
			return true;
		}
		if(n1!= null && n2!=null && n1.info==n2.info) {
			return areLinkedListsEqual(n1.next, n2.next);
		}	
		return false;
	}

}
