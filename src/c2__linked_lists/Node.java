package c2__linked_lists;

public class Node {

	int data;
	Node next;

	public Node(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		String nextString = next != null ? " -> " + next.toString() : "";
		return data + nextString;
	}
}
