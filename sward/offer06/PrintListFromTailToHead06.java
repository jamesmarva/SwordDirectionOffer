package sward.offer06;

import sward.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @program: myleetcode
 * @description:
 * @author: James
 * @create: 2019-08-21 01:01
 **/
public class PrintListFromTailToHead06 {


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = listNode;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!stack.isEmpty()) {
            ans.add(stack.pop().val);
        }
        return ans;
    }

    private ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        back(listNode);
        return list;
    }
    private void back(ListNode node ) {
        if (node == null) {
            return;
        }
        back(node.next);
        list.add(node.val);
    }

}
