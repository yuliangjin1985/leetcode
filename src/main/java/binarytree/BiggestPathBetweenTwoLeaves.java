package binarytree;

import java.util.HashMap;
import java.util.Map;

public class BiggestPathBetweenTwoLeaves {
    int max = 0;
    public int biggestPathBetweenTwoLeaves(TreeNode root) {
        dfs(root);
        return max;
    }
    public int[] dfs(TreeNode node) {
        if(node == null) {
            return new int[0];
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        max = Math.max(max, Math.max(left[0], left[1]) + Math.max(right[0], right[1]) + node.val);
        int[] temp = new int[2];
        temp[0] = Math.max(left[0], left[1]) + node.val;
        temp[1] = Math.max(right[0], right[1]) + node.val;
        return temp;
    }
}


