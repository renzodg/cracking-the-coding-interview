package c4__trees_and_graphs.q6_successor;

import c4__trees_and_graphs.q2_minimal_tree.Node;

public class Question {

	public static Node inorderSucc(Node n) { 
		if (n == null) return null;
		
		// Found right children -> return left most node of right subtree
		if (n.parent == null || n.right != null) { 
			return leftMostChild(n.right); 
		}
		
		Node q = n;
		Node x = q.parent;
		// Go up until we're on left instead of right
		while (x != null && x.left != q) {
			q = x;
			x = x.parent;
		}
		return x;
	} 
		
	public static Node leftMostChild(Node n) {
		if (n == null) {
			return null;
		}
		while (n.left != null) {
			n = n.left; 
		}
		return n; 
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Node root = createMinimalBST(array);
		for (int i = 0; i < array.length; i++) {
			Node node = find(root, array[i]);
			Node next = inorderSucc(node);
			if (next != null) {
				System.out.println(node.data + " -> " + next.data);
			} else {
				System.out.println(node.data + " -> " + null);
			}
		}
	}
	
	// util to test
	
	public static Node find(Node node, int d) {
		if (d == node.data) {
			return node;
		} else if (d <= node.data) {
			return node.left != null ? find(node.left, d) : null;
		} else if (d > node.data) {
			return node.right != null ? find(node.right, d) : null;
		}
		return null;
	}
	
	private static Node createMinimalBST(int arr[], int start, int end){
		if (end < start) {
			return null;
		}
		int mid = (start + end) / 2;
		Node n = new Node(arr[mid]);
		n.setLeftChild(createMinimalBST(arr, start, mid - 1));
		n.setRightChild(createMinimalBST(arr, mid + 1, end));
		return n;
	}
	
	public static Node createMinimalBST(int array[]) {
		return createMinimalBST(array, 0, array.length - 1);
	}

}