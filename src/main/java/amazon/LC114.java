package amazon;

public class LC114 {
    public void flatten(TreeNode root) {
        if(root == null || root.left == null && root.right == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        if(left == null) {return;}
        root.right = left;
        while(left.right != null) {
            left = left.right;
        }
        left.right = right;
        return;
    }

    public void flattenNew(TreeNode root) {
        if(root == null || root.left == null && root.right == null) return;
        flattenNew(root.left);
        flattenNew(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;

        if(left == null) {
            return;
        }

        //if(left != null) {
        root.right = left;
        //}
        while(left.right != null) {
            left = left.right;
        }

        left.right = right;
        return;

    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;
        node1.left = node2;
        node1.right = node5;
        new LC114().flatten(node1);
    }
}
