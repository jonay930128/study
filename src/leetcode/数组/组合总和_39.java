package leetcode.数组;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ruxing.wrx
 * @date 2023/6/4 13:10
 */
public class 组合总和_39 {
    /**
     * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，
     * 找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合
     * <p>
     * 输入：candidates = [2,3,6,7], target = 7
     * 输出：[[2,2,3],[7]]
     * 解释：
     * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
     * 7 也是一个候选， 7 = 7 。
     * 仅有这两种组合。
     * <p>
     * 回溯
     */

    private List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0, new ArrayList<>(),0);
        return resList;
    }

    private void backtrack(int[] candidates, int target, int total, List<Integer> pathList,int startIndex) {
        if (target == total) {
            resList.add(new ArrayList<>(pathList));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (target > total) {
                pathList.add(candidates[i]);
                backtrack(candidates, target, total + candidates[i], pathList,i);
                pathList.remove(pathList.size() - 1);
            }
        }
    }
}
