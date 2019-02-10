package binarytree;

/**
Invert a binary tree.

    Example:

    Input:

    4
    /   \
    2     7
    / \   / \
    1   3 6   9
    Output:

    4
    /   \
    7     2
    / \   / \
    9   6 3   1

 */

public class LC226 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

  public TreeNode invertTree(TreeNode root) {
    if(root == null) return root;
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    invertTree(root.left);
    invertTree(root.right);
    return root;

//         Queue<TreeNode> queue = new LinkedList();

//         // queue.offer(root);
//         queue.add(root);

//         while(!queue.isEmpty()) {
//             TreeNode node = queue.poll();
//             TreeNode left = node.left, right = node.right;
//             node.left = right; node.right = left;
//             // if(left != null) queue.offer(left);
//             // if(right != null) queue.offer(right);
//             if(left != null) queue.add(left);
//             if(right != null) queue.add(right);
//         }
//         return root;
  }
}
