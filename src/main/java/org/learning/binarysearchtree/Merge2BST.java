package org.learning.binarysearchtree;

import java.util.ArrayList;

public class Merge2BST {

    // Node class
    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }
    }

    // -----------------------------
    // INORDER → stores sorted list
    // -----------------------------
    public static void inorder(Node root, ArrayList<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    // -----------------------------
    // MERGE 2 SORTED LISTS
    // -----------------------------
    public static ArrayList<Integer> mergeLists(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.size() && j < b.size()) {
            if (a.get(i) < b.get(j)) {
                merged.add(a.get(i++));
            } else {
                merged.add(b.get(j++));
            }
        }
        while (i < a.size()) merged.add(a.get(i++));
        while (j < b.size()) merged.add(b.get(j++));

        return merged;
    }

    // -----------------------------
    // BUILD BALANCED BST from sorted list
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
    // MERGE TWO BSTs
    // -----------------------------
    public static Node mergeBSTs(Node root1, Node root2) {

        // 1. Get inorder of both
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        inorder(root1, list1);
        inorder(root2, list2);

        // 2. Merge the two sorted lists
        ArrayList<Integer> merged = mergeLists(list1, list2);

        // 3. Convert merged list → Balanced BST
        return sortedListToBST(merged, 0, merged.size() - 1);
    }

    // -----------------------------
    // INORDER PRINT
    // -----------------------------
    public static void printInorder(Node root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    // -----------------------------
    // MAIN
    // -----------------------------
    public static void main(String[] args) {

        /*
          BST 1:          BST 2:
             2               9
           /   \           /   \
          1     4         7     12
        */

        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(7);
        root2.right = new Node(12);

        Node merged = mergeBSTs(root1, root2);

        System.out.println("Merged Balanced BST (Inorder):");
        printInorder(merged);
    }
}

