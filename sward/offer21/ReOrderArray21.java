package sward.offer21;

/**
 * @program: myleetcode
 * @description:
 * nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593?tpId=13&tqId=11166&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * @author: James
 * @create: 2019-08-22 07:17
 **/
public class ReOrderArray21 {


    public static void reOrderArray(int [] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = 0, len = array.length; i < len; i++) {
            if ((array[i] & 1) == 0) {
                for (int j = i + 1; j < len; ++j) {
                    if ((array[j] & 1) == 1) {
                        int temp = array[j];
                        for (int k = j - 1; k >= i; k--) {
                            array[k + 1] = array[k];
                        }
                        array[i] = temp;
                        break;
                    }
                }
            }
        }
        return;
    }


    public static void main(String[] args) {
        int[] test = {1,2,3,4,5,6,7};
        reOrderArray(test);
    }
}
