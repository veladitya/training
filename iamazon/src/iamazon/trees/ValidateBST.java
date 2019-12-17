package iamazon.trees;

import arrays.BinaryTree;
import arrays.Node;

public class ValidateBST {

	public static void main(String[] args) {
		BinaryTree<Integer> bTree = initializeBT();
	
		int min = 0;
		int max = 94;

		System.out.println(isBST(bTree.root, min, max));
	}

	private static boolean isBST(Node<Integer> root, int min, int max) {
		
		return isBSTUtil(root, min, max);
	}

	public static boolean isBSTUtil(Node<Integer> node, int min, int max) {
		
		/* an empty tree is BST */
        if (node == null) 
            return true; 
        System.out.println("Min Value ["+min+"], Max Value ["+max+"], Node Value: ["+node.data+"]");
        
		if (node.data < min || node.data > max) {
			return false;
		}
		
		return (isBSTUtil(node.left, min, node.data-1) && 
                isBSTUtil(node.right, node.data+1, max));
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

		Node<Integer> five2 = binaryTree.getNode(94);

		binaryTree.push(four1, four2, four);
		binaryTree.push(three, four, one);
		binaryTree.push(five2, five, two);
		binaryTree.push(five1, null, five);
		binaryTree.push(one, two, binaryTree.root);
		return binaryTree;
	}

	/**
	 * 9
	 * 
	 * 4 | 17
	 * 
	 * 3 | 6 | | 22
	 * 
	 * 5 | 7 | 20 |
	 */
}
