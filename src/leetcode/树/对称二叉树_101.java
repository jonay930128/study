package leetcode.树;

import leetcode.TreeNode;

/**
 * @author ruxing.wrx
 * @date 2023/4/23 11:36
 */
public class 对称二叉树_101 {

    /**
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     *
     * 思路：
     * 左子树的 左 孩子等于右子树的 右 孩子
     * 左子树的 右 孩子等于右子树的 左 孩子
     *
     */

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return checkSymmetry(root.left,root.right);
    }

    private boolean checkSymmetry(TreeNode left, TreeNode right) {
        if (null == left && null == right) {
            return true;
        }
        if (null == left || null == right) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return checkSymmetry(left.left,right.right) && checkSymmetry(left.right,right.left);
    }
}
