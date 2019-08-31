package sward.offer59;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @program: SwordDirectionOffer
 * @description:
 * https://www.nowcoder.com/practice/1624bc35a45c42c0bc17d17fa0cba788?tpId=13&tqId=11217&tPage=4&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * @author: James
 * @create: 2019-08-31 16:23
 **/
public class MaxInWindows59 {

    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        LinkedList<Integer> dueue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if (size == 0) {
            return ans;
        }
        for (int i = 0, len = num.length; i < len; ++i) {
            if (i < size - 1) {
                if (dueue.size() > 0 && dueue.getLast() < num[i]) {
                    dueue.clear();
                    dueue.add(num[i]);
                } else {
                    dueue.addFirst(num[i]);
                }
            } else {
                if (dueue.size() > 0 && dueue.getLast() < num[i]) {
                    dueue.clear();
                    dueue.add(num[i]);
                } else if (dueue.size() == 0) {
                    dueue.addFirst(num[i]);
                } else if (dueue.getLast() >= num[i]) {
                    while (dueue.getFirst() <= num[i]) {
                        dueue.removeFirst();
                    }
                    dueue.addFirst(num[i]);
                }
                if (i - size >= 0 && dueue.size() > 1 && num[i - size] == dueue.getLast()) {
                    dueue.removeLast();
                }
                ans.add(dueue.getLast());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] test = {10,14,12,11};
        int size = 1;
        MaxInWindows59 maxInWindows59= new MaxInWindows59();
        ArrayList<Integer> list = maxInWindows59.maxInWindows(test, 1);
        System.out.println(list);

    }
}
