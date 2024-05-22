package org.learning.binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TopViewOfTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static class Info {
        Node node;
        int hd;

        public Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {
        Queue<Info> queue = new LinkedList<>();
        Map<Integer, Node> map = new HashMap<>();
        int min = 0, max = 0;

        queue.add(new Info(root, 0));
        queue.add(null);

        while (!queue.isEmpty()) {
            Info curr = queue.remove();
            if (curr == null) {
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.add(null);
                }
            } else {
                if (!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }
                if (curr.node.left != null) {
                    queue.add(new Info(curr.node.left, curr.hd - 1));
                    min = Math.min(curr.hd - 1, min);
                }
                if (curr.node.right != null) {
                    queue.add(new Info(curr.node.right, curr.hd + 1));
                    max = Math.max(curr.hd + 1, max);
                }
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
    }

    public static void main(String... args) {
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right = new Node(3);
        tree.right.right = new Node(6);

        topView(tree);
    }
}
