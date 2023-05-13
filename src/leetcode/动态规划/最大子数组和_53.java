package leetcode.动态规划;

/**
 * @author ruxing.wrx
 * @date 2023/5/8 09:46
 */
public class 最大子数组和_53 {
    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 子数组 是数组中的一个连续部分。
     *
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 状态转移公式
            dp[i] = Math.max(dp[i - 1] + nums[i],nums[i]);
            if (dp[i] > result) {
                result = dp[i];
            }
        }
        return result;
    }
}
