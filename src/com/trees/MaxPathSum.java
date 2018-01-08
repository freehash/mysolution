package com.trees;

import com.TreeNode;

/**
 * Created by hattur on 11/10/17.
 */
public class MaxPathSum {

    static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode five = new TreeNode(5);
        TreeNode minusThree = new TreeNode(-3);
        TreeNode eleven = new TreeNode(11);
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1);
        TreeNode three2 = new TreeNode(3);
        TreeNode minusTwo = new TreeNode(-2);

        root.left = five;
        root.right = minusThree;
        minusThree.right = eleven;

        five.left = three;
        five.right = two;
        two.right = one;

        three.left = three2;
        three.right = minusTwo;


        int pathSum = getPathSum(root);
        System.out.println(pathSum);
    }


    private static int getPathSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftPathSum = Math.max(0,getPathSum(root.left));
        int rightPathSum = Math.max(0,getPathSum(root.right));
        maxSum = Math.max(maxSum, leftPathSum + rightPathSum + root.data);

        return Math.max(leftPathSum, rightPathSum) + root.data;
    }
}
