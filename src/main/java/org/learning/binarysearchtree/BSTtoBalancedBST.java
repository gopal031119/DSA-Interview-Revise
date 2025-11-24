package org.learning.binarysearchtree;

import java.util.ArrayList;

public class BSTtoBalancedBST {

    // Node class
    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }
    }

    // -----------------------------
    // INSERT into BST (for testing)
    // -----------------------------
    public static Node insert(Node root, int key) {
        if (root == null) return new Node(key);

        if (key < root.data)
            root.left = insert(root.left, key);
        else
            root.right = insert(root.right, key);

        return root;
    }

    // -----------------------------
    // STEP 1: Inorder traversal to get sorted list
    // -----------------------------
    public static void inorder(Node root, ArrayList<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    // -----------------------------
    // STEP 2: Convert sorted list → Balanced BST
    // -----------------------------
    public static Node sortedListToBST(ArrayList<Integer> list, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        Node root = new Node(list.get(mid));

        root.left = sortedListToBST(list, start, mid - 1);
        root.right = sortedListToBST(list, mid + 1, end);

        return root;
    }

    // -----------------------------
    // Convert BST → Balanced BST
    // -----------------------------
    public static Node balanceBST(Node root) {
        ArrayList<Integer> list = new ArrayList<>();

        // Get sorted elements
        inorder(root, list);

        // Build balanced BST
        return sortedListToBST(list, 0, list.size() - 1);
    }

    // -----------------------------
    // Print inorder (sorted output)
    // -----------------------------
    public static void inorderPrint(Node root) {
        if (root == null) return;
        inorderPrint(root.left);
        System.out.print(root.data + " ");
        inorderPrint(root.right);
    }

    // -----------------------------
    // MAIN METHOD
    // -----------------------------
    public static void main(String[] args) {

        // Build an unbalanced BST
        Node root = null;
        root = insert(root, 8);
        root = insert(root, 6);
        root = insert(root, 5);
        root = insert(root, 3);
        root = insert(root, 2);
        root = insert(root, 1); // Very left-heavy unbalanced tree

        System.out.println("Original BST (Inorder):");
        inorderPrint(root);

        // Convert to Balanced BST
        Node balanced = balanceBST(root);

        System.out.println("\n\nBalanced BST (Inorder):");
        inorderPrint(balanced);
    }
}
