package org.learning.binarysearchtree;

public class MirrorBST {

    // Node class
    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }
    }

    // -----------------------------
    // MIRROR THE TREE
    // Swap left and right subtrees recursively
    // -----------------------------
    public static Node mirror(Node root) {
        if (root == null) return null;

        // Mirror subtrees
        Node leftMirror = mirror(root.left);
        Node rightMirror = mirror(root.right);

        // Swap left and right
        root.left = rightMirror;
        root.right = leftMirror;

        return root;
    }

    // -----------------------------
    // INORDER TRAVERSAL (to print tree)
    // -----------------------------
    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // -----------------------------
    // MAIN METHOD
    // -----------------------------
    public static void main(String[] args) {

        // Hardcoded BST
        //         8
        //       /   \
        //      3     10
        //     / \      \
        //    1   6      14

        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);

        System.out.println("Original Tree (Inorder):");
        inorder(root);

        // Mirror the BST
        mirror(root);

        System.out.println("\n\nMirrored Tree (Inorder):");
        inorder(root);
    }
}
