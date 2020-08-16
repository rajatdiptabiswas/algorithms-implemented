import java.util.*;
import java.io.*;
import java.lang.*;
import java.text.*;
import java.math.*;


class TreeTraversal {

    private TreeNode root;

    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode (int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public TreeTraversal () {
        this.root = new TreeNode(0);
    }

    public TreeNode getRoot() {
        return this.root;
    }

    public void InorderTraversalRecursive(TreeNode node) {

        if (node == null) {
            return;
        }

        InorderTraversalRecursive(node.left);
        System.out.print(node.value + " ");
        InorderTraversalRecursive(node.right);

    }

    public void InorderTraversalIterative(TreeNode node) {

        if (node == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = node;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            
            current = stack.pop();
            System.out.print(current.value + " ");
            
            current = current.right;
        }

    }

    public void PreorderTraversalRecursive(TreeNode node) {

        if (node == null) {
            return;
        }

        System.out.print(node.value + " ");
        PreorderTraversalRecursive(node.left);
        PreorderTraversalRecursive(node.right);

    }

    public void PreorderTraversalIterative(TreeNode node) {

        if (node == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current;

        stack.push(node);

        while (!stack.isEmpty()) {
            current = stack.pop();
            System.out.print(current.value + " ");
            
            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }
        }

    }

    public void PostorderTraversalRecursive(TreeNode node) {

        if (node == null) {
            return;
        }

        PostorderTraversalRecursive(node.left);
        PostorderTraversalRecursive(node.right);
        System.out.print(node.value + " ");

    }

    public void PostorderTraversalIterative(TreeNode node) {

        if (node == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = node;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    System.out.println(temp.value);
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        System.out.println(temp.value);
                    }
                } else {
                    current = temp;
                }
            }
        }

    }

    public static void main(String[] args) {

        TreeTraversal tree = new TreeTraversal();

        /**
         * Tree structure
         *               0
         *      1                2
         *  3       4        5       6
         *    7   8        9  10      11
         *                              12
         */

        tree.getRoot().left = new TreeNode(1);
        tree.getRoot().right = new TreeNode(2);
        tree.getRoot().left.left = new TreeNode(3);
        tree.getRoot().left.right = new TreeNode(4);
        tree.getRoot().right.left = new TreeNode(5);
        tree.getRoot().right.right = new TreeNode(6);
        tree.getRoot().left.left.right = new TreeNode(7);
        tree.getRoot().left.right.left = new TreeNode(8);
        tree.getRoot().right.left.left = new TreeNode(9);
        tree.getRoot().right.left.right = new TreeNode(10);
        tree.getRoot().right.right.right = new TreeNode(11);
        tree.getRoot().right.right.right.right = new TreeNode(12);

        System.out.println("\nInorder Traversal Recursive");
        tree.InorderTraversalRecursive(tree.getRoot());
        System.out.println();

        System.out.println("\nInorder Traversal Iterative");
        tree.InorderTraversalIterative(tree.getRoot());
        System.out.println();

        // System.out.println("\nPreorder Traversal Recursive");
        // tree.PreorderTraversalRecursive(tree.getRoot());
        // System.out.println();

        // System.out.println("\nPreorder Traversal Iterative");
        // tree.PreorderTraversalIterative(tree.getRoot());
        // System.out.println();

        // System.out.println("\nPostorder Traversal Recursive");
        // tree.PostorderTraversalRecursive(tree.getRoot());
        // System.out.println();

        // System.out.println("\nPostorder Traversal Iterative");
        // tree.PostorderTraversalIterative(tree.getRoot());
        // System.out.println();

    }

}