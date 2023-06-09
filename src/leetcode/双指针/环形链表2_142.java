package leetcode.双指针;

import leetcode.ListNode;

/**
 * @author ruxing.wrx
 * @date 2023/4/20 19:57
 */
public class 环形链表2_142 {

    /**
     * 给定一个链表的头节点 head，返回链表开始入环的第一个节点。如果链表无环，则返回null。
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
     * 评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。
     * 注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     * 不允许修改 链表。
     *
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：返回索引为 1 的链表节点
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     *
     * 思路：使用快慢指针，慢指针每次走一步，快指针每次走两步，如果有环一定会相遇
     * 有环，将慢指针从头开始并将快慢指针的步频都改成1，如果再次相等此时就是入环第一个节点
     *
     */

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head,fast = head;
        boolean existCycle = false;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                existCycle = true;
                break;
            }
        }
        if (existCycle) {
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;
    }
}
