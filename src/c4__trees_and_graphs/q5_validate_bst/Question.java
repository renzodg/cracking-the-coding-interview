package c4__trees_and_graphs.q5_validate_bst;

import c4__trees_and_graphs.q2_minimal_tree.Node;

public class Question {
	public static Integer last_printed = null;

	public static boolean checkBST(Node node) {
		return checkBST(node, true);
	}

	// Allow "equal" value only for left child. This validates the BST property.
	public static boolean checkBST(Node n, boolean isLeft) {
		if (n == null) {
			return true;
		}
		
		// Check / recurse left
		if (!checkBST(n.left, true)) {
			return false;
		}
		
		// Check current
		if (last_printed != null) {
			if (isLeft) {
				// left child "is allowed" be equal to parent.
				if (n.data < last_printed) {
					return false;
				}
			} else {
				// Right child "is not allowed" be equal to parent.
				if (n.data <= last_printed) {
					return false;
				}
			}
		}
		last_printed = n.data;
		
		// Check / recurse right
		if (!checkBST(n.right, false)) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] array = {Integer.MIN_VALUE, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE};
		Node node = c4__trees_and_graphs.q2_minimal_tree.Question.createMinimalBST(array);
		node.left.data = Integer.MAX_VALUE;
		System.out.println(checkBST(node));

	}
}