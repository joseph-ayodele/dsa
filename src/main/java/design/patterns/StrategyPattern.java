package design.patterns;

import sort.BubbleSort;
import sort.InsertionSort;
import sort.QuickSort;
import sort.Sort;

/**
 * The Strategy Pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable.
 * Strategy lets the algorithm vary independently of clients that use it.
 */
public class StrategyPattern {
	public static void main(String[] args) {
		Sort sort = new BubbleSort();
		sort = new QuickSort();
		sort = new InsertionSort();
	}
}
