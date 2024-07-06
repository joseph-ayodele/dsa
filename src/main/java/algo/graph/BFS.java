package algo.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * In Breadth First Search: you traverse the immediate neighbors/children first before continuing 
 * Think of it like spreading out from a central point in waves.
 */
public class BFS {

	public static void bfs(Map<String, List<String>> graph, String node) {
		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		
		visited.add(node);
		queue.add(node);
		
		while (!queue.isEmpty()) {
			String s = queue.poll();
			System.out.print(s + " ->  ");

			for (String currentNode : graph.get(s)) {
				if (!visited.contains(currentNode)) {
					visited.add(currentNode);
					queue.add(currentNode);
					System.out.print(currentNode + " ");
				}
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		Map<String, List<String>> graph = new HashMap<>();

		graph.put("A", List.of("B", "G"));
		graph.put("B", List.of("D", "E", "F"));
		graph.put("C", List.of("G"));
		graph.put("D", List.of());
		graph.put("E", List.of());
		graph.put("F", List.of("H"));
		graph.put("G", List.of("I"));
		graph.put("H", List.of());
		graph.put("I", List.of());

		bfs(graph, "A");
	}
}
