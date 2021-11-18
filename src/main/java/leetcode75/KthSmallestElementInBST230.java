package leetcode75;

import util.TreeNode;

public class KthSmallestElementInBST230 {
    int N = 0;
    int num;
    public int kthSmallest(TreeNode root, int k) {
        N = k;
        dfs(root);
        return num;
    }

    public void dfs(TreeNode node) {
        if(node == null) {
            return;
        }
        dfs(node.left);
        N--;
        if(N == 0) {
            num = node.val;
            return;
        }
        dfs(node.right);
    }
}
