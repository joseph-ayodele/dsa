package ds;

import java.util.ArrayList;

/**
 * Implementing a stack using an array list
 * If you notice, all that really matters is what is at the end of the list
 * LIFO
 */
public class StackList {
	private final ArrayList<Integer> stack;

	public StackList() {
		this.stack = new ArrayList<>();
	}

	// Push an element onto the stack
	public void push(int data) {
		stack.add(data);
	}

	// Pop an element from the stack
	public int pop() {
		if (isEmpty()) {
			throw new IllegalStateException("Stack is empty");
		}
		return stack.remove(stack.size() - 1);
	}

	// Peek the top element
	public int peek() {
		if (isEmpty()) {
			throw new IllegalStateException("Stack is empty");
		}
		return stack.get(stack.size() - 1);
	}

	// Check if the stack is empty
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	// Print the stack
	public void printStack() {
		for (int i = stack.size() - 1; i >= 0; i--) {
			System.out.print(stack.get(i) + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		StackList stack = new StackList();

		stack.push(10);
		stack.push(20);
		stack.push(30);

		System.out.print("Stack: ");
		stack.printStack();

		System.out.println("Peek: " + stack.peek());
		System.out.println("Pop: " + stack.pop());

		System.out.print("Stack after pop: ");
		stack.printStack();
	}
}
