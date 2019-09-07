package sward.offer51;

import java.net.SocketOption;
import java.util.Arrays;

/**
 * @program: myleetcode
 * @description:
 * nowcoder.com/practice/96bd6684e04a44eb80e6a68efc0ec6c5?tpId=13&tqId=11188&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * @author: James
 * @create: 2019-08-24 23:52
 **/
public class InversePairs51 {


    public int globalAns = 0;

    public int InversePairs(int [] array) {
        mergeSort(array, 0, array.length - 1);
        return globalAns;
    }

    public void mergeSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int mid = startIndex + ((endIndex -startIndex) >>1);
        mergeSort(arr, startIndex, mid);
        mergeSort(arr, mid + 1, endIndex);
        mergeSort(arr, startIndex, mid, endIndex);
    }

    public void mergeSort(int[] arr, int startIndex, int midIndex, int endIndex) {
        int[] temp = new int[endIndex - startIndex + 1];
        int leftIndex = midIndex;
        int rightIndex = endIndex;
        int len = temp.length;
        int index = len - 1;
        while (leftIndex >= startIndex && rightIndex >= midIndex + 1) {
            if (arr[leftIndex] > arr[rightIndex]) {
                temp[index] = arr[leftIndex];
                index--;
                leftIndex--;
                globalAns += (rightIndex - midIndex);
                globalAns %= 1000000007;
            } else {
                temp[index] = arr[rightIndex];
                index--;
                rightIndex--;
            }
        }
        while (leftIndex >= startIndex) {
            temp[index] = arr[leftIndex];
            index--;
            leftIndex--;

        }

        while (rightIndex >= midIndex + 1) {
            temp[index] = arr[rightIndex];
            index--;
            rightIndex--;
        }

        for (int i = 0; i < len; ++i) {
            arr[startIndex + i] = temp[i];
        }
    }


    public static void main(String[] args) {
        int[] test = {1, 3, 4, 0, 9, 8, 7, 6,5};
        InversePairs51 inversePairs51 = new InversePairs51();

        inversePairs51.mergeSort(test, 0, test.length - 1);
        System.out.println(Arrays.toString(test));
        System.out.println(inversePairs51.globalAns);
    }


}
