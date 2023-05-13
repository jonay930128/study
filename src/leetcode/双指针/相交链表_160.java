package leetcode.双指针;

import leetcode.ListNode;

/**
 * @author ruxing.wrx
 * @date 2023/4/20 20:50
 */
public class 相交链表_160 {

    /**
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
     *
     * 解法1思路：
     * 利用路程相等的原理，双指针都从头开始，当某一个遍历到最后了就从另外一个链表的头节点开始，当两个值相等时就是相交其实节点，及时没有相交
     * 最后也都是null.
     *
     * 解法2思路：
     * 两个链表长度分别是a,b，较长的减去较短的差值diff，较长的链表不从头节点开始遍历，而是从diff开始，这样两个链表长度就一样了，那两边相等时
     * 就是起始相交节点
     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return null;
        }
        ListNode a1 = headA,b1 = headB;
        while (a1 != b1) {
            a1 = a1 == null ? headB : a1.next;
            b1 = b1 == null ? headA : b1.next;
        }
        return a1;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {
            return null;
        }
        int l1 = 0,l2 = 0,diff = 0;
        ListNode a1 = headA,b1 = headB;
        while (a1 != null) {
            l1++;
            a1 = a1.next;
        }
        while (b1 != null) {
            l2++;
            b1 = b1.next;
        }
        if (l1 > l2) {
            a1 = headA;b1 = headB;diff = l1 - l2;
        }else {
            a1 = headB;b1 = headA;diff = l2 - l1;
        }
        for (int i = 0; i < diff; i++) {
            a1 = a1.next;
        }
        while (a1 != null && b1 != null) {
            if (a1 == b1) {
                return a1;
            }
            a1 = a1.next;
            b1 = b1.next;
        }
        return null;
    }

}
