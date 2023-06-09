package leetcode.树;

import leetcode.TreeNode;

/**
 * @author ruxing.wrx
 * @date 2023/4/23 16:37
 */
public class 二叉树的最大深度_104 {
    /**
     * 给定一个二叉树，找出其最大深度。
     *
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     */

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }

}
