package org.learning.binarytree;

public class DiameterOfTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Info {
        int diam;
        int height;

        Info(int diam, int height){
            this.diam = diam;
            this.height = height;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        /**
         * Time Complexity - O(n)
         *
         * @param nodes
         * @return
         */
        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        /**
         * Time Complexity - O(n2)
         *
         * @param root
         * @return
         */
        public static int diameter(Node root) {
            if (root == null) {
                return 0;
            }
            int ldiam = diameter(root.left);
            int lh = height(root.left);
            int rdiam = diameter(root.right);
            int rh = height(root.right);
            int selfDiam = lh + rh + 1;
            return Math.max(selfDiam, Math.max(ldiam, rdiam));
        }


        /**
         * Time complexity - O(n)
         *
         * @param root
         * @return
         */
        public static Info diameter2(Node root){
            if(root == null){
                return new Info(0,0);
            }
            Info leftInfo = diameter2(root.left);
            Info rightInfo = diameter2(root.right);

            int diam = Math.max(leftInfo.height+ rightInfo.height + 1, Math.max(leftInfo.diam, rightInfo.diam));
            int ht = Math.max(leftInfo.height, rightInfo.height) + 1;

            return new Info(diam, ht);
        }

        public static int height(Node root) {
            if (root == null) {
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh, rh) + 1;
        }
    }

    public static void main(String args[]) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree(nodes);
        System.out.println(binaryTree.diameter(root));
        System.out.println(binaryTree.diameter2(root).diam);
    }

}
