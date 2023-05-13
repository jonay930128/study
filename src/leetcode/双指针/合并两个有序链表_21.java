package leetcode.双指针;

import leetcode.ListNode;

/**
 * @author ruxing.wrx
 * @date 2023/4/20 14:44
 */
public class 合并两个有序链表_21 {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1,new ListNode(2,new ListNode(4)));
        ListNode list2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode listNode = mergeTwoLists(list1, list2);
        System.out.println(listNode);

        ListNode list3 = new ListNode(1,new ListNode(2,new ListNode(4)));

        ListNode list4 = list3;

        list3 = new ListNode(5);


        System.out.println(list4);
    }

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     *
     * 思路：双指针从小到大比较
     */

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (null == list1) {
            return list2;
        }
        if (null == list2) {
            return list1;
        }
        ListNode resultNode = new ListNode();
        // 必须要有这个，利用对象的值传递引用（temp就是当前要操作的对象）
        ListNode temp = resultNode;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                temp.next = list2;
                list2 = list2.next;
            }else {
                temp.next = list1;
                list1 = list1.next;
            }
            // 当前操作的对象
            temp = temp.next;
        }
        if (list1 != null) {
            temp.next = list1;
        }
        if (list2 != null) {
            temp.next = list2;
        }
        return resultNode.next;
    }
}
