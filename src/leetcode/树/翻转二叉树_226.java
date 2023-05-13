package leetcode.树;

import leetcode.TreeNode;

/**
 * @author ruxing.wrx
 * @date 2023/4/23 17:28
 */
public class 翻转二叉树_226 {
    /**
     * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
     */

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
