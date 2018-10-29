package c2__linked_lists;

public class DeleteMiddleNode {

	/*
	 * Implement an algorithm to delete a node in the middle (i.e., any node but the
	 * first and last node, not necessarily the exact middle) of a singly linked
	 * list, given only access to that node.
	 * 
	 * EXAMPLE
	 * 
	 * input:the node c from the linked list a->b->c->d->e->f
	 * 
	 * Result: nothing is returned, but the new linked list looks like a->b->d->e->f
	 */

	public static boolean deleteNode(Node n) {
		if (n == null || n.next == null) {
			return false; // Failure
		}
		Node next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;
	}

	public static void main(String[] args) {

	}
}
