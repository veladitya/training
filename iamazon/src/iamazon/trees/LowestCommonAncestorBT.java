package iamazon.trees;

import arrays.BinaryTree;
import arrays.Node;

public class LowestCommonAncestorBT {

	public static void main(String[] args) {
		BinaryTree<Integer> tree = initializeBT();

		Node<Integer> ancestorNode = findCommonAncestor(tree.root, 6, 20);
		System.out.println(ancestorNode.data);
	}

	static Node<Integer> findCommonAncestor(Node<Integer> node, int n1, int n2) {
		if (node != null) {
			Node<Integer> tmp = null;
			if (node.data == n1)
				tmp = node;
			if (node.data == n2)
				tmp = node;

			Node<Integer> a1 = findCommonAncestor(node.left, n1, n2);
			Node<Integer> a2 = findCommonAncestor(node.right, n1, n2);

			if (tmp != null)
				return tmp;

			if (a1 != null && a2 != null)
				return node;

			return a1 != null ? a1 : a2;
		}

		return null;
	}

	private static BinaryTree<Integer> initializeBT() {
		BinaryTree<Integer> binaryTree = new BinaryTree<>();
		binaryTree.initialize(9);

		Node<Integer> one = binaryTree.getNode(4);
		Node<Integer> two = binaryTree.getNode(17);

		Node<Integer> three = binaryTree.getNode(3);
		Node<Integer> four = binaryTree.getNode(6);

		Node<Integer> five = binaryTree.getNode(22);

		Node<Integer> four1 = binaryTree.getNode(5);
		Node<Integer> four2 = binaryTree.getNode(7);
		Node<Integer> five1 = binaryTree.getNode(20);

		binaryTree.push(four1, four2, four);
		binaryTree.push(three, four, one);
		binaryTree.push(null, five, two);
		binaryTree.push(five1, null, five);
		binaryTree.push(one, two, binaryTree.root);
		return binaryTree;

		/**
		 * 9 4 17 3 6 22 5 7 20
		 */

	}

}
