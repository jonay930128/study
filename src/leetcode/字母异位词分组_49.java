package leetcode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ruxing.wrx
 * @date 2023/5/13 18:59
 */
public class 字母异位词分组_49 {
    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
     *
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     *
     */

    public static void main(String[] args) {
        String[] str = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(str));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.computeIfAbsent(key, k -> new ArrayList<>());
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }
}
