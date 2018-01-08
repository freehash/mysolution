package com.trees;

import com.TreeNode;

/**
 * Created by hattur on 10/30/17.
 */
public class SameTree {

    private boolean sameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        return p.data == q.data
                && sameTree(p.left, q.left)
                && sameTree(p.right, q.right);

    }
}
