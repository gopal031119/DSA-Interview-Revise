package org.learning.binarytree;

public class HeightOfTree {

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
        public static int height(Node root){
            if(root == null){
                return 0;
            }
            int ln = height(root.left);
            int rh = height(root.right);
            int height = Math.max(ln,rh) + 1;
            return height;
        }
    }

    public static void main(String args[]){
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree(nodes);
        System.out.println("Height by Nodes: "+ binaryTree.height(root));
        System.out.println("Height by Edges: "+(binaryTree.height(root)-1));
    }
}
