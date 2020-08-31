class BinarySearchTree {

    private TreeNode root;

    private class TreeNode {
        int value;
        TreeNode left, right;
        TreeNode(int val) {
            value = val;
            left = this.right = null;
        }
    }

    public BinarySearchTree() {
        root = null;
    }

    public TreeNode search(int key) {
        return search(root, key);
    }

    private TreeNode search(TreeNode node, int key) {
        if (node == null) {
            return node;
        }
        if (node.value > key) {
            return search(node.left, key);
        } else if (node.value < key) {
            return search(node.right, key);
        } else {
            return node;
        }
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    private TreeNode insert(TreeNode node, int key) {
        if (node == null) {
            return new TreeNode(key);
        }
        if (node.value > key) {
            node.left = insert(node.left, key);
        } else {
            node.right = insert(node.right, key);
        }
        return node;
    }

    private int findMinKey(TreeNode node) {
        TreeNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    private TreeNode delete(TreeNode node, int key) {
        if (node == null) {
            return node;
        }
        if (node.value > key) {
            node.left = delete(node.left, key);
        } else if (node.value < key) {
            node.right = delete(node.right, key);
        } else if (node.value == key) {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                int inorderSuccessor = findMinKey(node.right);
                node.value = inorderSuccessor;
                node.right = delete(node.right, inorderSuccessor);
            }
        }
        return node;
    }

    public void printPreorder() {
        printPreorder(root);
        System.out.println();
    }

    private void printPreorder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    public static void main(String[] args) {

        /**
         * Binary Search Tree
         * 
         * insert()
         * preorder traversal: 10 5 1 7 6 8 9 15 12 17
         *                                     10                                              
         *             ┌───────────────────────┴───────────────────────┐                       
         *             5                                              15                       
         * ┌───────────┴───────────┐                       ┌───────────┴───────────┐           
         * 1                       7                      12                      17           
         *                   ┌─────┴─────┐                                                     
         *                   6           8                                                     
         *                               └──┐                                                  
         *                                  9                                                  
         * 
         * delete(8)
         * preorder traversal: 10 5 1 7 6 9 15 12 17
         *                        10                       
         *             ┌───────────┴───────────┐           
         *             5                      15           
         *       ┌─────┴─────┐           ┌─────┴─────┐     
         *       1           7          12          17     
         *                ┌──┴──┐                          
         *                6     9                          
         * 
         * delete(5)
         * preorder traversal: 10 6 1 7 9 15 12 17
         *                        10                       
         *             ┌───────────┴───────────┐           
         *             6                      15           
         *       ┌─────┴─────┐           ┌─────┴─────┐     
         *       1           7          12          17     
         *                   └──┐                          
         *                       9                         
         * 
         * delete(15)
         * preorder traversal: 10 6 1 7 9 17 12
         *                        10                       
         *             ┌───────────┴───────────┐           
         *             6                      17           
         *       ┌─────┴─────┐           ┌─────┘           
         *       1           7          12                 
         *                   └──┐                          
         *                      9                          
         */

        BinarySearchTree bst = new BinarySearchTree();
        
        bst.insert(10);
        bst.insert(5);
        bst.insert(1);
        bst.insert(7);
        bst.insert(6);
        bst.insert(8);
        bst.insert(9);
        bst.insert(15);
        bst.insert(12);
        bst.insert(17);
        bst.printPreorder();

        bst.delete(8);
        bst.printPreorder();

        bst.delete(5);
        bst.printPreorder();

        bst.delete(15);
        bst.printPreorder();

    }

}