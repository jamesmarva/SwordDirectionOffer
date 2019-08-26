package sward.offer40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @program: myleetcode
 * @description:
 * @author: James
 * @create: 2019-08-24 13:57
 **/
public class GetLeastNumbersSolution40 {

    /**
     *   输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (input == null || input.length == 0 || k > input.length || k <= 0) {
            return ans;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int len = input.length;
        for (int i = 0; i < len; ++i) {
            priorityQueue.offer(input[i]);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        ans.addAll(priorityQueue);
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(3);
        Integer[] test = { 6, 7, 8, 1, 2, 3, 4,};
        priorityQueue.addAll(Arrays.asList(test));

        GetLeastNumbersSolution40 getLeastNumbersSolution40 = new GetLeastNumbersSolution40();
        int[] test1 = { 6, 7, 8, 1, 2, 3, 4,};
        ArrayList<Integer> temp = getLeastNumbersSolution40.GetLeastNumbers_Solution(test1, 3);
        System.out.println(temp);
    }
}
