package sward.offer67;

import javax.print.DocFlavor;

/**
 * @program: SwordDirectionOffer
 * @description: https://www.nowcoder.com/practice/1277c681251b4372bdef344468e4f26e?tpId=13&tqId=11202&tPage=3&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 把字符串转换成整数
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 *
 * +2147483647
 *  1a33
 *  2147483647
 *     0
 * @author: James
 * @create: 2019-09-07 20:12
 **/
public class StrToInt67 {

    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        boolean isNagetive = false;
        int index = 0, len = str.length();
        char[] chars = str.toCharArray();
        long ans = 0L;

        // maybe it will be - or +.
        if (chars[index] < '0') {
            if (chars[index] == '-') {
                isNagetive = true;
            } else if (chars[index] == '+') {
            // if it is not - or +,return 0
            } else {
                return 0;
            }
            if (len == 1) {
                return 0;
            }
            index++;
        }
        while (index < len) {
            if (chars[index] >= '0' && chars[index] <= '9') {
                ans = ans * 10 + (chars[index] - '0');
                if (!isNagetive && ans > Integer.MAX_VALUE) {
                    return 0;
                } else if (isNagetive && (-ans) < Integer.MIN_VALUE){
                    return 0;
                }
            } else {
                return 0;
            }
            ++index;
        }
        return isNagetive ? -(int)ans : (int)ans;
    }

    public static void main(String[] args) {
        long test = 2147483648L;
//        Integer.valueOf()
        System.out.println(test);
//        System.out.println(Character.digit('0', 10));
        System.out.println(parseInt("2147483647", 10));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        //  2147483647
        // -2147483648
        System.out.println(Math.pow(2, 31));
    }
    public static int parseInt(String s, int radix)
            throws NumberFormatException {
        if (s == null) {
            throw new NumberFormatException("null");
        }
//        记录是否是负数
        boolean negative = false;
        int i = 0, len = s.length();
        int limit = -Integer.MAX_VALUE;

        if (len > 0) {
            char firstChar = s.charAt(0);
            // Possible leading "+" or "-"
            if (firstChar < '0') {
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (firstChar != '+') {
                    throw new NumberFormatException(s);
                }
                // Cannot have lone "+" or "-"
                if (len == 1) {
                    throw new NumberFormatException(s);
                }
                i++;
            }

//
            int multmin = limit / radix;
            int result = 0;
            while (i < len) {
                // Accumulating negatively avoids surprises near MAX_VALUE
                int digit = Character.digit(s.charAt(i++), radix);
                // 当发现了小于-214748364的时候，再加上一个位肯定要超标的。。-2147483650超标，因为下面要加一个位，所以要违法的
                if (digit < 0 || result < multmin) {
                    throw new NumberFormatException(s);
                }
                result *= radix;
                if (result - digit < limit) {
                    throw new NumberFormatException(s);
                }
                result -= digit;
            }
            return negative ? result : -result;
        } else {
            throw new NumberFormatException(s);
        }
    }
}
