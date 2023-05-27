package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author ruxing.wrx
 * @date 2023/5/24 10:03
 */
public class 动态中位数 {
    /**
     * 中位数算法：奇数：有序数组中间数字，偶数：中间两个数字和/2
     * 问题点在于如何快速找到中间数字，或中间两个数字
     *
     * 利用优先队列维护两个堆，大顶堆、小顶堆，
     * 要求: 两个顶堆元素长度差值不得大于1，大顶堆最大的元组要小于小顶堆最小的元素
     */

    private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> large = new PriorityQueue<>();

    /**
     * 添加一个数字
     */
    public void addNum(int num) {
        if (small.size() >= large.size()) {
            small.offer(num);
            large.offer(small.poll());
        }else {
            large.offer(num);
            small.offer(large.poll());
        }
    }

    /**
     * 计算当前添加的所有数字的中位数
     */
    public double findMedian() {
        if (small.size() == 0 && large.size() == 0) {
            return 0;
        }
        if (small.size() > large.size()) {
            return small.peek();
        }
        if (large.size() > small.size()) {
            return large.peek();
        }
        return (small.peek() + large.peek()) / 2d;
    }
}
