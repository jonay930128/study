package leetcode.双指针;

/**
 * @author ruxing.wrx
 * @date 2022/12/27 21:03
 */
public class 移动零_283 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};

        moveZeroes3(nums);

        System.out.println(1);
    }

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     * 示例 1:
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     *
     * 思路：
     * 1：双指针，j记录不为0的位置，i从头循环，发现为0的就跳过，不为0的就放到j的位置，并j++。
     * 2：此时非0的都移动到前面了，然后从j的位置到最后用0填充
     */
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            nums[j] = nums[i];
            j++;
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


    public static void moveZeroes3(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }
}
