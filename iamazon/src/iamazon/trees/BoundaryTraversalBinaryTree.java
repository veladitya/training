package iamazon.trees;

public class BoundaryTraversalBinaryTree {

	 Node root;
	 
	/* A binary tree node has data, pointer to left child 
	and a pointer to right child */
	static class Node { 
	    int data; 
	    Node left, right; 
	  
	    Node(int item) 
	    { 
	        data = item; 
	        left = right = null; 
	    } 
	} 
	
	
	
	public static void main(String[] args) {
		BoundaryTraversalBinaryTree tree = new BoundaryTraversalBinaryTree(); 
        tree.root = new Node(20); 
        tree.root.left = new Node(8); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(12); 
        tree.root.left.right.left = new Node(10); 
        tree.root.left.right.right = new Node(14); 
        tree.root.right = new Node(22); 
        tree.root.right.right = new Node(25); 
        tree.printBoundary(tree.root); 
	}



	public void printBoundary(Node node) {
		
		if(node == null)
			return;
		System.out.println(node.data);
		printLeftBoundary(node.left);
		printLeaves(node.left.right);
		printRightBoundary(node.right);
	}



	public void printLeaves(Node node) {
		
		if(node == null)
			return;
		
		printLeaves(node.left);
		if(node.left == null && node.right == null) {
			System.out.println(node.data);
		}
		printLeaves(node.right);
	}



	public void printLeftBoundary(Node node) {
		if(node == null)
			return;
		
		System.out.println(node.data);
		printLeftBoundary(node.left);
	}
	
	public void printRightBoundary(Node node) {
		if(node == null)
			return;
		
		printLeftBoundary(node.right);
		System.out.println(node.data);
	}
	

}
