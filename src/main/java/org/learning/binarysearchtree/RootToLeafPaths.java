package org.learning.binarysearchtree;

import java.util.ArrayList;

public class RootToLeafPaths {

    // Node class
    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }
    }

    // -----------------------------
    // PRINT ROOT TO LEAF PATHS USING ArrayList
    // -----------------------------
    public static void printRootToLeafPaths(Node root) {
        ArrayList<Integer> path = new ArrayList<>();
        printPathsRec(root, path);
    }

    private static void printPathsRec(Node root, ArrayList<Integer> path) {
        if (root == null) return;

        // Add current node to path
        path.add(root.data);

        // If it's a leaf → print path
        if (root.left == null && root.right == null) {
            System.out.println(pathToString(path));
        } else {
            // Recurse left and right
            printPathsRec(root.left, path);
            printPathsRec(root.right, path);
        }

        // Backtrack → remove current node
        path.remove(path.size() - 1);
    }

    // Helper to convert path list to string
    private static String pathToString(ArrayList<Integer> path) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i));
            if (i < path.size() - 1) sb.append(" -> ");
        }
        return sb.toString();
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

        System.out.println("Root-to-Leaf Paths:");
        printRootToLeafPaths(root);
    }
}
