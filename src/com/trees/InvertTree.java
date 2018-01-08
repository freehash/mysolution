package com.trees;

import com.TreeNode;

/**
 * Created by hattur on 11/11/17.
 */
public class InvertTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode two = new TreeNode(2);
        TreeNode seven = new TreeNode(7);
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        TreeNode nine = new TreeNode(9);

        root.left = two;
        root.right = seven;
        two.left = one;
        two.right = three;
        seven.left = six;
        seven.right = nine;

        TreeNode invert = invert(root);
        System.out.println(invert);
    }

    public static TreeNode invert(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = invert(root.right);
        root.right = invert(temp);

        return root;
    }
}
