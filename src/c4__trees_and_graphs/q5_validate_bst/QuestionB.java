package c4__trees_and_graphs.q5_validate_bst;

import c4__trees_and_graphs.q2_minimal_tree.Node;
import c4__trees_and_graphs.q2_minimal_tree.Question;

public class QuestionB {
	public static boolean checkBST(Node node, int min, int max) {
		if (node == null) {
			return true;
		}
		if (node.data <= min || node.data > max) {
			return false;
		}
		
		return checkBST(node.left, min, node.data) && checkBST(node.right, node.data, max);
	}

	public static boolean checkBST(Node root) {
		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static void main(String[] args) {
		/* Simple test -- create one */
		int[] array = { 1, 3, 5, 6, 10, 13, 15, 25 };
		Node root = Question.createMinimalBST(array);
//		 root.left.data = 6; // "ruin" the BST property by changing one of the
		// elements
		boolean isBST = checkBST(root);
		System.out.println(isBST);

	}
}