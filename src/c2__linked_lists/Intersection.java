package c2__linked_lists;

public class Intersection {

	/*
	 * Given two (singly) linked lists, determine if the two lists intersect. Return
	 * the intersecting node. Note that the intersection is defined based on
	 * reference, not value. That is, if the kth node of the first linked list is
	 * the exact same node (by reference) as the jth node of the second linked list,
	 * then they are intersecting.
	 */

	public static class Result {
		public Node tail;
		public int size;

		public Result(Node tail, int size) {
			this.tail = tail;
			this.size = size;
		}
	}

	public static Result getTailAndSize(Node list) {
		if (list == null)
			return null;

		int size = 1;
		Node current = list;
		while (current.next != null) {
			size++;
			current = current.next;
		}
		return new Result(current, size);
	}

	public static Node getKthNode(Node head, int k) {
		Node current = head;
		while (k > 0 && current != null) {
			current = current.next;
			k--;
		}
		return current;
	}

	public static Node findIntersection(Node list1, Node list2) {
		if (list1 == null || list2 == null)
			return null;

		/* Get tail and sizes. */
		Result result1 = getTailAndSize(list1);
		Result result2 = getTailAndSize(list2);

		/* If different tail nodes, then there's no intersection. */
		if (result1.tail != result2.tail) {
			return null;
		}

		/* Set pointers to the start of each linked list. */
		Node shorter = result1.size < result2.size ? list1 : list2;
		Node longer = result1.size < result2.size ? list2 : list1;

		/*
		 * Advance the pointer for the longer linked list by the difference in lengths.
		 */
		longer = getKthNode(longer, Math.abs(result1.size - result2.size));

		/* Move both pointers until you have a collision. */
		while (shorter != longer) {
			shorter = shorter.next;
			longer = longer.next;
		}

		/* Return either one. */
		return longer;
	}

	public static void main(String[] args) {
		Node node1 = new Node(3);
		node1.next = new Node(1);
		node1.next.next = new Node(5);
		node1.next.next.next = new Node(9);
		node1.next.next.next.next = new Node(7);
		node1.next.next.next.next.next = new Node(2);
		node1.next.next.next.next.next.next = new Node(1);
		
		Node node2 = new Node(4);
		node2.next = new Node(6);
		node2.next.next = node1.next.next.next.next;
		
		Node intersection = findIntersection(node1, node2);
		System.out.println(intersection);
	}
}
