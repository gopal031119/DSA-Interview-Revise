package org.learning.binarytree;

public class CountOfNodes {

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
        public static int count(Node root){
            if(root == null){
                return 0;
            }
            int leftCount = count(root.left);
            int rightCount = count(root.right);
            return leftCount + rightCount + 1;
        }
    }

    public static void main(String args[]){
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree(nodes);
        System.out.println(binaryTree.count(root));
        
    }
}
