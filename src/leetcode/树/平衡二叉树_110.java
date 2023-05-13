package leetcode.树;

import leetcode.TreeNode;

/**
 * @author ruxing.wrx
 * @date 2023/4/23 17:01
 */
public class 平衡二叉树_110 {
    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 本题中，一棵高度平衡二叉树定义为：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
     *
     * 每棵子树的高度都不能大于1
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return deep(root) != -1;
    }

    private int deep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = deep(root.left);
        int right = deep(root.right);

        // 在这里判断就是判断如果子树有不符合的就返回
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left,right) + 1;
    }
}
