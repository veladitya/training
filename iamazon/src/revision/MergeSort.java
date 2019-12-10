package revision;

public class MergeSort {
	static Node head; // head of list

	/* Node Class */
	static class Node {

		int data;
		Node next, prev;

		// Constructor to create a new node
		Node(int d) {
			data = d;
			next = prev = null;
		}

		public String toString() {
			return "Data " + data;
		}
	}

	void print(Node node) {
		Node temp = node;
		System.out.println("Forward Traversal using next pointer");
		while (node != null) {
			System.out.print(node.data + " ");
			temp = node;
			node = node.next;
		}
		System.out.println("\nBackward Traversal using prev pointer");
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.prev;
		}
	}

	// Driver program to test above functions
	public static void main(String[] args) {

		MergeSort list = new MergeSort();
		list.head = new Node(10);
		list.head.next = new Node(30);
		list.head.next.next = new Node(3);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(20);
		list.head.next.next.next.next.next = new Node(5);
		list.print(list.head);
		
		System.out.println("\nLinked list after sorting :");
		list.print(list.performMergeSort(list.head));
	}
	
	Node performMergeSort(Node node){
		if(node == null || node.next == null)
			return node;
		
		//split to two lists 
		Node second = splitNodes(node);
		node = performMergeSort(node);
		second = performMergeSort(second);
		//merge them
		return merge(node, second);
	}
	
	Node splitNodes(Node node) {
		Node fast, slow;
		Node tmp;
		fast = node; 
		slow = node; 
		

		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		tmp = slow.next; 
		slow.next = null;
		return tmp;
		
	}
	
	Node merge(Node first, Node second) {
		if(first == null) {
			return second;
		}
		if(second == null) {
			return first;
		}
		
		if(first.data > second.data) {
			first.next = merge(first.next, second); 
			return first;
		}else {
			second.next = merge(first, second.next);
			return second;
		}
	}

}
