package algo.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * In depth first search - you visit children nodes before visiting neighboring nodes
 * 		it can be implement using a regular stack or a call stack
 */
public class DFS {
	
	public static void dfs(Map<String, List<String>> graph, String node, Set<String> visited) {
		visited.add(node);
		System.out.print(node + " -> ");
		
		for (String currentNode : graph.get(node)) {
			if (!visited.contains(currentNode)){
				dfs(graph, currentNode, visited);
			}
		}
	}
	
	public static void dfs(Map<String, List<String>> graph, String node) {
		Set<String> visited = new HashSet<>();
		Stack<String> stack = new Stack<>();
		
		visited.add(node);
		stack.add(node);
		
		while (!stack.isEmpty()) {
			String s = stack.pop();
			System.out.print(s + " -> ");
			
			for (String currentNode : graph.get(s)) {
				if (!visited.contains(currentNode)) {
					visited.add(currentNode);
					stack.add(currentNode);
					System.out.print(currentNode + " ");
				}
			}
			System.out.println();
		}
	}
	

	public static void main(String[] args) {
		Map<String, List<String>> graph = new HashMap<>();
		
		graph.put("A", List.of("B", "G"));
		graph.put("B", List.of("B", "D", "E"));
		graph.put("C", List.of());
		graph.put("D", List.of());
		graph.put("E", List.of("F"));
		graph.put("F", List.of());
		graph.put("G", List.of("H"));
		graph.put("H", List.of("I"));
		graph.put("I", List.of());

		dfs(graph, "A");
		System.out.println("-------------------------------");
		dfs(graph, "A", new HashSet<>());
	}
}
