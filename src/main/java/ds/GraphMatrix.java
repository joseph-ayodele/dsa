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
public class GraphMatrix {

	public static class Node {
		char data;

		Node(char data) {
			this.data = data;
		}
	}

	private final List<Node> nodes;
	private final int[][] matrix;

	GraphMatrix(int n) {
		nodes = new ArrayList<>();
		matrix = new int[n][n];
	}

	public void addNode(Node node) {
		nodes.add(node);
	}

	public void addEdge(int src, int dst) {
		matrix[src][dst] = 1;
	}

	public boolean checkEdge(int src, int dst) {
		return matrix[src][dst] == 1;
	}
	
	public void print() {
		System.out.print("  ");
		for (Node node : nodes) {
			System.out.print(node.data + " ");
		}
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			System.out.print(nodes.get(i).data + " ");
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		GraphMatrix graphMatrix = new GraphMatrix(3);
		graphMatrix.addNode(new Node('A'));
		graphMatrix.addNode(new Node('B'));
		graphMatrix.addNode(new Node('C'));
		
		graphMatrix.addEdge(0,2);
		graphMatrix.addEdge(1,0);
		graphMatrix.addEdge(1,2);
		graphMatrix.addEdge(2,1);
		graphMatrix.addEdge(2,2);

		System.out.println(graphMatrix.checkEdge(0, 2));
		graphMatrix.print();
	}
}
