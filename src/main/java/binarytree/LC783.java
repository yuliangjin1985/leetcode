package binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LC783 {

    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(node != null || !stack.isEmpty()) {
            if(node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode top = stack.pop();
                list.add(top.val);
                node = top.right;
            }
        }

        int diff = Integer.MAX_VALUE;

        for(int i=0;i<list.size()-1;i++) {
            diff = Math.min(diff, list.get(i+1) - list.get(i));
        }

        return diff;
    }

}
