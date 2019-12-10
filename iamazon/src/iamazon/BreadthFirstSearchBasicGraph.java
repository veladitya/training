package iamazon;

import java.util.Iterator;
import java.util.LinkedList;

import iamazon.BasicGraph.Graph;

public class BreadthFirstSearchBasicGraph {

	// prints BFS traversal from a given source s
	static void breadthFirstTraversal(Graph graph, int startNode, int vertices) {
		// Mark all the vertices as not visited(By default 
        // set as false) 
        boolean visited[] = new boolean[vertices]; 
        // Create a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<Integer>();
        // Mark the current node as visited and enqueue it 
        visited[startNode]=true; 
        queue.add(startNode);
        
        while (queue.size() != 0) 
        { 
            // Dequeue a vertex from queue and print it 
        	startNode = queue.poll(); 
            System.out.print(startNode+" "); 
  
            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
            Iterator<Integer> i = graph.adjListArray[startNode].listIterator(); 
            while (i.hasNext()) 
            { 
                int n = i.next(); 
                if (!visited[n]) 
                { 
                    visited[n] = true; 
                    queue.add(n); 
                } 
            } 
        } 
        
	}

	 // A function used by DFS 
    static void DFSUtil(Graph graph, int v,boolean visited[]) 
    { 
        // Mark the current node as visited and print it 
        visited[v] = true; 
        System.out.print(v+" "); 
  
        // Recur for all the vertices adjacent to this vertex 
        Iterator<Integer> i = graph.adjListArray[v].listIterator(); 
        while (i.hasNext()) 
        { 
            int n = i.next(); 
            if (!visited[n]) 
                DFSUtil(graph, n, visited); 
        } 
    } 
  
    // The function to do DFS traversal. It uses recursive DFSUtil() 
    static void depthFirstTraversal(Graph graph, int startNode, int v) 
    { 
        // Mark all the vertices as not visited(set as 
        // false by default in java) 
        boolean visited[] = new boolean[v]; 
  
        // Call the recursive helper function to print DFS traversal 
        DFSUtil(graph, startNode, visited); 
    } 
    
	// Driver program to test above functions
	public static void main(String args[]) {
		// create the graph given in above figure
		int V = 4;
		BasicGraph.Graph graph = new BasicGraph.Graph(V, false);
		BasicGraph.addEdge(graph, 0, 1);
		BasicGraph.addEdge(graph, 0, 2);
		BasicGraph.addEdge(graph, 1, 2);
		BasicGraph.addEdge(graph, 2, 0);
		BasicGraph.addEdge(graph, 2, 3);
		BasicGraph.addEdge(graph, 3, 3);

		// print the adjacency list representation of
		// the above graph
		BasicGraph.printGraph(graph);
		breadthFirstTraversal(graph, 2, V);
		System.out.print("\n"); 
		depthFirstTraversal(graph, 2, V);
	}
}
// This code is contributed by Sumit Ghosh 
