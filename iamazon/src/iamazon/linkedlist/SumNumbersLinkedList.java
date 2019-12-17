package iamazon.linkedlist;
// Java program to add two numbers represented by linked list 
//Add two numbers represented by linked lists
class SumNumbersLinkedList {

	static Node head1, head2;

	static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	/*
	 * Adds contents of two linked lists and return the head node of resultant list
	 */
	Node addTwoLists(Node first, Node second) {
		int carryOver = 0;
		Node headRes = null;
		Node temp = null; 
		while (first != null || second != null) {
			int res = carryOver + (first == null ? 0 : first.data) + (second == null ? 0 : second.data);
			carryOver = res >= 10 ? 1 : 0;
			res = res % 10;

			if (headRes == null) {
				headRes = new Node(res);
				temp = headRes; 
			}
			else {
				temp.next = new Node(res);
				temp=temp.next;
			}
				

			if (first != null)
				first = first.next;
			if (second != null)
				second = second.next;

		}

		return headRes;
	}
	/* Utility function to print a linked list */

	void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		SumNumbersLinkedList list = new SumNumbersLinkedList();

		// creating first list
		list.head1 = new Node(7);
		list.head1.next = new Node(5);
		list.head1.next.next = new Node(9);
		list.head1.next.next.next = new Node(4);
		list.head1.next.next.next.next = new Node(6);
		System.out.print("First List is ");
		list.printList(head1);

		// creating seconnd list
		list.head2 = new Node(8);
		list.head2.next = new Node(4);
		System.out.print("Second List is ");
		list.printList(head2);

		// add the two lists and see the result
		Node rs = list.addTwoLists(head1, head2);
		System.out.print("Resultant List is ");
		list.printList(rs);
	}
}

// this code has been contributed by Mayank Jaiswal 
