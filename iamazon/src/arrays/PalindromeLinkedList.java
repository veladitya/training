package arrays;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import arrays.LinkedList.Node;

public class PalindromeLinkedList {

	public static void main(String[] args) {
		LinkedList list = initialize(); 
       removeDuplicates(list);
       list.print();
	}

	private static void removeDuplicates(LinkedList list) {
		Node<String> tempNode = (Node<String>) list.head;
		Set<String> strSet = new HashSet<>();
		
		Node<String> prevNode = null;
		while(tempNode != null) {
			if(strSet.contains(tempNode.data)) {
				removeNode(tempNode, prevNode);				
			}else {
				strSet.add(tempNode.data);
				prevNode = tempNode;
				
			}	
			tempNode = tempNode.next;
		}
		
	}

	private static void removeNode(Node<String> currentNode, Node<String> prevNode) {		
		prevNode.next=currentNode.next;		
	}

	private static LinkedList initialize() {
		Node<String> one = new Node<>("R"); 
        Node<String> two = new Node<>("A"); 
        Node<String> three = new Node<>("D"); 
        Node<String> four = new Node<>("A"); 
        Node<String> five = new Node<>("R");
        
        LinkedList list= new LinkedList();
        list.head = one;
        one.next = two; 
        two.next = three; 
        three.next = four; 
        four.next = five; 
        System.out.println("Given list is a Palindrome? "+isPalindrome((Node<String>) list.head));
        return list;
	}

	private static boolean isPalindrome(Node<String> head) {
		Stack<String> stack = new Stack<>();
		
		Node<String> tempNode  = head;
		
		while(tempNode != null) {
			stack.push(tempNode.data);
			tempNode = tempNode.next; 
		}
		tempNode  = head;
		while(tempNode != null) {
			if(stack.pop() != tempNode.data) {
				return false;
			}
			
			tempNode = tempNode.next; 
		}
		
		return true;
	}

}
