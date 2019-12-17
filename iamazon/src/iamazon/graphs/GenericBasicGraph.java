package iamazon.graphs;

import java.util.HashMap;
// Java Program to demonstrate adjacency list 
// representation of graphs 
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class GenericBasicGraph<T> {
	// A user define class to represent a graph.
	// A graph is an array of adjacency lists.
	// Size of array will be V (number of vertices
	// in graph)
	private Graph graph;

	class Graph {
		boolean isUndirected = true;
		Map<T, LinkedList<T>> allVerticesMap = new HashMap<>();

		// constructor
		Graph(boolean isUndirected) {
			this.isUndirected = isUndirected;
		}
	}

	public Graph getGraph(boolean isUndirected) {
		if (graph == null)
			graph = new Graph(isUndirected);

		return graph;
	}

	// Adds an edge to an undirected graph
	public void addEdge(Graph graph, T src, T dest) {
		// Add an edge from src to dest.
		if (graph.allVerticesMap.get(src) == null)
			graph.allVerticesMap.put(src, new LinkedList<T>());

		graph.allVerticesMap.get(src).add(dest);

		if (graph.isUndirected) {
			// Since graph is undirected, add an edge from dest
			// to src also
			if (graph.allVerticesMap.get(dest) == null)
				graph.allVerticesMap.put(dest, new LinkedList<T>());

			graph.allVerticesMap.get(dest).add(src);
		}
	}

	// A utility function to print the adjacency list
	// representation of graph
	void printGraph(Graph graph) {
		Set<T> keys = graph.allVerticesMap.keySet();
		keys.forEach(v -> {
			System.out.println("Adjacency list of vertex " + v);
			System.out.print("head");
			graph.allVerticesMap.get(v).forEach(adV -> {
				System.out.print(" -> " + adV);
			});
			System.out.println("\n");
		});
	}

	// Driver program to test above functions
	public static void main(String args[]) {
		// create the graph given in above figure
		GenericBasicGraph<String> basicGraph = new GenericBasicGraph<>();
		GenericBasicGraph<String>.Graph graph = basicGraph.getGraph(false);
		basicGraph.addEdge(graph, "feel", "fell");
		basicGraph.addEdge(graph, "feel", "peel");

		basicGraph.addEdge(graph, "fell", "felt");
		basicGraph.addEdge(graph, "fell", "full");

		basicGraph.addEdge(graph, "felt", "pelt");
		basicGraph.addEdge(graph, "felt", "belt");

		basicGraph.addEdge(graph, "peel", "neel");

		// print the adjacency list representation of
		// the above graph
		basicGraph.printGraph(graph);
	}
}
