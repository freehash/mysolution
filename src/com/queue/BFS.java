package com.queue;

import com.TreeNode;

import java.util.*;

/**
 * Created by hattur on 10/15/17.
 */
public class BFS {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(6);
        TreeNode node31 = new TreeNode(10);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node31;
        node2.left = node4;
        node2.right = node5;

        /*TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        root.left = two;
        root.right = three;
        two.left = four;
        three.right = five;*/



        //doBfs(root);
        List<List<Integer>> lists = zigzagLevelOrder(root);
        System.out.println(lists);

        List<List<Integer>> lists1 = anotherLevelOrder(root);
        System.out.println(lists1);

    }

    private static void doBfs(TreeNode root) {
        MyQueue<TreeNode> myQueue = new MyQueue<TreeNode>();
        myQueue.add(root);

        while(!myQueue.isEmpty()) {
            TreeNode node = myQueue.remove();
            visit(node);
            TreeNode left = node.left;
            if(left != null) {
                myQueue.add(left);
            }

            TreeNode right = node.right;
            if(right != null) {
                myQueue.add(right);
            }
        }
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

    private static List<List<Integer>> bottomUpLevelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
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
            stack.push(levelNodes);
        }

        while(!stack.isEmpty()) {
            levelOrder.add(stack.pop());
        }
        return levelOrder;
    }

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 0;
        boolean isReverse = false;
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
            if(isReverse) {
                Collections.reverse(levelNodes);
            }
            levelOrder.add(levelNodes);
            isReverse = !isReverse;
        }
        return levelOrder;
    }

    private static List<List<TreeNode>> doLevelOrder(TreeNode root) {
        MyQueue<TreeNode> myQueue = new MyQueue<>();
        myQueue.add(root);
        List<List<TreeNode>> nodes = new ArrayList<>();
        levelOrder(myQueue, nodes);
        Queue<Integer> queue = new LinkedList<>();
        return nodes;
    }



    private static void levelOrder(MyQueue<TreeNode> myQueue, List<List<TreeNode>> allNodes) {
        List<TreeNode> levelNodes = new ArrayList<>();
        while(!myQueue.isEmpty()) {
            TreeNode remove = myQueue.remove();
            levelNodes.add(remove);
        }

        for(int i = 0; i < levelNodes.size();i ++) {
            TreeNode treeNode = levelNodes.get(i);
            TreeNode left = treeNode.left;
            if(left != null) {
                myQueue.add(left);
            }

            TreeNode right = treeNode.right;
            if(right != null) {
                myQueue.add(right);
            }
        }
        allNodes.add(levelNodes);
        if(myQueue.isEmpty()) {
            return;
        }
        levelOrder(myQueue, allNodes);
    }

    private static void visit(TreeNode node) {
        System.out.print(node.data + " ");
    }
}


