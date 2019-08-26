package sward.offer09;

import java.util.Stack;

/**
 * @program: myleetcode
 * @description:
 * @author: James
 * @create: 2019-08-21 07:48
 **/
public class TwoStackImplementsQueue09 {


    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);

    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
