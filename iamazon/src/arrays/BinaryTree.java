package arrays;

public class BinaryTree<T> {

	public Node<T> root;

	public BinaryTree<T> push(Node<T> left, Node<T> right, Node<T> target) {
		target.left = left;
		target.right = right;
		return this;
	}	

	public void initialize(T d) {		
		this.root = getNode(d);		
	}

	public Node<T> getNode(T d) {
		return new Node<>(d);
	}
}
