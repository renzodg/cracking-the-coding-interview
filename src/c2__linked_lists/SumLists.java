package c2__linked_lists;

public class SumLists {

	/*
	 * You have two numbers represented by a linked list, where each node contains a
	 * single digit. The digits are stored in reverse order, such that the 1 's
	 * digit is at the head of the list. Write a function that adds the two numbers
	 * and returns the sum as a linked list.
	 * 
	 * EXAMPLE
	 * 
	 * Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is, 617 + 295.
	 * 
	 * Output: 2 -> 1 -> 9. That is, 912.
	 */
	public static Node addLists(Node l1, Node l2) {
		return addLists(l1, l2, 0);
	}

	private static Node addLists(Node n1, Node n2, int carry) {
		if (n1 == null && n2 == null && carry == 0) {
			return null;
		}

		int sum = carry;
		if (n1 != null) {
			sum += n1.data;
		}
		if (n2 != null) {
			sum += n2.data;
		}

		Node result = new Node(sum % 10);
		if (n1 != null || n2 != null) {
			Node more = addLists(n1 == null ? null : n1.next, n2 == null ? null : n2.next, sum >= 10 ? 1 : 0);
			result.next = more;
		}
		return result;
	}

	public static Node addListsIterative(Node n1, Node n2) {
		Node result = null;
		Node current = null;
		int carry = 0;
		while (n1 != null || n2 != null) {
			int sum = carry;
			if (n1 != null)
				sum += n1.data;
			if (n2 != null)
				sum += n2.data;

			carry = sum >= 10 ? 1 : 0;

			if (n1 != null)
				n1 = n1.next;
			if (n2 != null)
				n2 = n2.next;

			if (result == null) {
				result = new Node(sum % 10);
				current = result;
			} else {
				current.next = new Node(sum % 10);
				current = current.next;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Node head1 = new Node(7);
		head1.next = new Node(1);
		head1.next.next = new Node(6);

		Node head2 = new Node(5);
		head2.next = new Node(9);

		Node result = addListsIterative(head1, head2);

		System.out.println(result);
	}
}
