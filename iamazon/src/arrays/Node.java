package arrays;

public class Node<T> {

	public T data;
	public Node<T> left;
	public Node<T> right;

	public Node(T data) {
		this.data = data;
		this.left = this.right = null;
	}
	
	public String toString() {
		return "data = "+data +" "+ (left!= null? left.data: -1)+" "+ (right!= null? right.data: -1);
	}
}
