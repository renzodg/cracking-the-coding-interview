package c4__trees_and_graphs.q4_check_balanced;

import c4__trees_and_graphs.q2_minimal_tree.Node;
import c4__trees_and_graphs.q2_minimal_tree.Question;

public class QuestionBrute {
	
	public static int getHeight(Node root) {
		if (root == null) {
			return -1;
		}
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
		
	public static boolean isBalanced(Node root) {
		if (root == null) {
			return true;
		}
		int heightDiff = getHeight(root.left) - getHeight(root.right);
		if (Math.abs(heightDiff) > 1) {
			return false;
		} else {
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}
	
	public static void main(String[] args) {
		// Create balanced tree
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Node root = Question.createMinimalBST(array);
		System.out.println("Root? " + root.data);
		System.out.println("Is balanced? " + isBalanced(root));
		root.right.right.right.right = new Node(5);
		System.out.println("Is balanced? " + isBalanced(root));
		
	}

}