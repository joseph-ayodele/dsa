package ds;

/**
 * A linked list is a data structure that consists of a sequence of elements,
 * each containing a reference (link) to the next element in the sequence.
 */
public class LinkedList {
	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	// Starting node
	Node head;

	// Add a node at the end
	public void add(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	// Remove a node
	public void remove(int data) {
		if (head == null) return;

		if (head.data == data) {
			head = head.next;
			return;
		}

		Node current = head;
		while (current.next != null && current.next.data != data) {
			current = current.next;
		}

		if (current.next != null) {
			current.next = current.next.next;
		}
	}

	// Print the list
	public void printList() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		// Adding elements
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);

		// Printing the list
		System.out.print("List: ");
		list.printList();

		// Removing an element
		list.remove(20);

		// Printing the list after removal
		System.out.print("List after removing 20: ");
		list.printList();
	}
	
}
