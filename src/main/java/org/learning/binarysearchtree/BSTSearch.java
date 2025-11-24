package org.learning.binarysearchtree;

// Node class for Binary Search Tree
class Node {
    int data;      // value stored in the node
    Node left;     // pointer to left child
    Node right;    // pointer to right child

    Node(int data) {
        this.data = data;
    }
}

public class BSTSearch {

    public static void main(String[] args) {
        // Creating a simple BST manually:
        //
        //         8
        //        / \
        //       3   10
        //      / \    \
        //     1   6    14
        //
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);

        // Test search
        System.out.println(search(root, 6));   // true
        System.out.println(search(root, 15));  // false

        System.out.println(searchIterative(root, 10)); // true
    }

    // -------------------------------------------------------
    // 🔍 Recursive BST Search
    // -------------------------------------------------------
    public static boolean search(Node root, int key) {
        // If subtree is empty → key not found
        if (root == null)
            return false;

        // If current node matches the key → found
        if (root.data == key)
            return true;

        // If key is smaller than current node,
        // then search in the LEFT subtree
        if (key < root.data)
            return search(root.left, key);

        // If key is larger than current node,
        // then search in the RIGHT subtree
        return search(root.right, key);
    }

    // -------------------------------------------------------
    // 🔍 Iterative BST Search
    // (avoids recursion, efficient for large trees)
    // -------------------------------------------------------
    public static boolean searchIterative(Node root, int key) {

        // Loop until we either find the key or reach a null node
        while (root != null) {

            // Found the key
            if (root.data == key)
                return true;

            // If key is smaller, go LEFT
            if (key < root.data)
                root = root.left;

                // If key is larger, go RIGHT
            else
                root = root.right;
        }

        // We exited loop → key not found in tree
        return false;
    }
}
