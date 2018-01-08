package com.trees;

import com.TreeNode;

/**
 * Created by hattur on 10/29/17.
 */
public class MergeBinaryTrees {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t1_2 = new TreeNode(2);
        TreeNode t1_3 = new TreeNode(3);
        TreeNode t1_5 = new TreeNode(5);
        t1.left = t1_3;
        t1.right = t1_2;
        t1_3.left = t1_5;

        TreeNode t2 = new TreeNode(2);
        TreeNode t2_1 = new TreeNode(1);
        TreeNode t2_3 = new TreeNode(3);
        TreeNode t2_4 = new TreeNode(4);
        TreeNode t2_7 = new TreeNode(7);
        t2.left = t2_1;
        t2.right = t2_3;
        t2_1.right = t2_4;
        t2_3.right = t2_7;

        TreeNode treeNode = mergeTrees(t1, t2);
        System.out.println(treeNode);

        int[] nums = new int[]{1,2,3,4};
        System.out.println(productExceptSelf(nums));
    }

    private static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return null;
        }

        int sum = 0;
        if(t1 != null) {
            sum += t1.data;
        }
        if(t2 != null) {
            sum += t2.data;
        }

        TreeNode node = new TreeNode(sum);
        node.left = mergeTrees(t1 != null ? t1.left : null, t2 != null ? t2.left: null);
        node.right = mergeTrees(t1 != null ? t1.right : null, t2 != null ? t2.right : null);

        return node;
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
