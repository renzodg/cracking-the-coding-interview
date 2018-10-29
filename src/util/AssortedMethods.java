package util;

import c4__trees_and_graphs.q2_minimal_tree.Node;

public class AssortedMethods {
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}

	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}

	public static boolean randomBoolean() {
		return randomIntInRange(0, 1) == 0;
	}

	public static boolean randomBoolean(int percentTrue) {
		return randomIntInRange(1, 100) <= percentTrue;
	}

	public static Node createTreeFromArray(int[] array) {
		if (array.length > 0) {
			Node root = new Node(array[0]);
			java.util.Queue<Node> queue = new java.util.LinkedList<Node>();
			queue.add(root);
			boolean done = false;
			int i = 1;
			while (!done) {
				Node r = (Node) queue.element();
				if (r.left == null) {
					r.left = new Node(array[i]);
					i++;
					queue.add(r.left);
				} else if (r.right == null) {
					r.right = new Node(array[i]);
					i++;
					queue.add(r.right);
				} else {
					queue.remove();
				}
				if (i == array.length) {
					done = true;
				}
			}
			return root;
		} else {
			return null;
		}
	}

}