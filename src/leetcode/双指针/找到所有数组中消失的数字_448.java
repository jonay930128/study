package leetcode.双指针;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ruxing.wrx
 * @date 2023/1/15 18:22
 */
public class 找到所有数组中消失的数字_448 {

    /**
     * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
     * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
     *
     * 示例 1：
     * 输入：nums = [4,3,2,7,8,2,3,1]
     * 输出：[5,6]
     *
     * 思路：从题目中可以知道数组长度就是n
     * 将所有元素放到他对应的位置上去，如果他的值不等于他的下标index+1那么index+1就是未出现的数字
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            if (nums[index] - 1 == index) {
                index++;
            }else {
                int targetIndex = nums[index] - 1;
                if (nums[index] == nums[targetIndex]) {
                    index++;
                    continue;
                }
                // 交换
                int temp = nums[targetIndex];
                nums[targetIndex] = nums[index];
                nums[index] = temp;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
