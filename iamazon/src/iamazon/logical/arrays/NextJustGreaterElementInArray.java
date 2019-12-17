package iamazon.logical.arrays;

public class NextJustGreaterElementInArray {
	Node root;

	static class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	public static void main(String[] args) {
		int[] a = { 3, 5, 8, 4, 2, 6, 3 };
		Node tree = initializeBinaryTree(a);
		Node g = getNextJustGreaterElement(tree, 3);
		System.out.println(g.data);
	}

	static Node initializeBinaryTree(int[] a) {
		Node root = new Node(a[0]);
		for (int i = 1; i < a.length; i++) {
			insert(findNode(root, a[i]), a[i]);
		}
		return root;
	}

	static Node findNode(Node node, int a) {
		if (node != null && (node.left != null || node.right != null)) {
			if (a < node.data) {
				if (node.left == null) {
					return node;
				}
				return findNode(node.left, a);
			}

			if (a >= node.data) {
				if (node.right == null) {
					return node;
				}
				return findNode(node.right, a);
			}

		}

		return node;
	}

	static void insert(Node node, int data) {
		if (node != null) {
			if (data < node.data) {
				node.left = new Node(data);
			} else if (data > node.data) {
				node.right = new Node(data);
			}
		}
	}

	static Node getNextJustGreaterElement(Node node, int n) {
		if (node != null && (node.left != null || node.right != null)) {
			if (node.data == n) {
				return node;
			}
			if (n < node.data) {
				if (node.left == null) {
					return node;
				}
				getNextJustGreaterElement(node.left, n);
			}

			if (n >= node.data) {
				if (node.right == null) {
					return node;
				}
				getNextJustGreaterElement(node.left, n);
			}

		}
		return null;
	}

}
