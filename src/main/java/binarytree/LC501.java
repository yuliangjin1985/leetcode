package binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LC501 {

    Map<Integer, Integer> map = null;

    public int[] findMode(TreeNode root) {

        if(root == null) return null;
        map = new HashMap<>();
        inorder(root);
        int max = 0;
        for(int key : map.keySet()) {
            if(map.get(key) > max) max = key;
        }

        List<Integer> list = new LinkedList<>();
        for(int key : map.keySet()) {
            if(map.get(key) == max) {
                list.add(key);
            }
        }

        int[] ret = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            ret[i] = list.get(i);
        }

        return ret;
    }

    public void inorder(TreeNode node) {
        if(node.left != null) {
            inorder(node.left);
        }

        map.put(node.val, map.getOrDefault(node.val, 0) + 1);

        if(node.right != null) inorder(node.right);
    }

    public static void main(String[] args) {
        System.out.println(new LC501().findMode(new TreeNode(2147483647))[0]);
    }
}
