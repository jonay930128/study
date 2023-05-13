package leetcode.字符串;

import java.util.Stack;

/**
 * @author ruxing.wrx
 * @date 2023/5/6 10:29
 */
public class 有效的括号_20 {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     *
     * 输入：s = "()[]{}"
     * 输出：true
     *
     * 输入：s = "(]"
     * 输出：false
     *
     * 思路：利用栈的特性去判断
     */

    public boolean isValid(String s) {
        if (null == s) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            }else if (c == '['){
                stack.push(']');
            }else if (c == '{'){
                stack.push('}');
            }else if (stack.isEmpty() || c != stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }

}
