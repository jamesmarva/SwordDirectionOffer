package sward.offer18;

import sward.ListNode;

/**
 * @program: SwordDirectionOffer
 * @description: https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?tpId=13&tqId=11209&tPage=3&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * @author: James
 * @create: 2019-09-07 12:12
 **/
public class DeleteDuplication18 {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return pHead;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        ListNode pre = dummy;
        ListNode index = pHead;
        while (index != null) {
            if (index.next != null && index.val == index.next.val) {
                int tempValue = index.val;
                while (index != null && tempValue == index.val) {
                    index = index.next;
                }
                pre.next = index;
            } else {
                pre = index;
                index = index.next;
            }
        }
        return dummy.next;
    }

}
