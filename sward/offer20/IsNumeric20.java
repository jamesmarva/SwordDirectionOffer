package sward.offer20;

/**
 * @program: SwordDirectionOffer
 * @description: https://www.nowcoder.com/practice/6f8c901d091949a5837e24bb82a731f2?tpId=13&tqId=11206&tPage=3&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 表示数字的字符串
 * @author: James
 * @create: 2019-09-07 17:07
 **/
public class IsNumeric20 {
    public boolean isNumeric(char[] str) {
        if (str == null) {
            return false;
        }
        int length = str.length;
        int index = 0;
        ResultAndIndex tempAns = scanInteger(str, index, length);
        index = tempAns.getIndex();
        boolean ans = tempAns.getResult();
        if (index < length && str[index] == '.') {
            ++index;
            /**
             * 1 小数可以没有整数， .123
             * 2 小数点后面可以没有数字 233.（这都行？）
             * 3 可以前后都有
             * 那要怎么搞+.111，难道等于 0.111?
             * 小数点之后只能跟整数
             */
            tempAns = scanZeroToNight(str, index, length);
            index = tempAns.getIndex();
            ans = ans || tempAns.getResult();
        }
        if (index < length && (str[index] == 'e' || str[index] == 'E')) {
            ++index;
            /**
             * e 的判断一点要有整数 .e1 或者 E1 都是不合理的数字
             * 且e或者E的后面也同样要有数字
             */
            tempAns = scanInteger(str, index, length);
            index = tempAns.getIndex();
            ans = ans && tempAns.getResult();
        }
        return ans && index == str.length;
    }

    public ResultAndIndex scanZeroToNight(char[] str, int index, int length) {
        int pre = index;
        while (index < length && str[index] >='0' && str[index] <= '9') {
            ++index;
        }
        ResultAndIndex res = new ResultAndIndex(index);

        //  no Integer, return false.
        if (index == pre) {
            res.setResult(false);
            return res;
        }
        res.setResult(true);
        return res;
    }

    private  ResultAndIndex scanInteger(char[] str, int index, int length) {
        if (index < length && (str[index] == '+' || str[index] == '-')) {
            ++index;
        }
        return scanZeroToNight(str, index, length);
    }
    class ResultAndIndex {
        private boolean result;
        private int index;
        ResultAndIndex(int index) {
            this.index = index;
        }
        public int getIndex() {
            return index;
        }
        public void setIndex(int index) {
            this.index = index;
        }
        public void setResult(boolean result) {
            this.result = result;
        }
        public  boolean getResult() {
            return this.result;
        }
    }

}
