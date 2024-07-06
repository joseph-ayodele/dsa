package ds;

public class Queue {
	private final int[] queue;
	private int front;
	private int rear;
	private int size;
	private final int capacity;

	public Queue(int capacity) {
		this.capacity = capacity;
		queue = new int[capacity];
		front = 0;
		rear = -1;
		size = 0;
	}

	// Enqueue operation: adding element to the end
	public void enqueue(int data) {
		if (size == capacity) {
			throw new IllegalStateException("Queue is full");
		}
		rear = (rear + 1) % capacity; // Move rear to the next position, wrap around if needed
		queue[rear] = data;
		size++;
	}

	// Dequeue operation: removing elements from the front
	public int dequeue() {
		if (isEmpty()) {
			throw new IllegalStateException("Queue is empty");
		}
		int data = queue[front];
		front = (front + 1) % capacity; // Move front to the next position, wrap around if needed
		size--;
		return data;
	}

	// Peek operation
	public int peek() {
		if (isEmpty()) {
			throw new IllegalStateException("Queue is empty");
		}
		return queue[front];
	}

	// Check if the queue is empty
	public boolean isEmpty() {
		return size == 0;
	}

	// Print the queue
	public void printQueue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		for (int i = 0; i < size; i++) {
			System.out.print(queue[(front + i) % capacity] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Queue queue = new Queue(5);

		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);

		System.out.print("Queue: ");
		queue.printQueue();

		System.out.println("Peek: " + queue.peek());
		System.out.println("Dequeue: " + queue.dequeue());

		System.out.print("Queue after dequeue: ");
		queue.printQueue();

		queue.enqueue(50);
		queue.enqueue(60);

		System.out.print("Queue after more enqueues: ");
		queue.printQueue();
	}
}
