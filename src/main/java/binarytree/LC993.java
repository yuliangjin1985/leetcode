package binarytree;


import java.util.LinkedList;
import java.util.Queue;

public class LC993 {

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root.val == x || root.val == y) return false;

        queue.offer(root);

        boolean foundX = false, foundY = false;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                TreeNode node = queue.poll();

                if(node.left != null && node.right != null) {
                    if(node.left.val == x && node.right.val == y || node.left.val == y && node.right.val == x) return false;
                }

                if(node.val == x) {
                    foundX = true;
                }

                if(node.val == y) {
                    foundY = true;
                }

                if(node.left != null) queue.offer(node.left);

                if(node.right != null) queue.offer(node.right);
                size--;
            }

            if(foundX && foundY) return true;

            if(foundX || foundY) return false;
        }
        return false;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}


