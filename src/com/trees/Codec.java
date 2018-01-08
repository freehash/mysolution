package com.trees;

import com.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hattur on 10/28/17.
 */
public class Codec {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode root1 = null;

        root.left = two;
        root.right = three;
        three.left = four;
        three.right = five;

        StringBuilder sb = new StringBuilder();
        System.out.println(serialize(root1, sb));
        TreeNode node = deserialize(sb.toString());
        System.out.println(node);
    }

    public static String serialize(TreeNode root, StringBuilder sb) {
        if(root != null) {
            sb.append(root.data);
            sb.append(",");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
        else {
            sb.append("X");
            sb.append(",");
        }
        return sb.toString();
    }

    public static TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for(String node : nodes) {
            queue.add(node);
        }
        return deserialize(queue);
    }

    private static TreeNode deserialize(Queue<String> queue) {
        TreeNode node;
        if(!queue.isEmpty()) {
            String nodeData = queue.poll();
            if(!nodeData.equals("X")) {
                node = new TreeNode(Integer.valueOf(nodeData));
                node.left = deserialize(queue);
                node.right = deserialize(queue);
                return node;
            }
        }
        return null;
    }
}
