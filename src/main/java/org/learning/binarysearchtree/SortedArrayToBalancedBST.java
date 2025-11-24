package org.learning.binarysearchtree;

public class SortedArrayToBalancedBST {

    // Node class
    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }
    }

    // -----------------------------
    // Convert Sorted Array → Balanced BST
    // -----------------------------
    public static Node arrayToBST(int[] arr, int start, int end) {
        if (start > end) return null;

        // Middle element becomes the root
        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);

        // Build left and right subtree
        root.left = arrayToBST(arr, start, mid - 1);
        root.right = arrayToBST(arr, mid + 1, end);

        return root;
    }

    // -----------------------------
    // Inorder traversal (should print sorted)
    // -----------------------------
    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // -----------------------------
    // Preorder traversal (to show structure)
    // -----------------------------
    public static void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // -----------------------------
    // MAIN METHOD
    // -----------------------------
    public static void main(String[] args) {

        // Sorted array
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        // Convert to Balanced BST
        Node root = arrayToBST(arr, 0, arr.length - 1);

        System.out.println("Inorder (sorted):");
        inorder(root);

        System.out.println("\nPreorder (shows tree structure):");
        preorder(root);
    }
}
