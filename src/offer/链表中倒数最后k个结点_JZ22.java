package offer;

import leetcode.ListNode;

/**
 * @author ruxing.wrx
 * @date 2023/4/21 20:41
 */
public class 链表中倒数最后k个结点_JZ22 {

    /**
     * 输入一个长度为 n 的链表，设链表中的元素的值为 ai ，返回该链表中倒数第k个节点。
     * 如果该链表长度小于k，请返回一个长度为 0 的链表。
     *
     * 输入：{1,2,3,4,5},2
     * 返回值：{4,5}
     *
     * 输入：{2},8
     * 返回值：{}
     */

    /**
     * 双指针，快慢指针
     * 1、快指针先走：k - 1，因为当慢指针到倒数第k个时，与最后就相差k - 1个
     * 2、快慢指针同时走1步，直到最后，慢指针就是倒数第k个
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {
        if (null == pHead || k < 1) {
            return null;
        }
        ListNode slow = pHead,fast = pHead;
        for (int i = 0; i < k - 1; i++) {
            // 为了判断超出，链表长度小于k返回空
            if (fast.next == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }
}
