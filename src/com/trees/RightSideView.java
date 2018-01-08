package com.trees;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hattur on 10/19/17.
 */
public class RightSideView {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        root.left = two;
        root.right = three;
        two.right = five;
        //three.right = four;

        List<Integer> integers = rightSideView(root);
        System.out.println(integers);
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        int depth = 0;
        buildRightSideView(root, depth, result);
        return result;
    }

    private static void buildRightSideView(TreeNode root, int depth, List<Integer> result) {
        if(root == null) {
            return ;
        }
        if(result.size() == depth) {
            result.add(root.data);
        }

        buildRightSideView(root.right, depth + 1, result);
        buildRightSideView(root.left, depth + 1, result);

    }
}
