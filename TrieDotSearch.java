/*
 * Design a data structure that supports the following two operations:
 * 
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string 
 * containing only letters 'a'-'z' or '.'. 
 * A '.'' means it can represent any one letter.
 * 
 * Example:
 * 
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 */


class TrieDotSearch {
    
    private class TrieNode {
        boolean endOfWord;
        Map<Character, TrieNode> children;

        public TrieNode() {
            endOfWord = false;
            children = new HashMap<>();
        }
    }

    private final TrieNode root;
    
    /** 
     * Initialize the data structure. 
     */
    public TrieDotSearch() {
        root = new TrieNode();
    }
    
    /**
     * Adds a word into the data structure. 
     */
    public void addWord(String word) {
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
    
    /**
     * Returns if the word is in the data structure. 
     * A word could contain the dot character '.' to represent any one letter. 
     */
    public boolean search(String word) {
        return dfsSearch(root, word, 0);    
    }

    private boolean dfsSearch(TrieNode current, String word, Integer index) {
        if (index == word.length()) {
            return current.endOfWord;
        }

        Character c = word.charAt(index);

        if (c == '.') {
            boolean result = false;

            for (TrieNode value : current.children.values()) {
                result = result || dfsSearch(value, word, index + 1);
            }

            return result;
        } else {
            TrieNode node = current.children.get(c);

            if (node == null)
                return false;

            return dfsSearch(node, word, index + 1);
        }
    }
}