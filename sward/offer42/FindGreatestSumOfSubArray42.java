package sward.offer42;

/**
 * @program: myleetcode
 * @description:
 * @author: James
 * @create: 2019-08-24 14:15
 **/
public class FindGreatestSumOfSubArray42 {



    public int findGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int length = array.length;
        int[] dp = new int[length + 1];
        int ans = Integer.MIN_VALUE;
        dp[0] = array[0];
        for (int i = 1; i < length; ++i) {
            dp[i] = Math.max(array[i], dp[i - 1] + array[i]);
            ans = Math.max(ans, dp[i + 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] test = {1,-2,3,10,-4,7,2,-5};
        FindGreatestSumOfSubArray42 findGreatestSumOfSubArray42 = new FindGreatestSumOfSubArray42();
        findGreatestSumOfSubArray42.findGreatestSumOfSubArray(test);
    }




    public void sort(int[] array) {

    }

    public void quickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = partition(array, startIndex, endIndex);
        quickSort(array, startIndex, pivotIndex -1);
        quickSort(array, pivotIndex + 1, endIndex);
    }

    public int partition(int[] arr, int startIndex, int endIndex) {
        int pivotValue = arr[startIndex];
        int markIndex = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (pivotValue < arr[i]) {
                markIndex++;
//               交换两个元素
                int temp = arr[i];
                arr[i] = arr[markIndex];
                arr[markIndex] = arr[i];
            }
        }

        int temp = arr[markIndex];
        arr[markIndex] = pivotValue;
        arr[startIndex] = temp;
        return markIndex;
    }


    /**
     * 另外一种版本的单边循环的方法
     * @param a
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int partitionV2(int[] a, int startIndex, int endIndex) {
        int pivotValue= a[endIndex];
        int markIndex = startIndex;
        for(int j = startIndex; j < endIndex; ++j) {
            if (a[j] < pivotValue) {
                if (markIndex == j) {
                    ++markIndex;
                } else {
                    int tmp = a[markIndex];
                    a[markIndex] = a[j];
                    a[j] = tmp;
                    markIndex++;
                }
            }
        }

        int tmp = a[markIndex];
        a[markIndex] = a[endIndex];
        a[endIndex] = tmp;

        System.out.println("i=" + markIndex);
        return markIndex;
    }




}
