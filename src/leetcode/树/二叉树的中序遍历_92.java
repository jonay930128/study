package leetcode.树;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ruxing.wrx
 * @date 2023/4/22 19:10
 */
public class 二叉树的中序遍历_92 {

    /**
     * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
     */

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // 递归
        recursion(root,res);
        return res;
    }

    private void recursion(TreeNode root, List<Integer> res) {
        if (null == root) {
            return;
        }
        recursion(root.left,res);
        res.add(root.val);
        recursion(root.right,res);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
