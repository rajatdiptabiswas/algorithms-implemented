class ReverseLinkedList { 
  
    static Node head;

    static class Node { 
        int data; 
        Node next; 
  
        Node(int data) { 
            this.data = data; 
            this.next = null; 
        } 
    } 
  
    /** 
     * Reverse the linked list iteratively.
     * */
    Node reverseIterative(Node node) { 
        if (node == null || node.next == null) {
            return node;
        }
        
        Node prev = null;
        Node curr = node;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;

        return head;
    }

    /**
     * Reverse the linked list recursively.
     * 
     * Separate the linked list into two parts.
     * current node + rest of the list
     * Rest of the linked list has already been reversed recursively. 
     * 
     * The recursive call returns the new head.
     * Set the value of head to the return value of recursion.
     * 
     * e.g.
     * 
     * Input: 
     * 1 → 2 → 3 → 4 → 5 → null
     * 
     * Steps:
     * 1 → ( 2 ← 3 ← 4 ← 5 )
     * 
     * 1.next = 2
     * 2.next should be equal to 1
     * 1.next should be null
     * 
     * 1.next.next = 1
     * 1.next = null
     * 
     * Output:
     * null ← 1 ← 2 ← 3 ← 4 ← 5
     */
    Node reverseRecursive(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node rest = reverseRecursive(node.next);
        node.next.next = node;
        node.next = null;

        return rest;
    }

    /**
     * Reverse the linked list using tail recursion.
     */
    Node reverseTailRecursive(Node node) {        
        return reverseTailRecursive(null, node);
    }

    private Node reverseTailRecursive(Node prev, Node curr) {
        if (curr == null) {
            Node head = prev;
            return head;
        }

        Node next = curr.next;
        curr.next = prev;
        
        return reverseTailRecursive(curr, next);
    }
  
    /** 
     * Print the contents of the linked list.
     */
    void printList(Node node) 
    { 
        while (node != null) { 
            System.out.print(node.data + " → "); 
            node = node.next; 
        }
        System.out.print("null");
        System.out.println();
    } 
  
    public static void main(String[] args) 
    { 
        ReverseLinkedList list = new ReverseLinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
  
        System.out.println("\nGiven linked list"); 
        list.printList(head); 
        
        // head = list.reverseIterative(head);
        // head = list.reverseRecursive(head);
        head = list.reverseTailRecursive(head);

        System.out.println("\nReversed linked list"); 
        list.printList(head);
    } 
} 