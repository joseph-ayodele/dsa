package ds;

/**
 * Implementation of a min-heap-based priority queue
 * AKA min heap
 */
public class PriorityQueue {
	private int[] heap;
	private int size;
	private int capacity;

	public PriorityQueue(int capacity) {
		this.capacity = capacity;
		heap = new int[capacity];
		size = 0;
	}

	// Check if the queue is empty
	public boolean isEmpty() {
		return size == 0;
	}

	// Peek the highest priority element (smallest element)
	public int peek() {
		if (isEmpty()) {
			throw new IllegalStateException("Priority queue is empty");
		}
		return heap[0];
	}

	// Enqueue (insert) an element
	public void enqueue(int data) {
		if (size == capacity) {
			throw new IllegalStateException("Priority queue is full");
		}
		heap[size] = data;
		size++;
		heapifyUp(size - 1);
	}

	// Heapify up to maintain heap property
	private void heapifyUp(int index) {
		int parentIndex = (index - 1) / 2;
		if (index > 0 && heap[index] < heap[parentIndex]) {
			swap(index, parentIndex);
			heapifyUp(parentIndex);
		}
	}

	// Dequeue (remove) the highest priority element
	public int dequeue() {
		if (isEmpty()) {
			throw new IllegalStateException("Priority queue is empty");
		}
		int data = heap[0];
		heap[0] = heap[size - 1];
		size--;
		heapifyDown(0);
		return data;
	}
	
	private void heapifyDown(int index) {
		int smallest = index;
		int leftChild = 2 * index + 1;
		int rightChild = 2 * index + 2;

		if (leftChild < size && heap[leftChild] < heap[smallest]) {
			smallest = leftChild;
		}

		if (rightChild < size && heap[rightChild] < heap[smallest]) {
			smallest = rightChild;
		}

		if (smallest != index) {
			swap(index, smallest);
			heapifyDown(smallest);
		}
	}


	// Swap elements at two indices
	private void swap(int i, int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
}
