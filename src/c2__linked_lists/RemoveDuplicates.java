package c2__linked_lists;

import java.util.HashSet;

public class RemoveDuplicates {

	/*
	 * Write code to remove duplicates from an unsorted linked list.
	 * 
	 * FOLLOW UP: How would you solve this problem if a temporary buffer is not
	 * allowed?
	 * 
	 */

	/*
	 * O(n) time, O(d) space where d are the amount of distinct numbers
	 */
	public static void deleteDuplicates(Node node) {
		HashSet<Integer> distinctData = new HashSet<Integer>();

		Node previous = null;
		while (node != null) {
			if (distinctData.contains(node.data)) {
				previous.next = node.next;
			} else {
				distinctData.add(node.data);
				previous = node;
			}

			node = node.next;
		}
	}
	
	/*
	 * O(n^2) time, O(1) space
	 */
	public static void deleteDuplicates2(Node head) {
		Node current = head;
		while (current != null) {
			/* Remove all future nodes that have the same value */
			Node runner = current;
			while (runner.next != null) {
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(1);
		head.next.next.next.next = new Node(3);

		System.out.println(head);
		deleteDuplicates2(head);
		System.out.println(head);
	}
}
