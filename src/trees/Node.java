package trees;

public class Node {

	int data;
	Node left;
	Node right;
	
	Node(int value)
    {
     this.data = value;
     this.left = null;
     this.right = null;
    }

	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
	}
}
