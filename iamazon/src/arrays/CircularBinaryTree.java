package arrays;

public class CircularBinaryTree {

	public static void main(String[] args) {
		BinaryTree<Integer> binaryTree = initializeBT();	
		
		CircularBinaryTree circularBinaryTree = new CircularBinaryTree();
		//circularBinaryTree.print(binaryTree.root);
		circularBinaryTree.bTreeToCList(binaryTree.root);
		
	}
    
	// Method converts a tree to a circular 
    // Link List and then returns the head 
    // of the Link List 
    public Node bTreeToCList(Node root) 
    { 
        if (root == null) 
            return null; 
        System.out.println(root.data);
        // Recursively convert left and right subtrees
        System.out.println("Left Tree");
        Node left = bTreeToCList(root.left);
        System.out.println("Rigth Tree");
        Node right = bTreeToCList(root.right); 
  
        // Make a circular linked list of single node 
        // (or root). To do so, make the right and 
        // left pointers of this node point to itself 
        root.left = root.right = root; 
  
        // Step 1 (concatenate the left list with the list  
        //         with single node, i.e., current node) 
        // Step 2 (concatenate the returned list with the 
        //         right List) 
        return concatenate(concatenate(left, root), right); 
    } 

    public Node concatenate(Node leftList,Node rightList) 
    { 
        // If either of the list is empty, then 
        // return the other list 
        if (leftList == null) 
            return rightList; 
        if (rightList == null) 
            return leftList; 
  
        // Store the last Node of left List 
        Node leftLast = leftList.left; 
        
        // Store the last Node of right List 
        Node rightLast = rightList.left; 
  
        // Connect the last node of Left List 
        // with the first Node of the right List 
        leftLast.right = rightList; 
        rightList.left = leftLast; 
  
        // left of first node refers to 
        // the last node in the list 
        leftList.left = rightLast; 
  
        // Right of last node refers to the first 
        // node of the List 
        rightLast.right = leftList; 
  
        // Return the Head of the List 
        return leftList; 
    } 
    
	private static BinaryTree<Integer> initializeBT() {
		BinaryTree<Integer> binaryTree = new BinaryTree<>();
		binaryTree.initialize(10);
		
		Node<Integer> one = binaryTree.getNode(12);
		Node<Integer> two = binaryTree.getNode(15);
		
		Node<Integer> three = binaryTree.getNode(25);
		Node<Integer> four = binaryTree.getNode(30);
		
		Node<Integer> five = binaryTree.getNode(36);	
		
		
		binaryTree.push(three, four, one);
		binaryTree.push(five, null, two);
		binaryTree.push(one, two, binaryTree.root);
		return binaryTree;
	}
}
