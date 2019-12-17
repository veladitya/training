package iamazon.graphs;

import java.util.LinkedList;
import java.util.Stack;
import java.util.function.Consumer;

public class GraphNavigationByDictionary<T> {

	public static void graphNavigate(String src, String dest, GenericBasicGraph<String>.Graph graph) {
		Stack<String> s = new Stack();
		// basic equal check on
		LinkedList<String> others = graph.allVerticesMap.get(src);
		System.out.println(src);
		s.add(src);
		find(graph, src, dest, s);
		System.out.println(s);
	}

	private static boolean find(GenericBasicGraph<String>.Graph graph, String src, String dest, Stack<String> s) {
		LinkedList<String> all = graph.allVerticesMap.get(src);
		Integer sz = 0;
		Integer itr = 0;
		//leaf node
		if(all == null) {
			//System.out.println(src);
			  if(!s.contains(dest)) 
				  s.pop();
			  
			 			
		}else {
			sz = all.size();
			itr = sz;
			System.out.println(sz);
			all.forEach(extracted(graph, dest, s, sz, itr));
		}
		
		return false;
	}

	private static Consumer<? super String> extracted(GenericBasicGraph<String>.Graph graph, String dest,
			Stack<String> s, Integer sz, Integer itr) {
		itr--;
		if(itr==0  && !s.contains(dest)) {
			String temp = null; 
			for(int i=0; i<sz+1; i++) {
				if(i == 0)
					temp = s.pop();
				else
					s.pop();
			}	
			s.push(temp);
		}
		//System.out.println(sz);
		return v->{
			//System.out.println(v);
			
			if(!s.contains(dest))
				s.push(v);
			
			//System.out.println(s);
			find(graph, v, dest, s);
			
			//if(!s.isEmpty() && !s.contains(dest))
			//	s.pop();
		};
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

		basicGraph.addEdge(graph, "belt", "bell");
		basicGraph.addEdge(graph, "peel", "neel");

		// print the adjacency list representation of
		// the above graph
		// basicGraph.printGraph(graph);

		graphNavigate("feel", "full", graph);
	}
}
