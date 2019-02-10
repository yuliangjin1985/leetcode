package array;

import java.util.Stack;

import binarytree.LC226;

class Solution {

  public static void main(String[] args) {
//    root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.right = new TreeNode(-3);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(2);
    root.right.right = new TreeNode(11);
    root.left.left.left = new TreeNode(3);
    root.left.left.right = new TreeNode(-2);
    root.left.right.right = new TreeNode(1);
    System.out.println(new Solution().pathSum(root, 8));
  }


  public Stack<TreeNode> nodes = new Stack<>();

  public int pathSum(TreeNode root, int sum) {
    int num = 0;
    getNodes(root);
    while(!nodes.isEmpty()) {
      TreeNode node = nodes.pop();
      num += pathSumRootIncluded(node, sum);
    }

    return num;

  }

  public void getNodes(TreeNode root) {
    if(root!= null) {
      nodes.push(root);
      getNodes(root.left);
      getNodes(root.right);
    }
  }

  public int pathSumRootIncluded(TreeNode root, int sum) {
    if(root == null) return 0;
    if(root.val == sum) return 1;
    else {
      return pathSum(root.left, sum - root.val) + pathSum(root.right, sum - root.val);
    }
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
