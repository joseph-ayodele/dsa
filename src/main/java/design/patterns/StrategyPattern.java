package design.patterns;

import algorithms.sort.BubbleSort;
import algorithms.sort.InsertionSort;
import algorithms.sort.QuickSort;
import algorithms.sort.Sort;

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
