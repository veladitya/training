package iamazon;

public class BinaryTreeVerticalOrder {

	Node root;
	TrackValues val = new TrackValues();

	static class TrackValues {
		int min = 0;
		int max = 0;

	}

	static class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		BinaryTreeVerticalOrder tree = new BinaryTreeVerticalOrder();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);
		tree.root.right.right.right = new Node(9);

		System.out.println("vertical order traversal is :");
		tree.verticalOrder(tree.root);
	}

	private void verticalOrder(Node node) {

		//find the horizontal distance for a tree
		findHorizontalDistance(node, val, val, 0);
		System.out.println(val.min + " ==== " + val.max);
		
		for(int lineNo=val.min; lineNo<= val.max; lineNo++) {
			printVerticalTreeTraversal(node, lineNo, 0);
			System.out.println("");
		}
			
	}

	private void printVerticalTreeTraversal(Node node, int lineNo, int j) {
		
		if(node == null)
			return;
		
		if(lineNo == j) 
			System.out.println(node.data+" ");
		
		
		
		printVerticalTreeTraversal(node.left, lineNo, j-1);
		printVerticalTreeTraversal(node.right, lineNo, j+1);		
	}

	private void findHorizontalDistance(Node node, TrackValues min, TrackValues max, int i) {
		if (node == null)
			return;
		if (i < min.min) {
			min.min = i;
		} else if (i > max.max) {
			max.max = i;
		}
		findHorizontalDistance(node.left, min, max, i - 1);
		findHorizontalDistance(node.right, min, max, i + 1);
	}

}
