package iamazon.trees;

import arrays.BinaryTree;
import arrays.Node;

public class ClosestAnsestorBST {


	public static void main(String[] args) {
		BinaryTree<Integer> bTree = initializeBT();
		Node<Integer> node = inorderTraversal(bTree.root, 6, 20);
		System.out.println(node.data);
	}

	public static Node<Integer> inorderTraversal(Node<Integer> node, int n1, int n2) {
		if (node == null) {
			return null;
		}
		
		if(n1 < node.data && n2 < node.data)
			return inorderTraversal(node.left, n1, n2);

		if(n1 > node.data && n2 > node.data)
			return  inorderTraversal(node.right, n1, n2);
		
		return node;
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
		 * 				9
		 * 			4			17
		 * 		3      6       		22
		 * 			5    7  	20
		 */
		
	}
}
