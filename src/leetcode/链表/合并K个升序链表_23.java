package leetcode.链表;

import leetcode.ListNode;

/**
 * @author ruxing.wrx
 * @date 2023/5/27 20:05
 */
public class 合并K个升序链表_23 {
    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     *
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     */

    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode res = lists[0];
        for (int i = 1; i < lists.length; i++) {
            ListNode list2 = lists[i];
            res = mergeTwoNode(res,list2);
        }
        return res;
    }

    private ListNode mergeTwoNode(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode temp = res;
        while (null != list1 && null != list2) {
            if (list1.val > list2.val) {
                temp.next = list2;
                list2 = list2.next;
            }else {
                temp.next = list1;
                list1 = list1.next;
            }
            temp = temp.next;
        }
        if (null != list1) {
            temp.next = list1;
        }
        if (null != list2) {
            temp.next = list2;
        }
        return res.next;
    }
}
