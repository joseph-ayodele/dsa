package ds;

/**
 * A doubly linked list is similar to a singly linked list,
 * but each node contains references to both the next and the previous nodes.
 */
public class LinkedListDoubly {
	static class Node {
		int data;
		Node next;
		Node prev;

		public Node(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	// Starting node
	Node head;
	Node tail;

	// Add a node at the end
	public void add(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
		}
		tail = newNode;
	}

	// Remove a node
	public void remove(int data) {
		if (head == null) return;

		// first check if the head node is the node you want to remove
		if (head.data == data) {
			head = head.next;
			if (head != null) 
				head.prev = null;
			return;
		}

		Node current = head;
		// try to find the node to remove
		while (current != null && current.data != data) {
			current = current.next;
		}

		if (current == null) return; // Node with data not found

		// set tail properly
		if (current.next != null) {
			current.next.prev = current.prev;
		}

		if (current.prev != null) {
			current.prev.next = current.next;
		}

		if (current == tail) {
			tail = current.prev;
		}
	}

	// Print the list forward
	public void printListForward() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	// Print the list backward
	public void printListBackward() {
		Node current = tail;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.prev;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedListDoubly list = new LinkedListDoubly();

		// Adding elements
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);

		// Printing the list
		System.out.print("List: ");
		list.printListForward();

		// Removing an element
		list.remove(20);

		// Printing the list after removal
		System.out.print("List after removing 20: ");
		list.printListForward();
		list.printListBackward();
	}
	
}
