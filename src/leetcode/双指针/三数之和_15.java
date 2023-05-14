package leetcode.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ruxing.wrx
 * @date 2023/5/14 17:42
 */
public class 三数之和_15 {
    /**
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
     * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
     * 你返回所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     *
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 解释：
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
     * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
     * 注意，输出的顺序和三元组的顺序并不重要。
     *
     * 双指针移动，判断加在一起是否为0
     *
     */

    public List<List<Integer>> threeSum(int[] nums) {
        Map<String,List<Integer>> map = new HashMap<>();
        Arrays.sort(nums);
        int index = 0;
        while (index < nums.length - 2) {
            int left = index + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[index] + nums[left] + nums[right] == 0) {
                    map.putIfAbsent(nums[index]+"_"+nums[left]+"_"+nums[right]
                            ,Arrays.asList(nums[index],nums[left],nums[right]));
                    left++;
                    right--;
                }else if (nums[index] + nums[left] + nums[right] < 0) {
                    left++;
                }else {
                    right--;
                }
            }
            index++;
        }
        return new ArrayList<>(map.values());
    }
}
