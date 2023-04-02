package recursion;

public class Node {

	Node next;
	int info;

	Node(int value) {
		this.info = value;
		this.next = null;
	}

	@Override
	public String toString() {
		return "Node [info=" + info + "]";
	}

}
