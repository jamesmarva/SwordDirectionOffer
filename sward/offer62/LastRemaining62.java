package sward.offer62;

import java.util.LinkedList;

/**
 * @program: myleetcode
 * @description: 圆圈中最后的数字
 * @author: James
 * @create: 2019-08-18 17:13
 **/
public class LastRemaining62 {


    class Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }
    }
    public int lastRemaining(int n, int m) {
        if (n < 1) {
            return  -1;
        }
        Node head = new Node(0);
        Node index = head;
        for (int i = 1; i < n; ++i) {
            index.next = new Node(i);
            index = index.next;
        }
        index.next = head;
        index = head;
        while (index.value != index.next.value) {
            for (int i = 1; i < m; ++i) {
                index = index.next;
            }
            System.out.println(index.value);
            index.value = index.next.value;
            index.next = index.next.next;
        }
        return index.value;
    }

    public static void main(String[] args) {
        LastRemaining62 lastRemaining62 = new LastRemaining62();
        lastRemaining62.lastRemaining(5, 3);
    }
}
