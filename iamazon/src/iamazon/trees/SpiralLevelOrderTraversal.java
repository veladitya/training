package iamazon.trees;

import java.util.Stack;

/**
 * Level order traversal in spiral form Write a function to print spiral order
 * traversal of a tree. For below tree, function should print 1, 2, 3, 4, 5, 6,
 * 7.
 * 
 * @author 5288873
 *
 */
//A Binary Tree node 
class Node {
	int data;
	Node left, right;

	public Node(int item) {
		data = item;
		left = right = null;
	}
}

public class SpiralLevelOrderTraversal {
	static Node root;

	public static void main(String[] args) {
		SpiralLevelOrderTraversal tree = new SpiralLevelOrderTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(7);
		tree.root.left.right = new Node(6);
		tree.root.right.left = new Node(5);
		tree.root.right.right = new Node(4);
		System.out.println("Spiral Order traversal of Binary Tree is ");
		tree.printSpiral(root);
	}

	private void printSpiral(Node node) {
		// Create two stacks to store alternate levels
		// For levels to be printed from right to left
		Stack<Node> s1 = new Stack<Node>();
		// For levels to be printed from left to right
		Stack<Node> s2 = new Stack<Node>();
		// Push first level to first stack 's1'
		s1.push(node);

		// Keep printing while any of the stacks has some nodes
		while (!s1.empty() || !s2.empty()) {
			// Print nodes of current level from s1 and push nodes of
			// next level to s2
			while (!s1.empty()) {
				Node temp = s1.peek();
				s1.pop();
				System.out.print(temp.data + " ");

				// Note that is right is pushed before left
				if (temp.right != null)
					s2.push(temp.right);

				if (temp.left != null)
					s2.push(temp.left);
			}

			// Print nodes of current level from s2 and push nodes of
			// next level to s1
			while (!s2.empty()) {
				Node temp = s2.peek();
				s2.pop();
				System.out.print(temp.data + " ");

				// Note that is left is pushed before right
				if (temp.left != null)
					s1.push(temp.left);
				if (temp.right != null)
					s1.push(temp.right);
			}
		}
	}

}
