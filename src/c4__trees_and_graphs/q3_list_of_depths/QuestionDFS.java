package c4__trees_and_graphs.q3_list_of_depths;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import c4__trees_and_graphs.q2_minimal_tree.Node;
import util.AssortedMethods;

public class QuestionDFS {

	public static void createLevelLinkedList(Node node, ArrayList<LinkedList<Node>> lists, int level) {
		if (node == null)
			return;
		
		LinkedList<Node> list = null;
		if (lists.size() == level) { // Level not contained in list
			list = new LinkedList<Node>();
			/*
			 * Levels are always traversed in order. So, if this is the first time we've
			 * visited level i, we must have seen levels 0 through i - 1. We can therefore
			 * safely add the level at the end.
			 */
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		
		list.add(node);
		
		createLevelLinkedList(node.left, lists, level + 1);
		createLevelLinkedList(node.right, lists, level + 1);
	}

	public static ArrayList<LinkedList<Node>> createLevelLinkedList(Node root) {
		ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();
		createLevelLinkedList(root, lists, 0);
		return lists;
	}

	public static void printResult(ArrayList<LinkedList<Node>> result) {
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
		ArrayList<LinkedList<Node>> list = createLevelLinkedList(root);
		printResult(list);
	}

}