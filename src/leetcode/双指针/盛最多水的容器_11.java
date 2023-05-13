package leetcode.双指针;

/**
 * @author ruxing.wrx
 * @date 2023/5/13 19:51
 */
public class 盛最多水的容器_11 {
    /**
     * 给定一个长度为 n 的整数数组height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * 返回容器可以储存的最大水量。
     */
    public int maxArea(int[] height) {
        int left = 0,right = height.length - 1;
        int ans = 0;
        while (left < right) {
            int area = Math.min(height[left],height[right]) * (right - left);
            ans = Math.max(ans,area);
            if (height[left] > height[right]) {
                right--;
            }else {
                left++;
            }
        }
        return ans;
    }
}
