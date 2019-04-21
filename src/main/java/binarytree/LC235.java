package binarytree;

public class LC235 {

    /**
     * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
     *
     * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants
     * (where we allow a node to be a descendant of itself).”
     */

    public TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {
        if( (root.val - p.val) * (root.val - q.val) > 0) {
            return root.val > p.val ? lowestCommonAncestorRecursive(root.left, p, q) : lowestCommonAncestorRecursive(root.right, p, q);
        } else {
            return root;
        }
    }

    public TreeNode lowestCommonAncestorInterative(TreeNode root, TreeNode p, TreeNode q) {
        while( (root.val - p.val) * (root.val - q.val) > 0) {
            root = root.val > p.val ? root.left : root.right;
        }
        return root;
    }
}

