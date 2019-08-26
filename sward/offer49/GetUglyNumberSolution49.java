package sward.offer49;

/**
 * @program: myleetcode
 * @description:
 * @author: James
 * @create: 2019-08-24 22:38
 **/
public class GetUglyNumberSolution49 {


    /**
     * 三指针的思想
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0 ) {
            return 0;
        }
        int uglyAllIndex = 1;
        int uglyIndex2 = 1;
        int uglyIndex3 = 1;
        int uglyIndex5 = 1;
        int[] uglyArray = new int[index + 1];
        uglyArray[uglyAllIndex] = 1;
        uglyAllIndex ++;
        while (uglyAllIndex <= index) {
            int current = Math.min(uglyArray[uglyIndex2] * 2,
                    Math.min(uglyArray[uglyIndex3] * 3, uglyArray[uglyIndex5] * 5));
            uglyArray[uglyAllIndex] = current;
            while (uglyArray[uglyIndex2] * 2 <= current) {
                uglyIndex2++;
            }

            while (uglyArray[uglyIndex3] * 3 <= current) {
                uglyIndex3++;
            }

            while (uglyArray[uglyIndex5] * 5 <= current) {
                uglyIndex5++;
            }
            uglyAllIndex++;
        }

        return uglyArray[index];
    }
}
