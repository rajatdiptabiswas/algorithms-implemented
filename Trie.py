#!/usr/bin/env python3


class Trie:
    """Trie data structure."""

    class TrieNode:
        """
        Node of trie data structure.

        Contains
        - a boolean to mark the end of the word
        - a dictionary to map each character to a child TrieNode
        """

        def __init__(self):
            self.end_of_word = False
            self.children = {}

    def __init__(self):
        self.root = self.TrieNode()

    def insert(self, string: str) -> None:
        """
        Insert a string into the trie data structure.

        Need to traverse down the data structure.
        If a character is present in the children dictionary, follow
        that path.
        Otherwise, make an empty new node, add a character to the
        current node's children dictionary, and link it to the newly
        created node.
        Set the final node's boolean to true to mark the end of the
        word.
        """
        current = self.root
        for char in string:
            if char not in current.children:
                new_node = self.TrieNode()
                current.children[char] = new_node
            current = current.children[char]
        current.end_of_word = True

    def search(self, string: str) -> bool:
        """
        Check if a string is present in the trie data structure.

        A string can only be present in the trie if the trie can
        be successfully traversed by following each node's
        children dictionary.
        If the final node has the boolean set to be true, only then
        it can be confirmed that the word is present.
        If any of these condtions is violated, the word is absent
        from the trie.
        """
        current = self.root
        for char in string:
            if char not in current.children:
                return False
            current = current.children[char]
        return current.end_of_word

    def delete(self, string: str) -> None:
        """
        Delete a string from the trie data structure.

        Calls a private method that passes the root node and an
        index counter along with the string to be deleted.
        """
        self._delete(string, 0, self.root)

    def _delete(self, string: str, index: int, node: TrieNode) -> bool:
        """
        Private method that delete a string from the trie.

        The method returns a boolean that states whether the next
        child node should be deleted or not. A child node can only
        be deleted if it does not have any children of its own.

        If the string has been traversed completely, a check needs
        to be done whether the node has the end of word boolean set
        as true or not.
        If the boolean is set to true, it needs to be set as false
        to indicate the removal of the word from the trie. True is
        returned if the current node does not have children.
        Whenever a traversal cannot be completed, it means that the
        string is not present in the trie and hence false is returned,
        indicating that no further action is required.

        However, if a signal is received that says that the child
        node should be deleted, the current node removes the current
        character entry from its children dictionary, and sends a
        boolean signal saying whether the current node's children
        dictinary is empty or not.
        """
        if index == len(string):
            if not node.end_of_word:
                return False
            node.end_of_word = False
            return len(node.children) == 0
        char = string[index]
        if char in node.children:
            next_node = node.children[char]
        else:
            return False
        should_delete_node = self._delete(string, index + 1, next_node)
        if should_delete_node:
            node.children.pop(char)
            return len(node.children) == 0
        return False


def main():
    trie = Trie()

    trie.insert('abc')
    trie.insert('abcde')

    print(trie.search('abc'))       # True
    print(trie.search('abcde'))     # True

    trie.delete('abc')

    print(trie.search('abc'))       # False
    print(trie.search('abcde'))     # True

    trie.delete('abcde')

    print(trie.search('abc'))       # False
    print(trie.search('abcde'))     # False


if __name__ == "__main__":
    main()
