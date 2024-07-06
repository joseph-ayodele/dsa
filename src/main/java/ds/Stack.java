package ds;

/**
 * Stack implementation using a linked list
 * LIFO
 */
public class Stack<T> {
	private LinkedList.Node<T> top;
	
	public Stack() {
		this.top = null;
	}

	// Push an element onto the stack
	public void push(T data) {
		LinkedList.Node<T> newNode = new LinkedList.Node(data);
		newNode.next = top;
		top = newNode;
	}

	// Pop an element from the stack
	public T pop() {
		if (isEmpty()) {
			throw new IllegalStateException("Stack is empty");
		}
		T popped = top.data;
		top = top.next;
		return popped;
	}

	// Peek the top element
	public T peek() {
		if (isEmpty()) {
			throw new IllegalStateException("Stack is empty");
		}
		return top.data;
	}

	public T top() {
		return peek();
	}

	// Check if the stack is empty
	public boolean isEmpty() {
		return top == null;
	}

	// Print the stack
	public void printStack() {
		LinkedList.Node<T> current = top;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();

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
