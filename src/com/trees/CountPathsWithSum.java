package com.trees;

import com.TreeNode;

import java.util.HashMap;

/**
 * Created by hattur on 11/3/17.
 */
public class CountPathsWithSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);

        TreeNode five = new TreeNode(5);
        TreeNode minusThree = new TreeNode(-3);

        TreeNode three = new TreeNode(3);
        TreeNode one = new TreeNode(1);
        TreeNode eleven = new TreeNode(11);

        TreeNode threethree = new TreeNode(3);
        TreeNode minus2 = new TreeNode(-2);
        TreeNode two = new TreeNode(2);

        root.left = five;
        root.right = minusThree;
        minusThree.right = eleven;

        five.left = three;
        five.right = one;
        one.right = two;

        three.left = threethree;
        three.right = minus2;

        int paths = countPathsWithSum(root, 8);
        System.out.println(paths);


    }
    private static int countPathsWithSum(TreeNode root, int targetSum) {
        return countPathsWithSum(root, targetSum, 0, new HashMap<Integer, Integer>());
    }

    private static int countPathsWithSum(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
        if(node == null) {
            return 0;
        }

        runningSum += node.data;
        int sum = runningSum - targetSum;
        int totalPaths = pathCount.getOrDefault(sum, 0);

        if(runningSum == targetSum) {
            totalPaths ++;
        }

        incrementHashTable(pathCount, runningSum, 1);
        totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
        totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
        incrementHashTable(pathCount, runningSum, -1);

        return totalPaths;
    }

    private static void incrementHashTable(HashMap<Integer, Integer> pathCount, int key, int delta) {
        int newCount = pathCount.getOrDefault(key, 0) + delta;
        if(newCount == 0) {
            pathCount.remove(key);
        }
        else {
            pathCount.put(key, newCount);
        }
    }

}
