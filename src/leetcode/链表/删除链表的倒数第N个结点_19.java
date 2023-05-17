package leetcode.链表;

import leetcode.ListNode;

/**
 * @author ruxing.wrx
 * @date 2023/5/17 20:29
 */
public class 删除链表的倒数第N个结点_19 {
    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     *
     * 我的思路是双指针
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        // 测出来的，当快指针为空时，其实就是删掉头节点
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 说明要删除的节点是尾结点
        if (slow.next.next == null) {
            slow.next = null;
        }else {
            slow.next = slow.next.next;
        }
        return head;
    }
}
