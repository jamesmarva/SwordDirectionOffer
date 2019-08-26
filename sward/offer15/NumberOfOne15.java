package sward.offer15;

/**
 * @program: myleetcode
 * @description:
 * @author: James
 * @create: 2019-08-22 06:18
 **/
public class NumberOfOne15 {



    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            n = (n - 1) & n;
            count++;
        }
        return count;
    }

    public int NumberOf1version2(int n) {
        int count = 0;
        int flag= 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }



}
