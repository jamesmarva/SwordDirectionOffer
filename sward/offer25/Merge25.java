package sward.offer25;


import sward.ListNode;

/**
 * @program: myleetcode
 * @description:
 * https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=13&tqId=11169&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * @author: James
 * @create: 2019-08-21 08:02
 **/
public class Merge25 {


    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode index1 = list1;
        ListNode index2 = list2;
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (index1 != null && index2 != null) {
            if (index1.val < index2.val) {
                node.next = index1;
                index1 = index1.next;
            } else {
                node.next = index2;
                index2 = index2.next;
            }
            node = node.next;
        }
        while (index1 != null ) {
            node.next = index1;
            index1 = index1.next;
            node = node.next;
        }
        while (index2 != null) {
            node.next = index2;
            index2 = index2.next;
            node = node.next;
        }
        return dummy.next;
    }

}
