package leetcode.动态规划;

/**
 * @author ruxing.wrx
 * @date 2023/5/9 09:40
 */
public class 买卖股票的最佳时机_121 {
    /**
     * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     *
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     **/

    public int maxProfit(int[] prices) {
        if (null == prices || prices.length < 2) {
            return 0;
        }
        // 二维数组，1：最大利润，2：最小花费
        int[][] dp = new int[prices.length][2];

        // 初始化，第一天最大利润是0，最小花费是-prices[0]
        dp[0][0] = 0;   // 最大利润
        dp[0][1] = -prices[0];  // 最小花费

        for (int i = 1; i < prices.length; i++) {
            // 最大利润 = max(最大利润，最小花费 + 卖出挣的钱)
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            // 最小花费 = max(之前最小花费，当前最小花费)
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    /**
     * 这道题转变成 最小花费 和 最大价差
     * 最小花费 =
     *
     * [7,1,5,3,6,4]
     */
    public int maxProfit2(int[] prices) {
        if (null == prices || prices.length < 2) {
            return 0;
        }
        int min = prices[0];
        int minDifferent = 0;
        for (int i = 1; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            }else {
                minDifferent = Math.max(minDifferent,prices[i] - min);
            }
        }
        return minDifferent;
    }

}
