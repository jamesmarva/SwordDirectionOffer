package sward.offer57;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: myleetcode
 * @description:
 * @author: James
 * @create: 2019-08-25 18:54
 **/
public class FindContinuousSequence57 {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        int left = 1;
        int right = 2;
        int tempSum = 1;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>(Arrays.asList(1));
        while (right > 0) {
            tempSum += right;
            tempList.add(right);
            if (tempSum == sum) {
                ans.add(new ArrayList<>(tempList));
            }
            while (tempSum > sum && left < right) {
                tempList.remove((Integer) left);
                tempSum -= left;
                if (tempSum == sum && tempList.size() >= 2) {
                    ans.add(new ArrayList<>(tempList));
                }
                left++;
            }
            if (right > sum) {
                break;
            }
            right++;
        }
        return ans;
    }


    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (array == null || array.length == 0) {
            return ans;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left] + array[right];
            if (array[left] + array[right] == sum) {
                ans.add(array[left]);
                ans.add(array[right]);
                break;
            } else if (temp > sum) {
                right--;
            } else if (temp < sum) {
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindContinuousSequence57 findContinuousSequence57 = new FindContinuousSequence57();
        ArrayList<ArrayList<Integer>> result = findContinuousSequence57.FindContinuousSequence(9);
        System.out.println(result);
    }
}
