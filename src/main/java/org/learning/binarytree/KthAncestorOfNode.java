package org.learning.binarytree;

public class KthAncestorOfNode {
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

    public static int kthAncestor(Node root , int n, int k){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int leftDis = kthAncestor(root.left, n, k);
        int rightDis = kthAncestor(root.right, n, k);
        
        if(leftDis== -1 && rightDis == -1){
            return -1;
        }
        int max = Math.max(leftDis, rightDis);
        if(max+1==k){
            System.out.println(root.data);
        }
        return max+1;
    }

    public static void main(String args[]){
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right = new Node(3);
        tree.right.right = new Node(6);

        kthAncestor(tree, 5, 2);
    }
}
