package com.trees;

import com.TreeNode;

/**
 * Created by hattur on 10/30/17.
 */
public class ConstructBST {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        TreeNode treeNode = sortedArrayToBST(nums);
        System.out.println(treeNode);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return constructBST(nums, 0, nums.length-1);
    }

    private static TreeNode constructBST(int[] nums, int left, int right) {
        if(left > right) {
            return null;
        }
        int mid = left + (right - left)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = constructBST(nums, left, mid-1);
        node.right = constructBST(nums, mid+1, right);
        return node;
    }

}
