package arrays;

import java.util.LinkedList;
import java.util.Queue;

public class InsertBinaryTreeLevelOrder {

	public static void main(String[] args) {
		InsertBinaryTreeLevelOrder insertBinaryTreeLevelOrder = new InsertBinaryTreeLevelOrder();
		BinaryTree<Integer> binaryTree = insertBinaryTreeLevelOrder.initializeBT();
		insertBinaryTreeLevelOrder.inorder(binaryTree.root);
		System.out.println("\n");
		insertBinaryTreeLevelOrder.insert(binaryTree.root, 100);
		insertBinaryTreeLevelOrder.inorder(binaryTree.root);
	}

	private void insert(Node<Integer> root, int i) {
		Queue<Node> q =  new LinkedList<Node>();
		q.add(root);
		
		while(!q.isEmpty()) {
			root = q.peek();
			q.remove();
			
			if(root.left == null) {
				root.left = new Node(i); 
                break; 
            } else
                q.add(root.left);
			
			 if (root.right == null) { 
	                root.right = new Node(i); 
	                break; 
	            } else
	                q.add(root.right); 
			 
		}
		
	}

	void inorder(Node temp) 
    { 
        if (temp == null) 
            return; 
       
        inorder(temp.left); 
        System.out.print(temp.data+" "); 
        inorder(temp.right); 
    } 
	
	public void breadthFirstSearch(Node<Integer> node) {
		int height = getHeight(node);
		printLevelOrder(height,node);
	}

	void printLevelOrder(int h, Node<Integer> node) 
    {        
        int i; 
        for (i=1; i<=h; i++) 
            printGivenLevel(node, i); 
    } 
	
	/* Print nodes at the given level */
    void printGivenLevel (Node root ,int level) 
    { 
        if (root == null) 
            return; 
        if (level == 1) 
            System.out.print(root.data + " "); 
        else if (level > 1) 
        { 
            printGivenLevel(root.left, level-1); 
            printGivenLevel(root.right, level-1); 
        } 
    } 
	
	public int getHeight(Node<Integer> node) {
		if (node == null) {
			return 0;
		}
		int lHeight = getHeight(node.left);		
		int rHeight = getHeight(node.right);
		
		/* use the larger one */
		if (lHeight > rHeight)
			return (lHeight + 1);
		else
			return (rHeight + 1);
	}

	private BinaryTree<Integer> initializeBT() {
		BinaryTree<Integer> binaryTree = new BinaryTree<>();
		binaryTree.initialize(10);

		Node<Integer> one = binaryTree.getNode(20);
		Node<Integer> two = binaryTree.getNode(30);

		Node<Integer> three = binaryTree.getNode(40);
		Node<Integer> four = binaryTree.getNode(50);

		binaryTree.push(three, four, one);
		binaryTree.push(one, two, binaryTree.root);
		return binaryTree;
	}
}
