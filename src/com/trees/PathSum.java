package com.trees;

import com.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hattur on 10/30/17.
 */
public class PathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode four = new TreeNode(4);
        TreeNode seven = new TreeNode(7);

        root.left = two;
        root.right = three;

        two.left = four;
        two.right = five;

        three.left = seven;

        //List<List<Integer>> paths = paths(root);
        //System.out.println(paths);
        System.out.println(hasPathWithSum(root, 0));
    }

    public boolean hasPathSum(TreeNode root, int sum)
    {
        if(root == null)
            return false;
        if(root.left == null && root.right == null && sum-root.data==0)
            return true;
        return hasPathSum(root.left, sum-root.data) || hasPathSum(root.right, sum-root.data);
    }

    private static boolean hasPathWithSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        int runningSum = 0;
        int sum = pathSum(root, runningSum, targetSum);
        return sum == targetSum;
    }

    private static int pathSum(TreeNode root, int runningSum, int targetSum) {
        if(root == null) {
            return Integer.MIN_VALUE;
        }
        runningSum += root.data;
        if(root.left == null && root.right == null) {
            return runningSum;
        }

        int leftSum = pathSum(root.left, runningSum, targetSum);
        if(leftSum == targetSum) {
            return leftSum;
        }
        int rightSum = pathSum(root.right, runningSum, targetSum);
        if(rightSum == targetSum) {
            return rightSum;
        }
        return Integer.MIN_VALUE;
    }



    private static List<List<Integer>> paths(TreeNode root) {
        List<List<Integer>> allPaths = new ArrayList<>();

        LinkedList<Integer> a = new LinkedList<>();


        if(root.left == null && root.right == null) {
            List<Integer> newPath = new ArrayList<>();
            newPath.add(root.data);
            allPaths.add(newPath);
            return allPaths;
        }

        if(root.left != null) {
            List<List<Integer>> leftPaths = paths(root.left);
            for(List<Integer> leftPath : leftPaths) {
                List<Integer> newLeftPath = new ArrayList<>();
                newLeftPath.add(root.data);
                newLeftPath.addAll(leftPath);
                allPaths.add(newLeftPath);
            }
        }

        if(root.right != null) {
            List<List<Integer>> rightPaths = paths(root.right);
            for(List<Integer> rightPath : rightPaths) {
                List<Integer> newRightPath = new ArrayList<>();
                newRightPath.add(root.data);
                newRightPath.addAll(rightPath);
                allPaths.add(newRightPath);
            }
        }

        return allPaths;
    }
}
