package sward.offer18;

import sward.ListNode;

/**
 * @program: SwordDirectionOffer
 * @description:
 * @author: James
 * @create: 2019-09-07 11:23
 **/
public class DeleteNode18 {

    public void deleteNode(ListNode head, ListNode nodeToBeDelete) {
        if (nodeToBeDelete == null) {
            return;
        }
        if (nodeToBeDelete.next == null) {
            while (head != null) {
                if (head.next == nodeToBeDelete) {
                    head.next = null;
                }
                head = head.next;
            }
        }
        if (nodeToBeDelete.next != null) {
            nodeToBeDelete.val = nodeToBeDelete.next.val;
            nodeToBeDelete.next = nodeToBeDelete.next.next;
        }
    }


}
