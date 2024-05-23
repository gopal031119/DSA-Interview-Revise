package org.learning.binarytree;

import java.util.ArrayList;

public class LowestCommonAncestor {
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
     * TC - O(N) , SC- O(N)
     * @param root
     * @param n1
     * @param n2
     * @return
     */
    public static Node lca(Node root, int n1, int n2){

        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        
        getPath(root ,n1,  path1);
        getPath(root,n2, path2);
        
        int i=0;
        for(;i<path1.size() && i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }
        return path1.get(i-1);
    }
    
    public static boolean getPath(Node root, int n, ArrayList<Node> list){
        if(root==null){
            return false;
        }
        
        list.add(root);
        
        if(root.data == n){
            return true;
        }
        
        boolean foundLeft = getPath(root.left, n, list);
        boolean foundRight = getPath(root.right, n, list);
        
        if(foundLeft || foundRight){
            return true;
        }
        list.remove(list.size()-1);
        return false;
    }

    /**
     * TC- O(n) / SC- O(1)
     * @param root
     * @param n1
     * @param n2
     * @return
     */
    public static Node lca2(Node root, int n1, int n2){
        
        if(root == null){
            return null;
        }
        if(root.data==n1 || root.data == n2){
            return root;
        }
        
        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);
        
        //leftLca = val , rightLca= null
        if(rightLca == null){
            return leftLca;
        }
        if(leftLca == null){
            return rightLca;
        }
        return root;
    }
    public static void main(String args[]){
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right = new Node(3);
        tree.right.right = new Node(6);

        System.out.println(lca(tree, 5,4).data);
        System.out.println(lca2(tree, 5,4).data);
    }
}
