package c4__trees_and_graphs.q2_minimal_tree;

public class Node {
	
	public int data;
	public Node left;
	public Node right;
	public Node parent;

	public Node(int d) {
		data = d;
	}
	
	
	// util to test
	public void setLeftChild(Node left) {
		this.left = left;
		if (left != null) {
			left.parent = this;
		}
	}
	
	public void setRightChild(Node right) {
		this.right = right;
		if (right != null) {
			right.parent = this;
		}
	}

}