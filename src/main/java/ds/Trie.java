package ds;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
	Map<Character, TrieNode> children;
	boolean isEndOfWord;

	public TrieNode() {
		children = new HashMap<>();
		isEndOfWord = false;
	}
}

public class Trie {
	private final TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Insert a word into the trie
	public void insert(String word) {
		TrieNode current = root;
		for (char c : word.toCharArray()) {
			current = current.children.computeIfAbsent(c, k -> new TrieNode());
		}
		current.isEndOfWord = true;
	}

	// Search for a word in the trie
	public boolean search(String word) {
		TrieNode node = searchNode(word);
		return node != null && node.isEndOfWord;
	}

	// Check if there is any word in the trie that starts with the given prefix
	public boolean startsWith(String prefix) {
		return searchNode(prefix) != null;
	}

	// Helper method to search for a node representing the given prefix or word
	private TrieNode searchNode(String prefix) {
		TrieNode current = root;
		for (char c : prefix.toCharArray()) {
			current = current.children.get(c);
			if (current == null) {
				return null;
			}
		}
		return current;
	}

	// Display all words in the trie
	public void displayWords() {
		displayWordsRec(root, "");
	}

	private void displayWordsRec(TrieNode node, String prefix) {
		if (node.isEndOfWord) {
			System.out.println(prefix);
		}
		for (char c : node.children.keySet()) {
			displayWordsRec(node.children.get(c), prefix + c);
		}
	}
}

