package sward.offer30;

import java.util.Stack;

/**
 * @program: myleetcode
 * @description:
 * @author: James
 * @create: 2019-08-23 07:55
 **/
public class MinStack30 {

    Stack<Integer> stackMin = new Stack<Integer>();
    Stack<Integer> stack = new Stack<>();
    public void push(int node) {
        stack.push(node);
        if(stackMin.isEmpty()) {
            stackMin.push(node);
        } else if (stackMin.peek() >= node) {
            stackMin.push(node);
        }
    }

    public void pop() {
        int ans = stack.pop();
        if (ans == stackMin.peek()) {
            stackMin.pop();
        }
        return;
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();

    }

    public int min() {
        if (!stackMin.isEmpty()) {
            return stackMin.peek();
        } else {
           return -1;
        }
    }
}
