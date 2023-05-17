package leetcode.字符串;

/**
 * @author ruxing.wrx
 * @date 2023/5/16 22:15
 */
public class 和为K的子数组_560 {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
     * 输入：nums = [1,1,1], k = 2
     * 输出：2
     */
    public static void main(String[] args) {
        int[] nums = {1,-1,0};
        System.out.println(subarraySum(nums,0));
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int index = 0;
        while (index < nums.length) {
            int sum = nums[index];
            if (sum == k) {
                count++;
            }
            for (int i = index + 1; i < nums.length; i++) {
                sum += nums[i];
                if (sum == k) {
                    count++;
                }
            }
            index++;
        }
        return count;
    }
}
