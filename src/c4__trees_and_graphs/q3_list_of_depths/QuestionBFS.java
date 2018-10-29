package c4__trees_and_graphs.q3_list_of_depths;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import c4__trees_and_graphs.q2_minimal_tree.Node;
import util.AssortedMethods;

public class QuestionBFS {
	
	public static List<LinkedList<Node>> getListOfDepths(Node root) {
		List<LinkedList<Node>> result = new ArrayList<>();
		if (root == null)
			return result;
		
		LinkedList<Node> currentLevel = new LinkedList<>();
		currentLevel.add(root);
		
		while(!currentLevel.isEmpty()) {
			result.add(currentLevel);
			// go to the next level
			LinkedList<Node> parents = currentLevel; // storing current level as parents
			currentLevel = new LinkedList<Node>(); // init next level
			for (Node parent : parents) {
				if (parent.left != null)
					currentLevel.add(parent.left);
				if (parent.right != null)
					currentLevel.add(parent.right);
			}
		}
		
		return result;
	}

	public static List<LinkedList<Node>> createLevelLinkedList(Node root) {
		List<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();

		/* "Visit" the root */
		LinkedList<Node> currentLevel = new LinkedList<Node>();
		if (root != null) {
			currentLevel.add(root);
		}

		while (!currentLevel.isEmpty()) {
			result.add(currentLevel); // Save current level
			LinkedList<Node> parents = currentLevel; 
			currentLevel = new LinkedList<Node>(); // Init next level
			for (Node parent : parents) {
				/* Visit the children */
				if (parent.left != null) {
					currentLevel.add(parent.left);
				}
				if (parent.right != null) {
					currentLevel.add(parent.right);
				}
			}
		}

		return result;
	}

	public static void printResult(List<LinkedList<Node>> result) {
		int depth = 0;
		for (LinkedList<Node> entry : result) {
			Iterator<Node> i = entry.listIterator();
			System.out.print("Link list at depth " + depth + ":");
			while (i.hasNext()) {
				System.out.print(" " + ((Node) i.next()).data);
			}
			System.out.println();
			depth++;
		}
	}

	public static void main(String[] args) {
		int[] nodes_flattened = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Node root = AssortedMethods.createTreeFromArray(nodes_flattened);
		List<LinkedList<Node>> list = getListOfDepths(root);
		printResult(list);
	}

}