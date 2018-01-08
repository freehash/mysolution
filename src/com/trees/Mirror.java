package com.trees;

import com.TreeNode;

/**
 * Created by hattur on 10/30/17.
 */
public class Mirror {

    private static boolean isMirror(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isSynchronous(root.left, root.right);
    }

    private static boolean isSynchronous(TreeNode a, TreeNode b) {
        if(a == null && b == null) {
            return true;
        }
        if(a == null || b == null) {
            return false;
        }
        return a.data == b.data && isSynchronous(a.left, b.right) && isSynchronous(a.right, b.left);
    }
}
