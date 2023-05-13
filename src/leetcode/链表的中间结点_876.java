package leetcode;

/**
 * @author ruxing.wrx
 * @date 2023/4/21 20:25
 */
public class 链表的中间结点_876 {

    /**
     * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     *
     * 输入：head = [1,2,3,4,5]
     * 输出：[3,4,5]
     * 解释：链表只有一个中间结点，值为 3 。
     *
     * 输入：head = [1,2,3,4,5,6]
     * 输出：[4,5,6]
     * 解释：该链表有两个中间结点，值分别为 3 和 4 ，返回第二个结点。
     */

    public ListNode middleNode(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode slow = head,fast = head;
        // fast != null (偶数这个条件停) && fast.next != null (奇数这个条件停)
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
