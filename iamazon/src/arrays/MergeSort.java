package arrays;

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

		Node node = null;
		node = list.mergeSort(head);
		System.out.println("Linked list after sorting :");
		list.print(node);

	}

	private Node mergeSort(Node node) {
		if (node == null || node.next == null) { 
            return node; 
        } 
		Node second = split(node);
		System.out.println(second );
		
		node = mergeSort(node);
		
		System.out.println(second );		
		second = mergeSort(second);
		// Merge the two sorted halves 
        return merge(node, second); 
	}

	private Node merge(Node first, Node second) {
		// If first linked list is empty 
        if (first == null) { 
            return second; 
        } 
  
        // If second linked list is empty 
        if (second == null) { 
            return first; 
        } 
        
        if(first.data < second.data) {
        	first.next = merge(first.next, second);
        	first.next.prev = first;
        	first.prev = null;
        	return first;
        } else {
        	second.next = merge(first, second.next);
        	second.next.prev=second;
        	second.prev=null;
        	return second;
        } 		
	}

	private Node split(Node node) {
		Node fast = node, slow = node;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		Node tmp = slow.next;
		slow.next = null; 
		
		return tmp;
	}

}
