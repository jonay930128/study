package leetcode.字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ruxing.wrx
 * @date 2023/5/26 09:47
 */
public class 括号生成_22 {
    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     *
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     */

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(n,0,0,new StringBuilder(),list);
        return list;
    }

    private static void backtrack(int n,int left,int right,StringBuilder sb,List<String> list) {
        if (left == n && right == n) {
            list.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append("(");
            backtrack(n,left + 1,right,sb,list);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(")");
            backtrack(n,left,right + 1,sb,list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
