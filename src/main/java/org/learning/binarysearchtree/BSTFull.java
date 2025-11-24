package org.learning.binarysearchtree;

public class BSTFull {

    public static void main(String[] args) {

        Node root = null;

        // -----------------------------
        // Insert nodes into BST
        // -----------------------------
        int[] values = {8, 3, 10, 1, 6, 14, 4, 7};
        for (int val : values) {
            root = insert(root, val);
        }

        System.out.println("Inorder Traversal (sorted):");
        inorder(root);
        System.out.println();

        // -----------------------------
        // Search in BST
        // -----------------------------
        System.out.println("\nSearch 6: " + search(root, 6));
        System.out.println("Search 20: " + search(root, 20));

        // -----------------------------
        // Delete nodes
        // -----------------------------
        System.out.println("\nDeleting 3...");
        root = delete(root, 3);

        System.out.println("Inorder after deletion:");
        inorder(root);
        System.out.println();

        System.out.println("\nValues between 4 and 10:");
        printInRange(root, 4, 10);
        System.out.println();

    }

    // ---------------------------------------------------------
    // INSERT in BST
    // ---------------------------------------------------------
    public static Node insert(Node root, int key) {
        // If tree is empty, create new node
        if (root == null) {
            return new Node(key);
        }

        // If key is smaller → go to left subtree
        if (key < root.data) {
            root.left = insert(root.left, key);
        }
        // If key is larger → go to right subtree
        else if (key > root.data) {
            root.right = insert(root.right, key);
        }

        // If equal, do nothing (BST has unique values)
        return root;
    }

    // ---------------------------------------------------------
    // SEARCH in BST (recursive)
    // ---------------------------------------------------------
    public static boolean search(Node root, int key) {
        if (root == null) return false;
        if (root.data == key) return true;

        if (key < root.data)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    // ---------------------------------------------------------
    // DELETE node from BST
    // ---------------------------------------------------------
    public static Node delete(Node root, int key) {

        if (root == null)
            return null;

        // Step 1: Search for the node
        if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else {

            // 💀 Found the node to delete

            // Case 1: Node has NO child (leaf)
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: Node has ONE child
            if (root.left == null)
                return root.right;

            if (root.right == null)
                return root.left;

            // Case 3: Node has TWO children
            // Replace node with inorder successor (smallest in right subtree)
            Node successor = findMin(root.right);
            root.data = successor.data;

            // Delete successor from right subtree
            root.right = delete(root.right, successor.data);
        }

        return root;
    }

    // Find minimum value node in a BST (used for deletion)
    public static Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // ---------------------------------------------------------
    // INORDER TRAVERSAL (Left, Root, Right)
    // Produces sorted order → best way to verify tree
    // ---------------------------------------------------------
    public static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Print all nodes whose values are within [low, high]
    public static void printInRange(Node root, int low, int high) {

        // If tree is empty → nothing to print
        if (root == null) return;

        // If root.data is greater than low,
        // then nodes in the LEFT subtree *may* fall in range
        if (root.data > low) {
            printInRange(root.left, low, high);
        }

        // If root.data itself is within the range → print it
        if (root.data >= low && root.data <= high) {
            System.out.print(root.data + " ");
        }

        // If root.data is less than high,
        // then nodes in the RIGHT subtree *may* fall in range
        if (root.data < high) {
            printInRange(root.right, low, high);
        }
    }

    private void printInRangeRec(Node root, int low, int high) {
        if (root == null) return;

        // Case 1: too small → go right
        if (root.data < low) {
            printInRangeRec(root.right, low, high);
        }
        // Case 2: too large → go left
        else if (root.data > high) {
            printInRangeRec(root.left, low, high);
        }
        // Case 3: in range → print + explore both
        else {
            printInRangeRec(root.left, low, high);
            System.out.print(root.data + " ");
            printInRangeRec(root.right, low, high);
        }
    }


}

