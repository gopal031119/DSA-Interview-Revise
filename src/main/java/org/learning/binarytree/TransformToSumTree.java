package org.learning.binarytree;

public class TransformToSumTree {
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

    public static int transform(Node root) {
        if(root == null){
            return 0;
        }
        
        int leftChild = transform(root.left);
        int rightChild = transform(root.right);
        
        int data = root.data;
        int newLeft = root.left == null? 0 : root.left.data;
        int newRight = root.right == null? 0 : root.right.data;
        root.data = newLeft + leftChild
                + newRight + rightChild;
        return data;
    }
    
    public static void preOrder(Node root){
        if(root== null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String args[]){
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right = new Node(3);
        tree.right.left = new Node(6);
        tree.right.right = new Node(7);

        transform(tree);
        preOrder(tree);
    }
}
