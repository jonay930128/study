package leetcode.字符串;

/**
 * @author ruxing.wrx
 * @date 2023/5/7 15:33
 */
public class 字符串相加_415 {
    /**
     * 给定两个字符串形式的非负整数num1 和num2，计算它们的和并同样以字符串形式返回。
     * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger），也不能直接将输入的字符串转换为整数形式。
     *
     * 输入：num1 = "11", num2 = "123"
     * 输出："134"
     *
     * 数字字符减去字符0就是对应的数字
     */

    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1,j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--,j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            builder.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return builder.reverse().toString();
    }
}
