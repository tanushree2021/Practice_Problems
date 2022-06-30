package linkedList;

import java.util.HashSet;

/*
 * 2->3->8->9->3
 */
public class CheckLoop {

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
		n5.next = n2;
		
		boolean isLoop = isLinkedListaLoop(n1);
		System.out.println("Is Loop - "+ isLoop);
	}

	private static boolean isLinkedListaLoop(Node node) {
		HashSet<Node> set = new HashSet<Node>();
        while (node != null) {
            if (set.contains(node))
                return true;
            set.add(node);
            node = node.next;
        }
        return false;
	}

}
