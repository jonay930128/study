package leetcode.数组;

/**
 * @author ruxing.wrx
 * @date 2022/12/27 20:17
 */
public class 合并两个有序数组_88 {

    /**
     * 给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，
     * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
     *
     *  示例 1：
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
     * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
     *
     * 思路：从后往前比较，大的放到后面，如果nums1没有了，就全部是nums2，如果nums2没有了，就直接用nuns1的
     *
     * @param nums1 长度是 m + n
     * @param m 是nums1的有效长度
     * @param nums2 长度是n
     * @param n 是nums2的有效长度
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n;
        for (int i = k - 1,num1Index = m - 1,num2Index = n - 1; i >= 0; i--) {
            if (num1Index < 0) {    // num1没有了，用num2
                nums1[i] = nums2[num2Index--];
            }else if (num2Index < 0) {  // num2没有了,直接break,因为剩下的就是num1的
                break;
            }else if (nums1[num1Index] >= nums2[num2Index]) {   // 谁大用谁
                nums1[i] = nums1[num1Index--];
            }else {
                nums1[i] = nums2[num2Index--];
            }
        }
    }
}
