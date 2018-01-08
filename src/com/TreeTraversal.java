package com;

import java.util.ArrayList;
import java.util.List;

public class TreeTraversal {

    public static void main(String args[]) {
        TreeTraversal traversal = new TreeTraversal();
        TreeNode treeNode = traversal.createTreeNode();
        traversal.inOrder(treeNode);
        System.out.println();
        traversal.preOrder(treeNode);
        System.out.println();
        traversal.postOrder(treeNode);
        System.out.println();
        System.out.println();

        /*TreeNode treeNode1 = traversal.createTreeNode1();
        traversal.preOrder(treeNode1);
        System.out.println();
        traversal.postOrder(treeNode1);

        List<Integer> integers = traversal.rightSideView(treeNode);
        System.out.println(integers);*/
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.data);
        }

        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);

    }

    private void inOrder(TreeNode node) {
        if(node != null) {
            inOrder(node.left);
            visit(node);
            inOrder(node.right);
        }
    }

    private void preOrder(TreeNode node) {
        if(node != null) {
            visit(node);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    private void postOrder(TreeNode node) {
        if(node != null) {
            postOrder(node.left);
            postOrder(node.right);
            visit(node);
        }
    }

    private void visit(TreeNode node) {
        System.out.print(node.data + " ");
    }

    private TreeNode createTreeNode() {
        /*TreeNode root = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn5 = new TreeNode(5);

        root.left = tn2;
        root.right = tn3;
        tn2.right = tn5;
        //tn3.right = tn4;

        return root;*/

        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode four = new TreeNode(4);
        TreeNode seven = new TreeNode(7);

        /*root.left = two;
        root.right = three;

        two.left = four;
        two.right = five;

        three.left = seven;*/

        root.left = two;
        two.left = four;
        four.left = five;
        five.left = three;
        three.left = seven;

        return root;

    }

    private TreeNode createTreeNode2() {
        TreeNode root = new TreeNode(8);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn6 = new TreeNode(6);
        TreeNode tn10 = new TreeNode(10);
        TreeNode tn9 = new TreeNode(9);
        TreeNode tn20= new TreeNode(20);

        root.left = tn4;
        root.right = tn10;

        tn4.left = tn2;
        tn4.right = tn6;

        tn10.left = tn9;
        tn10.right = tn20;

        return root;
    }

    private TreeNode createTreeNode1() {
        TreeNode root = new TreeNode(4);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn6 = new TreeNode(6);

        root.left = tn2;
        root.right = tn6;


        return root;
    }
}
