package sward.offer22;

import sward.ListNode;

/**
 * @program: myleetcode
 * @description:
 * @author: James
 * @create: 2019-08-21 19:45
 **/
public class FindKthToTail22 {

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode low = head;
        for (int i = 1; i <= k; ++i) {
//            当输入的k大链表的数量的时候。
            if (fast != null) {
                fast = fast.next;
            } else {
                return null;
            }
        }
        while (fast != null) {
            fast = fast.next;
            low = low.next;
        }
        return low;

    }
}
