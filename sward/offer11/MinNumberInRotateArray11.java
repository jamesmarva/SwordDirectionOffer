package sward.offer11;

/**
 * @program: myleetcode
 * @description:
 * https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=11159&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * @author: James
 * @create: 2019-08-21 23:18
 **/
public class MinNumberInRotateArray11 {


    /**
     * 最简单的就是用遍历
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int ans = array[0];
        for (int i = 0, len = array.length; i < len; ++i) {
            ans = Math.min(ans, array[i]);
        }
        return ans;
    }


    public int minNumberInRotateArrayBetter(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int low = 0;
        int high = array.length - 1;
        int indexMin = low;
        while (low <= high) {
            if (high - low == 1) {
                indexMin = high;
                break;
            }

            indexMin = low + ((high - low) >>> 1);

            if (array[low] == array[high] && array[low] == array[indexMin]) {
                return minOrder(array , low, high);
            } else if (array[indexMin] >= array[high]) {
                low = indexMin;
            } else if (array[indexMin] <= array[high]) {
                high = indexMin;
            }
        }
        return indexMin;
    }

    public int minOrder(int[] array , int low, int high) {
        int ans = array[low];
        for (int i = low; i <= high; ++i) {
            ans = Math.min(ans, array[i]);
        }
        return ans;
    }
}