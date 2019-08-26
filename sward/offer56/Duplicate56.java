package sward.offer56;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @program: myleetcode
 * @description:
 * @author: James
 * @create: 2019-08-25 17:33
 **/
public class Duplicate56 {

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < length; ++i) {
            if (!set.add(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    public class Solution {
        public boolean duplicate(int nums[],int length,int [] duplication) {
            if(nums == null || length == 0){
                return false;
            }
            for(int i=0;i<length;i++){
                while(nums[i] != i){
                    if(nums[i] == nums[nums[i]]){
                        duplication[0] = nums[i];
                        return true;
                    }
                    // swap
                    int tmp = nums[i];
                    nums[i] = nums[tmp];
                    nums[tmp] = tmp;
                }
            }
            return false;
        }
    }

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length == 0) {
            return;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0, len = array.length; i < len; ++i) {
            map.put(array[i] , map.getOrDefault(array[i], 0) + 1);
        }
        boolean isFirst = true;
        for (Integer itemkey : map.keySet()) {
            if (map.get(itemkey) == 1) {
                if (isFirst) {
                    num1[0] = itemkey;
                    isFirst = false;
                } else {
                    num2[0] = itemkey;
                }

            }
        }
    }


}
