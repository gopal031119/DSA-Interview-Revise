package org.learning.binarysearchtree;

public class LargestBSTinBT {

    // Node class
    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }
    }

    // Info object returned by recursion
    static class Info {
        int size;      // size of subtree
        int min;       // min value in subtree
        int max;       // max value in subtree
        boolean isBST; // is this subtree a BST?

        Info(int size, int min, int max, boolean isBST) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }

    static int maxBST = 0;

    // -------------------------------
    // FIND LARGEST BST
    // -------------------------------
    public static Info largestBST(Node root) {

        // 1️⃣ Base case
        if (root == null)
            return new Info(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);

        // Recurse left & right
        Info left = largestBST(root.left);
        Info right = largestBST(root.right);

        // 2️⃣ Compute size, min, max assuming current is BST temporarily
        int currSize = left.size + right.size + 1;
        int currMin = Math.min(root.data, left.min);
        int currMax = Math.max(root.data, right.max);

        // 3️⃣ Check BST condition last
        boolean isBST =
                left.isBST &&
                        right.isBST &&
                        (root.data > left.max) &&
                        (root.data < right.min);

        // If BST → update result
        if (isBST) {
            maxBST = Math.max(maxBST, currSize);
            return new Info(currSize, currMin, currMax, true);
        }

        // If not BST → return invalid info
        return new Info(0, 0, 0, false);
    }

    // -------------------------------
    // MAIN
    // -------------------------------
    public static void main(String[] args) {

        /*
               50
             /    \
           30      60
          / \     /  \
        5   20  45   70
                    / \
                   65 80
        */

        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(60);

        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        largestBST(root);
        System.out.println("Size of largest BST = " + maxBST);
    }
}
