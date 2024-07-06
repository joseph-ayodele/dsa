package ds;

/**
 * Stack implementation using a linked list
 * LIFO
 */
public class Stack {
	private LinkedList.Node top;
	
	public Stack() {
		this.top = null;
	}

	// Push an element onto the stack
	public void push(int data) {
		LinkedList.Node newNode = new LinkedList.Node(data);
		newNode.next = top;
		top = newNode;
	}

	// Pop an element from the stack
	public int pop() {
		if (isEmpty()) {
			throw new IllegalStateException("Stack is empty");
		}
		int popped = top.data;
		top = top.next;
		return popped;
	}

	// Peek the top element
	public int peek() {
		if (isEmpty()) {
			throw new IllegalStateException("Stack is empty");
		}
		return top.data;
	}

	public int top() {
		return peek();
	}

	// Check if the stack is empty
	public boolean isEmpty() {
		return top == null;
	}

	// Print the stack
	public void printStack() {
		LinkedList.Node current = top;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Stack stack = new Stack();

		stack.push(10);
		stack.push(20);
		stack.push(30);

		System.out.print("Stack: ");
		stack.printStack();

		System.out.println("Peek: " + stack.top());
		System.out.println("Pop: " + stack.pop());

		System.out.print("Stack after pop: ");
		stack.printStack();
	}
}
