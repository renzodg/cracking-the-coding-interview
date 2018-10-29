package c4__trees_and_graphs.q2_minimal_tree;

public class Question {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		// We needed this code for other files, so check out the code in the library
		Node root = createMinimalBST(array);
		System.out.println("Root? -> " + root.data);
		System.out.println("Created BST? -> " + isBST(root));
		System.out.println("Height: " + getHeight(root));
	}

	public static boolean isBST(Node node) {
		if (node.left != null) {
			if (node.data < node.left.data || !isBST(node.left)) {
				return false;
			}
		}

		if (node.right != null) {
			if (node.data >= node.right.data || !isBST(node.right)) {
				return false;
			}
		}

		return true;
	}

	private static Node createMinimalBST(int arr[], int start, int end) {
		if (end < start) {
			return null;
		}
		int mid = (start + end) / 2;
		Node n = new Node(arr[mid]);
		n.left = createMinimalBST(arr, start, mid - 1);
		n.right = createMinimalBST(arr, mid + 1, end);
		return n;
	}

	public static Node createMinimalBST(int array[]) {
		return createMinimalBST(array, 0, array.length - 1);
	}

	public static int getHeight(Node node) {
		int leftHeight = 0;
		int rightHeight = 0;
		
		if (node.left != null)
			leftHeight = getHeight(node.left);
		
		if (node.right != null)
			rightHeight = getHeight(node.right);
		
		return 1 + Math.max(leftHeight, rightHeight);
	}

}