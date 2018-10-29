package c2__linked_lists;

public class ReturnKthToLast {

	/*
	 * Implement an algorithm to find the kth to last element of a singly linked
	 * list.
	 */

	public static class Index {
		public int value = 0;
	}

	public static Node kthToLast(Node head, int k) {
		Index idx = new Index();
		return kthToLast(head, k, idx);
	}

	public static Node kthToLast(Node head, int k, Index idx) {
		if (head == null) {
			return null;
		}
		Node node = kthToLast(head.next, k, idx);
		idx.value++;
		if (idx.value == k) {
			return head;
		}
		return node;
	}

	public static int printKthToLast(Node head, int k) {
		if (head == null) {
			return 0;
		}
		int index = printKthToLast(head.next, k) + 1;
		if (index == k) {
			System.out.println(k + "th to last node is " + head.data);
		}
		return index;
	}

	/*
	 *  O(n) time and 0(1) space
	 */
	public static Node nthToLast(Node head, int k) {
		Node p1 = head;
		Node p2 = head;

		/* Move p1 k nodes into the list. */
		for (int i = 0; i < k; i++) {
			if (p1 == null)
				return null; // Out of bounds
			p1 = p1.next;
		}

		/*
		 * Move them at the same pace. When p1 hits the end, p2 will be at the right
		 * element.
		 */
		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);

		Node node = nthToLast(head, 2);
		System.out.println(2 + "th to last node is " + node.data);
	}
}
