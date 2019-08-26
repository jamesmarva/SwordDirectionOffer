package sward.offer52;


import sward.ListNode;

import java.util.HashSet;

/**
 * @program: myleetcode
 * @description:
 * https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=13&tqId=11189&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * @author: James
 * @create: 2019-08-25 00:18
 **/
public class FindFirstCommonNode52 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null) {
            return null;
        }
        HashSet<ListNode> set = new HashSet<ListNode>();
        ListNode index1 = pHead1;
        while (index1 != null) {
            set.add(index1);
            index1 = index1.next;
        }
        ListNode index2 = pHead2;
        while (index2 != null) {
            if (set.contains(index2)) {
                break;
            }
            index2 = index2.next;
        }
        return index2;
    }
}
