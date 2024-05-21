package org.learning.binarytree;

public class PreOrderTraversal {
    /**
     * 1. root
     * 2. left subtree
     * 3. right subtree
     */

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx=-1;

        /**
         * Time Complexity - O(n)
         * @param nodes
         * @return
         */
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        /**
         * Time Complexity - O(n)
         * @param root
         */
        public static void preOrder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void main(String args[]){
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree(nodes);
        System.out.println(root.data);
        binaryTree.preOrder(root);
    }
}
