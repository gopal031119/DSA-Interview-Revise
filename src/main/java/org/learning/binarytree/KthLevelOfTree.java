package org.learning.binarytree;

public class KthLevelOfTree {
    static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    /**
     * Time Complexity - O(n)
     * 
     * @param root
     * @param level
     * @param k
     */
    private static void kthLevel(Node root, int level, int k) {
        if( root == null){
            return;
        }
        if (level == k){
            System.out.print(root.data + " ");
            return;
        }
        kthLevel(root.left, level+1, k);
        kthLevel(root.right, level+1, k);
    }
    
    public static void main(String args[]){
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right = new Node(3);
        tree.right.right = new Node(6);

        kthLevel(tree, 1 , 3);
    }
}
