package sward.offer39;

import java.util.HashMap;

/**
 * @program: myleetcode
 * @description:
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163?tpId=13&tqId=11181&tPage=2&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * @author: James
 * @create: 2019-08-24 13:23
 **/
public class MoreThanHalfNumSolution39 {


    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = array.length;
        for (int i = 0; i < len; ++i) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) > len / 2) {
                return key;
            }
        }
        return 0;
    }

    public int MoreThanHalfNumSecond(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int count = 0;
        int cur = 0;
        int len = array.length;
        for (int i = 1; i < len; ++i) {
            if (count == 0) {
                cur = array[i];
                count ++;
            } else if (array[i] == cur) {
                count++;
            } else if (array[i] != cur) {
                count--;
            }
        }
        if (count > 0 && checkMoreThanHalf(array, cur, len)) {
            return cur;
        } else {
            return 0;
        }
    }

    private boolean checkMoreThanHalf(int[] array, int num, int len) {
        int count = 0;
        for (int i = 0; i < len; ++i) {
            if (array[i] == num) {
                count++;
            }
        }
        if (count > len / 2) {
            return true;
        }
        return false;
    }

}
