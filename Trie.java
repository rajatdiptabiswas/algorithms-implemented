import java.util.*;
import java.lang.*;
import java.io.*;


class Trie {

	private class TrieNode {
		boolean endOfWord;
		Map<Character, TrieNode> children;

		public TrieNode() {
			this.endOfWord = false;
			this.children = new HashMap<>();
		}
	}

	private final TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode current = root;

		for (Character c : word.toCharArray()) {
			if (!current.children.containsKey(c)) {
				TrieNode node = new TrieNode();
				current.children.put(c, node);
			}
			current = current.children.get(c);
		}

		current.endOfWord = true;
	}

	public boolean search(String word) {
		TrieNode current = root;

		for (Character c : word.toCharArray()) {
			if (!current.children.containsKey(c)) {
				return false;
			}
			current = current.children.get(c);
		}

		return current.endOfWord;
	}

	public boolean searchPrefix(String prefix) {
		TrieNode current = root;

		for (Character c : prefix.toCharArray()) {
			if (!current.children.containsKey(c)) {
				return false;
			}
			current = current.children.get(c);
		}

		return true;
	}

	public void delete(String word) {
		delete(root, word, 0);
	}

	private boolean delete(TrieNode current, String word, Integer index) {

		if (index == word.length()) {
			if (!current.endOfWord) {
				return false;
			}
			current.endOfWord = false;
			return current.children.size() == 0;
		}

		Character c = word.charAt(index);
		TrieNode node = current.children.get(c);

		if (node == null)
			return false;

		boolean shouldDeleteNode = delete(node, word, index + 1);

		if (shouldDeleteNode) {
			current.children.remove(c);
			return current.children.size() == 0;
		}
		return false;

	}

	public static void main(String[] args) {
		
		Trie t = new Trie();
		
		t.insert("hello");
		t.insert("help");
		t.insert("hola");
		t.insert("he");
		
		System.out.println(t.search("hell"));	// false
		System.out.println(t.search("he"));		// true
		
		t.delete("he");
		t.delete("hen");

		System.out.println(t.search("he"));		// false

	}

}