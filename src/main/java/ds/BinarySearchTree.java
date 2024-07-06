package ds;

/**
 * Binary Search Tree: left child < root < right child
 */
public class BinarySearchTree {
	Node root;

	public BinarySearchTree() {
		this.root = null;
	}

	// Insert a node into the binary tree
	public void insert(int data) {
		root = insertRec(root, data);
	}

	private Node insertRec(Node root, int data) {
		if (root == null) {
			root = new Node(data);
			return root;
		}

		if (data < root.data) {
			root.left = insertRec(root.left, data);
		} else if (data > root.data) {
			root.right = insertRec(root.right, data);
		}

		return root;
	}

	// Inorder traversal
	public void inorder() {
		inorderRec(root);
	}

	private void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.print(root.data + " ");
			inorderRec(root.right);
		}
	}

	public void delete(int data) {
		root = deleteRec(root, data);
	}

	private Node deleteRec(Node root, int data) {
		if (root == null) {
			return null;
		}

		// Recur down the tree
		if (data < root.data) {
			root.left = deleteRec(root.left, data);
		} else if (data > root.data) {
			root.right = deleteRec(root.right, data);
		} else {
			// Node with only one child or no child
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}

			// Node with two children: Get the inorder successor (smallest in the right subtree)
			root.data = minValue(root.right);

			// Delete the inorder successor
			root.right = deleteRec(root.right, root.data);
		}

		return root;
	}

	private int minValue(Node root) {
		int minValue = root.data;
		while (root.left != null) {
			root = root.left;
			minValue = root.data;
		}
		return minValue;
	}


	// Preorder traversal
	public void preorder() {
		preorderRec(root);
	}

	private void preorderRec(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorderRec(root.left);
			preorderRec(root.right);
		}
	}

	// Postorder traversal
	public void postorder() {
		postorderRec(root);
	}

	private void postorderRec(Node root) {
		if (root != null) {
			postorderRec(root.left);
			postorderRec(root.right);
			System.out.print(root.data + " ");
		}
	}

	// Search for a value
	public boolean search(int data) {
		return searchRec(root, data);
	}

	private boolean searchRec(Node root, int data) {
		// Base case: root is null or data is present at root
		if (root == null || root.data == data) {
			return root != null;
		}

		// Value is greater than root's data
		if (root.data < data) {
			return searchRec(root.right, data);
		}

		// Value is less than root's data
		return searchRec(root.left, data);
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.inorder();
		System.out.print("Inorder traversal: ");
		System.out.println();
		tree.preorder();
		System.out.print("Preorder traversal: ");
		System.out.println();
		tree.postorder();
		System.out.print("Postorder traversal: ");
		System.out.println();

		System.out.println("Delete 20");
		tree.delete(20);
		System.out.print("Inorder traversal: ");
		tree.inorder();
		System.out.println();

		System.out.println("Delete 30");
		tree.delete(30);
		System.out.print("Inorder traversal: ");
		tree.inorder();
		System.out.println();

		System.out.println("Delete 50");
		tree.delete(50);
		System.out.print("Inorder traversal: ");
		tree.inorder();
		System.out.println();

		System.out.println("Search 40: " + tree.search(40)); // Should return true
		System.out.println("Search 90: " + tree.search(90)); // Should return false
	}
}

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}