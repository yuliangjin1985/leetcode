package binarytree;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * Note: A leaf is a node with no children.
 *
 * Example 1:
 *  Input: [1,2,3]
 *     1
 *    / \
 *   2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 *
 *Example 2:
 *
 * Input: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 */

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

public class LC129 {

  public static void main(String[] args) {

    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(9);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(8);
    root.left.left.left = new TreeNode(1);
    System.out.println(sumNumbers(root));

  }

  private static int sumNumbers(TreeNode root) {
    if(root == null) return 0;

    StringBuilder str = new StringBuilder();
    str.append(root.val);
    List<Integer> paths = new LinkedList<>();

    helper(root, str, paths);

    int sum = 0;

    for (Integer path : paths) {
      sum += path;
    }

    return sum;
  }

  //Use StringBuilder to back track
  private static void helper(TreeNode node, StringBuilder str, List<Integer> paths) {
    if(node.left == null && node.right == null) {
      paths.add(Integer.valueOf(str.toString()));
    }

    if(node.left != null) {
      str.append(node.left.val);
      helper(node.left, str, paths);
      str.setLength(str.length() - 1);
    }

    if(node.right != null) {
      str.append(node.right.val);
      helper(node.right, str, paths);
      str.setLength(str.length() - 1);
    }
  }
}
