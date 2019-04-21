package binarytree;

import java.util.LinkedList;
import java.util.List;

/**
 * Print a binary tree in an m*n 2D string array following these rules:
 *
 * The row number m should be equal to the height of the given binary tree.
 * The column number n should always be an odd number.
 * The root node's value (in string format) should be put in the exactly middle of the first row it can be put.
 * The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part).
 * You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part.
 * The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not,
 * you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree.
 * However, if two subtrees are none, then you don't need to leave space for both of them.
 * Each unused space should contain an empty string "".
 * Print the subtrees following the same rules.
 *
 * Input:
 *       1
 *      / \
 *     2   5
 *    /
 *   3
 *  /
 * 4
 * Output:
 *
 * [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 *  ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 *  ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 *  ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 *
 *aw
 */
public class LC655 {

    public List<List<String>> printTree(TreeNode root) {
        if(root == null) {
            return new LinkedList<>();
        }

        int height = getHeight(root);
        int len = (int)Math.pow(2, height) - 1;
        List<List<String>> ret = new LinkedList<>();
        for(int i=0;i<height;i++) {
            List<String> l = new LinkedList<>();
            for(int j=0;j<len;j++) {
                l.add("");
            }
            ret.add(l);
        }

        fillArray(ret, 0, 0, len-1, root);

        return ret;
    }

    public void fillArray(List<List<String>> list, int level, int start, int end, TreeNode node) {
        if(node == null) return;
        List<String> l = list.get(level);
        l.set((start+end)/2, String.valueOf(node.val));
        fillArray(list, level+1, start, (start+end)/2-1, node.left);
        fillArray(list, level+1, (start+end)/2+1, end, node.right);
    }

    public int getHeight(TreeNode node) {
        if(node == null) return 0;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
}
