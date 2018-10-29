package c4__trees_and_graphs.q4_check_balanced;

import c4__trees_and_graphs.q2_minimal_tree.Node;
import c4__trees_and_graphs.q2_minimal_tree.Question;

public class QuestionImproved {
		
	public static int checkHeight(Node root) {
		if (root == null) {
			return -1;
		}
		int leftHeight = checkHeight(root.left);
		if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Propagate error up
		
		int rightHeight = checkHeight(root.right);
		if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Propagate error up
		
		int heightDiff = leftHeight - rightHeight;
		if (Math.abs(heightDiff) > 1) {
			return Integer.MIN_VALUE; // Found error -> pass it back
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
	
	public static boolean isBalanced(Node root) {
		return checkHeight(root) != Integer.MIN_VALUE;
	}
	
	public static void main(String[] args) {
		// Create balanced tree
		int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
		Node root = Question.createMinimalBST(array);

		
		System.out.println("Is balanced? " + isBalanced(root));
		
		root.right.right.right.right = new Node(5);
		root.right.right.right.right.right = new Node(6);

		System.out.println("Is balanced? " + isBalanced(root));
	}

}