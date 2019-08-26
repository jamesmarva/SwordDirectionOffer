package sward.offer31;

import java.util.Stack;

/**
 * @program: myleetcode
 * @description:
 * https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&tqId=11174&tPage=2&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * @author: James
 * @create: 2019-08-23 23:15
 **/
public class IsPopOrder31 {

    public boolean IsPopOrder(int [] pushA, int [] popA) {
        if (popA == null || (pushA.length == 0 && popA.length == 0)) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0, len = pushA.length; i < len; ++i) {
            int temp = pushA[i];
            stack.push(temp);
            while (popIndex < len && temp == popA[popIndex]) {
                stack.pop();
                popIndex++;
                if (stack.isEmpty()) {
                    break;
                }
                temp = stack.peek();
            }
        }
        return stack.isEmpty();
    }
}
