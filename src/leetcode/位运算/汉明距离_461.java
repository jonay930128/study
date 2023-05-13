package leetcode.位运算;

/**
 * @author ruxing.wrx
 * @date 2023/5/6 10:16
 */
public class 汉明距离_461 {
    /**
     * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
     * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
     *
     * 输入：x = 1, y = 4
     * 输出：2
     * 解释：
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     *        ↑   ↑
     * 上面的箭头指出了对应二进制位不同的位置。
     *
     * 思路：先将两个数异或，异或后不同的位就变成了1，再去统计1的个数即可
     * 统计1的个数公式：x = x & (x - 1)
     */

    public int hammingDistance(int x, int y) {
        int distance = 0;
        int eor = x ^ y;
        while (eor != 0) {
            distance++;
            eor = eor & (eor - 1);
        }
        return distance;
    }
}
