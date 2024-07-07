package algo.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstra {

	// Helper class to represent an edge
	static class Edge {
		String target;
		int weight;

		Edge(String target, int weight) {
			this.target = target;
			this.weight = weight;
		}
	}

	// Helper class to represent a node in the priority queue
	static class Node {
		String name;
		int distance;

		Node(String name, int distance) {
			this.name = name;
			this.distance = distance;
		}
	}
	
	static Map<String, Integer> dijkstra(Map<String, List<Edge>> graph, String startNode) {
		// Initialize the distance map with infinity for all nodes except the start node
		Map<String, Integer> distance = new HashMap<>();
		for(String currNode : graph.keySet()) {
			distance.put(currNode, Integer.MAX_VALUE);
		}
		distance.put(startNode, 0);
		
		// Priority queue to store (distance, node)
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(n -> n.distance));
		priorityQueue.add(new Node(startNode, 0));
		
		// Visited set to keep track of visited nodes
		Set<String> visited = new HashSet<>();
		
		// While there are nodes to process in the priority queue
		while (!priorityQueue.isEmpty()) {
			// Get the node with the smallest distance
			Node currentNode = priorityQueue.poll();

			// Skip this node if it has already been visited
			if (visited.contains(currentNode.name)) {
				continue;
			}

			// Mark the current node as visited
			visited.add(currentNode.name);

			// Update distances for neighbors
			for (Edge edge : graph.get(currentNode.name)) {
				if (!visited.contains(edge.target)) {
					int newDistance = currentNode.distance + edge.weight;
					// If a shorter path to the neighbor is found
					if (newDistance < distance.get(edge.target)) {
						distance.put(edge.target, newDistance);
						priorityQueue.add(new Node(edge.target, newDistance));
					}
				}
			}
		}

		// Return the distances (could also return previous for path reconstruction)
		return distance;
	}

	public static void main(String[] args) {
		Map<String, List<Edge>> graph = new HashMap<>();
		graph.put("A", Arrays.asList(new Edge("B", 1), new Edge("C", 4)));
		graph.put("B", Arrays.asList(new Edge("A", 1), new Edge("D", 2)));
		graph.put("C", Arrays.asList(new Edge("A", 4), new Edge("D", 2)));
		graph.put("D", Arrays.asList(new Edge("B", 2), new Edge("C", 2)));

		// Run Dijkstra's algorithm
		String startNode = "A";
		Map<String, Integer> distances = dijkstra(graph, startNode);
		System.out.println(distances);
	}
}
