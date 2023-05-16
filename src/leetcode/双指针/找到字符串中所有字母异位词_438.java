package leetcode.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ruxing.wrx
 * @date 2023/5/15 23:41
 */
public class 找到字符串中所有字母异位词_438 {
    /**
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
     *
     * 输入: s = "abab", p = "ab"
     * 输出: [0,1,2]
     * 解释:
     * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
     * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
     * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
     */

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        findAnagrams(s,p);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        if (null == p || p.length() < 1) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int n = s.length() - 1;
        int index = 0;

        int pLength = p.length();
        char[] chars = p.toCharArray();
        Arrays.sort(chars);
        String key = new String(chars);

        while (index + p.length() - 1 <= n) {
            char[] chars2 = s.substring(index,index + pLength).toCharArray();
            Arrays.sort(chars2);
            if (key.equals(new String(chars2))) {
                list.add(index);
            }
            index++;
        }
        return list;
    }
}
