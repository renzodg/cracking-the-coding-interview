package c2__linked_lists;

import java.util.Stack;

public class Palindrome {

	/*
	 * Implement a function to check if a linked list is a palindrome.
	 */

	// Solution #1: Reverse and Compare

	public static boolean isPalindrome(Node head) {
		Node reversed = reverseAndClone(head);
		return isEqual(head, reversed);
	}

	private static Node reverseAndClone(Node node) {
		Node head = null;
		while (node != null) {
			Node n = new Node(node.data); // Clone
			n.next = head;
			head = n;
			node = node.next;
		}
		return head;
	}

	private static boolean isEqual(Node one, Node two) {
		while (one != null && two != null) {
			if (one.data != two.data) {
				return false;
			}
			one = one.next;
			two = two.next;
		}
		return one == null && two == null;
	}

	// ------------------------------------------------------------------------------------------------
	// Solution #2: Iterative Approach

	public static boolean isPalindrome2(Node head) {
		Node fast = head;
		Node slow = head;

		Stack<Integer> stack = new Stack<Integer>();

		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}

		/* Has odd number of elements, so skip the middle */
		if (fast != null) {
			slow = slow.next;
		}

		while (slow != null) {
			int top = stack.pop().intValue();
			if (top != slow.data) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(0);
		head.next.next = new Node(2);
		head.next.next.next = new Node(0);
		head.next.next.next.next = new Node(1);

		boolean result = isPalindrome2(head);
		System.out.println(result);
	}

}
