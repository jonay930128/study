package leetcode.双指针;

import leetcode.ListNode;

/**
 * @author ruxing.wrx
 * @date 2023/4/20 21:43
 */
public class 翻转链表_206 {

    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     *
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     *
     * 思路：定义一个空的头节点
     * 1、当前指针的next指向空的头节点
     * 2、空的头节点向后移动，当前指针向后移动
     */
    public ListNode reverseList(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode curr = head;
        ListNode preNode = null;

        while (null != curr) {
            // 下一个节点
            ListNode next = curr.next;
            // 当前节点指向前一个节点
            curr.next = preNode;
            // 上一个阶段指向当前阶段
            preNode = curr;
            // 当前节点变成下一个节点
            curr = next;
        }
        return preNode;
    }
}
