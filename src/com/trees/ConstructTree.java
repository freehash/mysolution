package com.trees;

import com.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hattur on 11/4/17.
 */
public class ConstructTree {

    public static void main(String[] args) {
        TreeNode tree = createTree();
        int[] preorder = {1,2,4,5,3,7};
        int[] inorder = {4,2,5,1,7,3};

        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public static TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.data) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }

    private static TreeNode createTree() {
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

        return root;
    }
}
