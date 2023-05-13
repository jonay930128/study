package leetcode.双指针;

import leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ruxing.wrx
 * @date 2023/4/21 17:40
 */
public class 回文链表_234 {

    /**
     * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
     *
     * 输入：head = [1,2,2,1]
     * 输出：true
     *
     * 输入：head = [1,2]
     * 输出：false
     *
     */

    /**
     * 找到后半部分链表。
     * 反转后半部分链表。
     * 判断是否回文。
     */
    public boolean isPalindrome(ListNode head) {
        if (null == head) {
            return false;
        }
        // slow是后半部，fast是前半部
        ListNode slow = head,fast = head;
        // fast != null (偶数这个条件停) && fast.next != null (奇数这个条件停)
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 说明链表是奇数,中间节点给前半部
        if (fast != null) {
            slow = slow.next;
        }
        // 反转链表
        slow = reverseList(slow);
        fast = head;
        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    /**
     * 反转链表
     */
    public ListNode reverseList(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode curr = head;
        ListNode preNode = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = preNode;
            preNode = curr;
            curr = next;
        }
        return preNode;
    }

    /**
     * 一共为两个步骤：
     *
     * 复制链表值到数组列表中。
     * 使用双指针法判断是否为回文。
     */
    public boolean isPalindrome2(ListNode head) {
        if (null == head) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int front = 0;
        int back = list.size() - 1;
        while (front < back) {
            if (!list.get(front).equals(list.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }

}
