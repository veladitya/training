package iamazon;

import arrays.BinaryTree;
import arrays.Node;

public class LeastCommonFactorBST {

	static int minimumElement;
	static int diff = 100;
	
	public static void main(String[] args) {
		BinaryTree<Integer> bTree = initializeBT();
		inorderTraversal(bTree.root, 4);
		System.out.println(minimumElement);
	}
	
	public static void inorderTraversal(Node<Integer> node, int key) {
		if(node == null) {
			return;
		}
		
		 // If k itself is present 
	    if (node.data == key) 
	    { 
	    	minimumElement = key; 
	        return; 
	    } 
		if(diff >  node.data - key) {
			diff = key - node.data;
			minimumElement = node.data;
		}
		//System.out.println(node.data);
		if(key < node.data)
			inorderTraversal(node.left, key);
		else
			inorderTraversal(node.right, key);		
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
	}
}
