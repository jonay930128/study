package leetcode.字符串;


/**
 * @author ruxing.wrx
 * @date 2023/5/10 23:13
 */
public class 最长回文子串_5 {
    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
     *
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     *
     * 中心扩散
     */
    public String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            // 奇数回文
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (ans.length() < right - left - 1) {
                ans = s.substring(left + 1,right);
            }
            // 偶数回文
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (ans.length() < right - left - 1) {
                ans = s.substring(left + 1,right);
            }
        }
        return ans;
    }

}
