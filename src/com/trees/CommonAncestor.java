package com.trees;

import com.TreeNode;

/**
 * Created by hattur on 10/17/17.
 */
public class CommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode one = new TreeNode(1);
        TreeNode five = new TreeNode(5);
        TreeNode eight = new TreeNode(8);
        TreeNode seven = new TreeNode(7);

        root.left = one;
        root.right = five;
        five.right = eight;

        TreeNode treeNode = commonAncestor(root, five, seven);
        System.out.println(treeNode.data);
    }

    private static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Result r = commonAncestorHelper(root, p, q);
        if(r.isAncestor) {
            return r.node;
        }
        return null;
    }

    private static Result commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return new Result(null, false);
        }
        if(root == p && root == q) {
            return new Result(root, true);
        }

        Result rx = commonAncestorHelper(root.left, p, q);
        if(rx.isAncestor) {
            return rx;
        }

        Result ry = commonAncestorHelper(root.right, p, q);
        if(ry.isAncestor) {
            return ry;
        }

        if(rx.node != null && ry.node != null) {
            return new Result(root, true);
        }
        else if(root == p || root == q) {
            boolean isAncestor = rx.node != null || ry.node != null;
            return new Result(root, isAncestor);
        }
        else {
            return new Result(rx.node != null ? rx.node : ry.node, false);
        }

    }
}
class Result {
    public TreeNode node;
    public boolean isAncestor;
    public Result(TreeNode node, boolean isAncestor) {
        this.node = node;
        this.isAncestor = isAncestor;
    }
}
