package ds;

import java.util.HashMap;

/**
 * A hash table is a data structure that maps keys to values for highly efficient lookups
 * A hash table is a collection of key value pairs
 */
public class HashTable {
	public static void main(String[] args) {
		// Creating a HashMap
		HashMap<String, Integer> map = new HashMap<>();

		// Adding key-value pairs
		map.put("Alice", 30);
		map.put("Bob", 25);
		map.put("Charlie", 35);

		// Retrieving a value
		int age = map.get("Alice");
		System.out.println("Alice's age: " + age);

		// Checking if a key exists
		if (map.containsKey("Bob")) {
			System.out.println("Bob is in the map.");
		}

		// Removing a key-value pair
		map.remove("Charlie");

		// Iterating over elements
		for (String key : map.keySet()) {
			System.out.println("Key: " + key + ", Value: " + map.get(key));
		}
	}
}
