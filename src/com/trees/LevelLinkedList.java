package com.trees;

import com.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by hattur on 10/31/17.
 */
public class LevelLinkedList {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);

        root.left = two;
        root.right = three;
        two.left = five;

        ArrayList<LinkedList<TreeNode>> levelLinkedList = createLevelLinkedList(root);
        List<List<Integer>> lists = anotherLevelOrder(root);
        System.out.println(levelLinkedList);
    }
    private static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();
        if(root != null) {
            current.add(root);
        }
        while(current.size() > 0) {
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();
            for(TreeNode parent : parents) {
                if(parent.left != null) {
                    current.add(parent.left);
                }
                if(parent.right != null) {
                    current.add(parent.right);
                }
            }
        }
        return result;
    }

    private static List<List<Integer>> anotherLevelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 0;
        while(!queue.isEmpty()) {
            size = queue.size();
            List<Integer> levelNodes = new ArrayList<>();
            for(int i = 0;i < size; i++) {
                TreeNode poll = queue.poll();
                if(poll.left != null) {
                    queue.add(poll.left);
                }
                if(poll.right != null) {
                    queue.add(poll.right);
                }
                levelNodes.add(poll.data);
            }
            levelOrder.add(levelNodes);
        }
        return levelOrder;
    }
}
