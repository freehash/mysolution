package com.trees;


import java.util.HashMap;

/**
 * Created by hattur on 10/18/17.
 */
public class TopView {
    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1("a");
        TreeNode1 b = new TreeNode1("b");
        TreeNode1 c = new TreeNode1("c");
        TreeNode1 d = new TreeNode1("d");
        TreeNode1 e = new TreeNode1("e");
        TreeNode1 f = new TreeNode1("f");
        TreeNode1 g = new TreeNode1("g");
        TreeNode1 l = new TreeNode1("l");
        TreeNode1 h = new TreeNode1("h");
        TreeNode1 i = new TreeNode1("i");
        TreeNode1 j = new TreeNode1("j");
        TreeNode1 k = new TreeNode1("k");

        root.left = b;
        root.right = c;

        b.left = d;
        b.right = e;

        d.left = l;

        c.left = f;
        c.right = g;

        f.left = h;
        f.right = i;
        i.right = j;
        j.right = k;


        HashMap<Integer, String> hdMap = new HashMap<>();
        getHorizontalDistance(root, hdMap, 0);
        System.out.println(hdMap);

    }

    private static void getHorizontalDistance(TreeNode1 root, HashMap<Integer, String> hdMap, int hd) {
        if(root != null) {
            if(!hdMap.containsKey(hd)) {
                hdMap.put(hd, root.data);
                System.out.print(root.data + " ");
            }

            getHorizontalDistance(root.left, hdMap, hd-1);
            getHorizontalDistance(root.right, hdMap, hd+1);
        }
    }
}
 class TreeNode1 {
    public String data;
    public TreeNode1 left, right;

    public TreeNode1(String data) {
        this.data = data;
    }
}
