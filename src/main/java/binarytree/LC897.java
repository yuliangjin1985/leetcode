package binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LC897 {

    TreeNode pre=null, head=null;
    public TreeNode increasingBST(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;
        while(node != null || !stack.isEmpty()) {
            if(node != null) {
                stack.push(node);
                node = node.left;
            } else if(!stack.isEmpty()) {
                node = stack.pop();
                if(node != null) {
                    queue.offer(node);
                    stack.push(node.right);
                    node = node.right;
                }

            }
        }

        TreeNode ret = new TreeNode(-1);
        TreeNode n = ret;
        System.out.println(queue.size());
        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            temp.left = null;
            n.right = temp;
            n = n.right;
        }

        return ret.right;
    }
}
