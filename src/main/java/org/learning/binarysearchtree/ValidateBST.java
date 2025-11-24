package org.learning.binarysearchtree;

public class ValidateBST {

    // Node class
    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }
    }

    // -----------------------------
    // VALIDATE BST
    // -----------------------------
    public static boolean isBST(Node root) {
        return isBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isBSTUtil(Node root, long min, long max) {
        if (root == null) return true;

        // Check current node
        if (root.data <= min || root.data >= max) return false;

        // Recursion for left and right subtrees
        return isBSTUtil(root.left, min, root.data) &&
                isBSTUtil(root.right, root.data, max);
    }

    // -----------------------------
    // MAIN METHOD
    // -----------------------------
    public static void main(String[] args) {

        // Hardcoded BST
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);

        System.out.println("Is tree a BST? " + isBST(root));

        // Example of invalid BST
        Node invalidRoot = new Node(8);
        invalidRoot.left = new Node(10); // violates BST property
        invalidRoot.right = new Node(3);

        System.out.println("Is invalid tree a BST? " + isBST(invalidRoot));
    }
}
