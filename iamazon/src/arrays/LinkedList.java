package arrays;

public class LinkedList {

	Node<?> head;

	public static class Node<T> {
		T data;
		Node<T> next;

		Node(T data) {
			this.data = data;
		}
	}

	@SuppressWarnings("unchecked")
	public <T> void push(T data) {
		Node<T> newNode = new Node<>(data);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = (Node<T>) head;
			head = newNode;
		}
	}

	public void print() {
		if (head == null)
			return;
		Node<?> nodePointer = head;
		while (nodePointer != null) {
			System.out.println(nodePointer.data);
			nodePointer = nodePointer.next;
		}
	}

	public int getCount(Node<?> node) {
		if (node == null)
			return 0;

		return 1 + getCount(node.next);
	}

	public static void main(String args[]) {
		initialize();
	}

	private static void initialize() {
		LinkedList lList = new LinkedList();
		lList.push(10);
		lList.push(20);
		// lList.head.next.next = head;
		lList.print();
		System.out.println("==>> " + lList.getCount(lList.head));
	}
}
