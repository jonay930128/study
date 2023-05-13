package leetcode.递归公式;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ruxing.wrx
 * @date 2022/12/27 12:23
 */
public class 爬楼梯_70 {

    private static Map<Integer,Integer> climbMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(climbStairs(20));
        System.out.println(climbStairs2(20));
    }

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * 示例 2：
     * 输入：n = 3
     * 输出：3
     * 解释：有三种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶 + 1 阶
     * 2. 1 阶 + 2 阶
     * 3. 2 阶 + 1 阶
     *
     * 公式：除1，2层台阶后： f(n) = f(n - 1) + f(n - 2)，当前数 = 前一个数 + 前前一个数
     * 斐波那契公式也是f(n) = f(n - 1) + f(n - 2)，n = 0，结果是0，n = 1，结果是1
     */
    /**
     * 递归 + hashMap
     */
    public static int climbStairs(int n) {
        if (1 == n) {
            return 1;
        }
        if (2 == n) {
            return 2;
        }
        if (null != climbMap.get(n)) {
            return climbMap.get(n);
        }
        int result = climbStairs(n - 1) + climbStairs(n - 2);
        climbMap.put(n,result);
        return result;
    }

    /**
     * 普通循环
     * 记录前两个值的结果
     */
    public static int climbStairs2(int n) {
        if (1 == n) {
            return 1;
        }
        if (2 == n) {
            return 2;
        }
        int prePre = 1;
        int pre = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = pre + prePre;
            prePre = pre;
            pre = result;
        }
        return result;
    }

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
