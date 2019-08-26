package sward.offer23;

import sward.ListNode;

import java.util.HashSet;

/**
 * @program: myleetcode
 * @description:
 * @author: James
 * @create: 2019-08-23 08:13
 **/
public class EntryNodeOfLoop23 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode node = pHead;
        while (node != null ) {
            if (!set.add(node) ) {
                break;
            }
            node = node.next;
        }
        if (node == null) {
            return null;
        }
        return node;
    }
}
