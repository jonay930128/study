package leetcode;

/**
 * @author ruxing.wrx
 * @date 2023/4/20 18:54
 */
public class 删除排序链表中重复元素_83 {

    /**
     * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
     *
     * 输入：head = [1,1,2]
     * 输出：[1,2]
     */

    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode temp = head;
        while (null != temp.next) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            }else {
                temp = temp.next;
            }
        }
        return head;
    }

}
