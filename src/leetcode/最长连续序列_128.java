package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ruxing.wrx
 * @date 2023/5/13 19:26
 */
public class 最长连续序列_128 {
    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * 请你设计并实现时间复杂度为O(n) 的算法解决此问题。
     *
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     */

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int count = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int distance = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    distance++;
                }
                count = Math.max(count,distance);
            }
        }
        return count;
    }
}
