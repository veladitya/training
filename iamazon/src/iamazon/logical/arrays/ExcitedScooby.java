package iamazon.logical.arrays;
/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

public class ExcitedScooby {
    
    Node root;
    static class Node{
        int data;
        boolean isStartNode;
        Node next; 
        
        Node(int data){
            this(data, false);
        }
        
        Node(int data, boolean isStartNode) {
            this.data = data;
            this.isStartNode = isStartNode;
        }
    }
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here
        ExcitedScooby t = new ExcitedScooby();
        t.root = new Node(0, true);
        t.root.next=new Node(1);
        t.root.next.next=new Node(2);
        t.root.next.next.next=new Node(3);
        t.root.next.next.next.next=new Node(4);
        t.root.next.next.next.next.next=t.root;
        
        Node  n = t.getNode(3);
        
        int i = t.getCount(n);
        System.out.println(i);
    }
    
    public int getCount(Node n){
        int c=0;
        Node tmp = n;
        while (n.next != null && n.next.data != 3){
            c++;
            n = n.next;
        }
        
        return c+1;
    }
    
    public Node getNode(int data) {
        Node node = this.root;
        
        while(node.next != null){
            if(node.next.data == data){
            	node = node.next;
                break;
            }
            node = node.next;
        }
        
        return node;
    }
}
