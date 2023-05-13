package leetcode.字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ruxing.wrx
 * @date 2023/5/10 09:16
 */
public class 无重复字符的最长子串_3 {
    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * 滑动窗口，两个指针记录不重复子串距离
     */

    public static void main(String[] args) {
//        String s = "abcabcbb";
        String s = "abba";
        System.out.println(lengthOfLongestSubstring2(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right++);
            map.put(c,map.getOrDefault(c,0) + 1);
            // 左指针要移动的位数
            while (map.get(c) > 1) {
                char l = s.charAt(left++);
                map.put(l,map.getOrDefault(l,0) - 1);
            }
            res = Math.max(res,right - left);
        }
        return res;
    }

    public static int lengthOfLongestSubstring2(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer index = map.get(c);
            if (null != index) {
                // index+1的意思是：把左指针移动到上个重复元素的下一个位置
                left = Math.max(left, index + 1);
            }
            // 放入index，如果是重复的就更新index
            map.put(c,i);
            res = Math.max(res,i - left + 1);
        }
        return res;
    }
}
