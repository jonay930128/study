package leetcode.数组;

/**
 * @author ruxing.wrx
 * @date 2023/5/10 10:12
 */
public class 寻找两个正序数组的中位数_4 {
    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
     * 算法的时间复杂度应该为 O(log (m+n)) 。
     *
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     *
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int k = nums1.length + nums2.length;
        int[] arr = new int[k];
        for (int i = 0; i < nums1.length; i++) {
            arr[i] = nums1[i];
        }
        for (int i = k - 1,num1Index = nums1.length - 1,num2Index = nums2.length - 1; i >= 0; i--) {
            if (num1Index < 0) {    // num1没有了，用num2
                arr[i] = nums2[num2Index--];
            }else if (num2Index < 0) {  // num2没有了,直接break,因为剩下的就是num1的
                break;
            }else if (arr[num1Index] >= nums2[num2Index]) {   // 谁大用谁
                arr[i] = arr[num1Index--];
            }else {
                arr[i] = nums2[num2Index--];
            }
        }
        if (arr.length % 2 == 0) {
            int index = arr.length / 2;
            return (arr[index] + arr[index - 1]) / 2d;
        }else {
            return arr[arr.length / 2];
        }
    }
}
