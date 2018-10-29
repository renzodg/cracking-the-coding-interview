package c2__linked_lists;

public class LoopDetection {

	/*
	 * Given a circular linked list, implement an algorithm that returns the node at
	 * the beginning of the loop.
	 * 
	 * DEFINITION Circular linked list: A (corrupt) linked list in which a node's
	 * next pointer points to an earlier node, so as to make a loop in the linked
	 * list.
	 * 
	 * EXAMPLE
	 * 
	 * Input: A -> B -> C - > D -> E -> C [the same C as earlier]
	 * 
	 * Output: C
	 */

	public static Node FindBeginningLoop(Node head) {
		Node slow = head;
		Node fast = head;

		// Find meeting point
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}

		// Error check - there is no meeting point, and therefore no loop
		if (fast == null || fast.next == null) {
			return null;
		}

		/*
		 * Move slow to Head. Keep fast at Meeting Point. Each are k steps from the Loop
		 * Start. If they move at the same pace, they must meet at Loop Start.
		 */
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		// Both now point to the start of the loop.
		return fast;
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = head.next.next;
		
		Node beginningLoop = FindBeginningLoop(head);
		System.out.println(beginningLoop.data);
	}
}
