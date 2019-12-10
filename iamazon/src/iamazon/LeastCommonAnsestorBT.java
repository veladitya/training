package iamazon;

public class LeastCommonAnsestorBT {

	static Node root;

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int a) {
			this.data = a;
			this.left = this.right = null;
		}
	}

	static Node findLCAUtil(Node node, int n1, int n2) {

		if (node == null)
			return null;

		Node tmp = null;

		if (node.data == n1)
			tmp = node;
		if (node.data == n2)
			tmp = node;
		Node leftNode = findLCAUtil(node.left, n1, n2);
		Node rightNode = findLCAUtil(node.right, n1, n2);

		if (tmp != null)
			return tmp;

		if (leftNode != null && rightNode != null)
			return node;

		return leftNode != null ? leftNode : rightNode;
	}

	static void findLCA(int n1, int n2) {

		Node n = findLCAUtil(root, n1, n2);

		System.out.println(n.data);
	}

	public static void main(String[] args) {
		LeastCommonAnsestorBT tree = new LeastCommonAnsestorBT();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);

		findLCA(7, 16);
	}
}
