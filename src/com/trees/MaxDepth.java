package com.trees;

import com.TreeNode;

/**
 * Created by hattur on 10/30/17.
 */
public class MaxDepth {

    private int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
