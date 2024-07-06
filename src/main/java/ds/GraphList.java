package ds;

import java.util.ArrayList;
import java.util.List;

/**
 * Graphs can be represented in two ways:
 * 1. Adjacency Matrix: time O(1) space O(n^2) or O(V^2)
 * 	   A, B, C
 * A [[0, 0, 1]
 * B  [1, 0, 1]
 * C  [0, 1, 1]]
 * 2. Adjacency List: time O(n) or O(V) space O(n + E) or O(V + E)
 * A -> C
 * B -> A -> C
 * C -> B -> A
 */
public class GraphList {
	public static class Node {
		char data;
		Node(char data) {
			this.data = data;
		}
	}
	private List<LinkedList<Node>> arrayList;
	
	public void addNode(Node node) {
		LinkedList<Node> currentList = new LinkedList<>();
		currentList.add(node);
		arrayList.add(currentList);
	}
	
	public void addEdge(int src, int dst) {
		LinkedList<Node> currentLinkedList = arrayList.get(src);
		Node dstNode = arrayList.get(dst).get(dst);
		currentLinkedList.add(dstNode);
	}

	public boolean checkEdge(int src, int dst) {
		LinkedList<Node> currentLinkedList = arrayList.get(src);
		Node dstNode = arrayList.get(dst).get(dst);
		// ... to be continued
		return false;
	}
	
	public void print() {
		GraphList graph = new GraphList();
		graph.addNode(new GraphList.Node('A'));
		graph.addNode(new GraphList.Node('B'));
		graph.addNode(new GraphList.Node('C'));

		graph.addEdge(1,0);
		graph.addEdge(1,2);
		graph.addEdge(2,1);
		graph.addEdge(2,2);
		graph.addEdge(0,2);

		System.out.println(graph.checkEdge(0, 2));
		graph.print();
	}
}
