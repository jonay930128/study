package leetcode.双指针;

/**
 * @author ruxing.wrx
 * @date 2023/5/14 18:43
 */
public class 接雨水_42 {
    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     */
    public static int trap(int[] height) {
        if (null == height || height.length == 0) {
            return 0;
        }
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = height[0];
        right[n-1] = height[n-1];
        int ans = 0;

        // 从左边每个最高的高度
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i-1],height[i]);
        }
        // 从右边每个最高的高度
        for (int i = n-2; i >= 0; i--) {
            right[i] = Math.max(right[i+1],height[i]);
        }
        for (int i = 0; i < n; i++) {
            ans += Math.min(left[i],right[i]) - height[i];
        }
        return ans;
    }
}
