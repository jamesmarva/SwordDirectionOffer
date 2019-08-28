package sward.offer61;

import java.util.Arrays;

/**
 * @program: SwordDirectionOffer
 * @description:
 * https://www.nowcoder.com/practice/762836f4d43d43ca9deb273b3de8e1f4?tpId=13&tqId=11198&tPage=3&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * @author: James
 * @create: 2019-08-28 07:19
 **/
public class IsContinuous61 {


    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        Arrays.sort(numbers);
        int len = numbers.length;
        int zeroCount = 0;
        for (int i = 0; i < len; ++i) {
            if (numbers[i] == 0) {
                zeroCount++;
            }
        }
        for (int i = zeroCount; i < len - 1; ++i) {
            if (numbers[i] == numbers[i + 1]) {
                return false;
            }
            zeroCount = zeroCount - (Math.abs(numbers[i] - numbers[i + 1]) - 1);
            if (zeroCount < 0) {
                return false;
            }
        }
        return true;
    }
}
