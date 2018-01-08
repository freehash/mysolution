package com;

import java.util.ArrayList;
import java.util.LinkedList;

public class BstSequences {
    public static void main(String args[]) {
        BstSequences bst = new BstSequences();
        TreeNode treeNode = bst.createTreeNode();
        ArrayList<LinkedList<Integer>> linkedLists = bst.allSequences(treeNode);

        for(int i = 0; i < linkedLists.size(); i ++) {
            bst.printList(linkedLists.get(i));
            System.out.println();
        }

    }

    public ArrayList<LinkedList<Integer>> allSequences(TreeNode node) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();

        if(node == null) {
            result.add(new LinkedList<Integer>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(node.data);

        ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);

        for(LinkedList<Integer> left : leftSeq) {
            for(LinkedList<Integer> right : rightSeq) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveLists(left,right,weaved,prefix);
                result.addAll(weaved);
            }
        }

        return result;
    }

    private void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
                            ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
        if(first.size() == 0 || second.size() == 0){
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);

    }

    private TreeNode createTreeNode() {
        TreeNode node50 = new TreeNode(50);
        TreeNode node20 = new TreeNode(20);
        TreeNode node60 = new TreeNode(60);
        TreeNode node10 = new TreeNode(10);
        TreeNode node25 = new TreeNode(25);
        TreeNode node70 = new TreeNode(70);

        node50.left = node20;
        node50.right = node60;
        node20.left = node10;
        node20.right = node25;
        node60.right = node70;

        node60.left = null;
        node10.left = null;
        node10.right = null;
        node25.left = null;
        node25.right = null;

        return node50;
    }

    private void printList(LinkedList<Integer> nodes) {
        for(int i = 0; i < nodes.size(); i++) {
            System.out.print(nodes.get(i) + " ");
        }
    }



}
