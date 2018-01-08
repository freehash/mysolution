package com.trees;

import com.TreeNode;

/**
 * Created by hattur on 11/15/17.
 */
public class Flatten {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode five = new TreeNode(5);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);

        root.left = two;
        root.right = five;
        two.left = three;
        two.right = four;
        five.right = six;
        five.left = seven;

        flatten(root);
        System.out.println(root);


    }

    public static void flatten(TreeNode root) {
        convert(root);
    }

    public static void preorder(TreeNode root) {
        if(root != null) {
            System.out.println(root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static TreeNode convert(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode part1 = convert(root.left);
        TreeNode part2 = convert(root.right);

        if(part1 != null && part2 != null) {
            concat(root, part1);
            appendToTail(part1, part2);

        }
        if(part1 == null && part2 != null) {
            concat(root, part2);

        }
        else if(part2 == null && part1 != null) {
            concat(root, part1);
        }

        return root;

    }

    private static void appendToTail(TreeNode x, TreeNode y) {
        while(x.right != null) {
            x = x.right;
        }
        x.right = y;
        //y.left = x;
        x.left = null;
    }

    private static void concat(TreeNode x, TreeNode y) {
        x.right = y;
        //y.left = x;
        x.left = null;
    }
}
