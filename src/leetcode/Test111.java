package leetcode;

/**
 * @author ruxing.wrx
 * @date 2023/5/12 09:45
 */
public class Test111 {

    public int removeElement(int[] nums, int val) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[left] = nums[i];
                left++;
            }
        }
        return left;
    }

    public int searchInsert(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }

}
