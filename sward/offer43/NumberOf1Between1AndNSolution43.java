package sward.offer43;

/**
 * @program: myleetcode
 * @description:
 * https://www.nowcoder.com/practice/bd7f978302044eee894445e244c7eee6?tpId=13&tqId=11184&tPage=2&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 * @author: James
 * @create: 2019-08-24 16:51
 **/
public class NumberOf1Between1AndNSolution43 {


    public static int numberOf1Between1AndN_Solution(int n) {
        if (n <= 0) {
            return 0;
        }
        String nString = (n + "");
        char[] chars = (n + "").toCharArray();
        int ans = 0;
        for (int i = 0, len = chars.length; i < len; ++i) {
            int first = Integer.parseInt(chars[i]+"");
            if ( first > 1) {
                ans += 1 * Math.pow(10, len - 1 - i);
            } else {
                ans += Integer.parseInt(nString.substring(i + 1, len)) + 1;
            }
            if (i < len - 2) {
                ans += first * Math.pow(10, len - 2 - i) * (len - 1 - i);
            }
        }
        return ans;
    }

    public static int numberOf1Between1AndN_Solution2(int n) {
        if (n <= 0) {
            return 0;
        }
        String stringN = n + "";
        int ans = 0;
        while (!stringN.isEmpty()) {
            int tempLen = stringN.length();
            String firstChar  = stringN.charAt(0) + "";
            int firstNum = Integer.parseInt(firstChar);
            if (firstNum >= 2) {
                ans += 1 * Math.pow(10, tempLen - 1);
            } else if (firstChar.equals("1")) {
                if ("".equals(stringN.substring(1, tempLen))) {
                    ans += 1;
                } else {
                    ans += Integer.parseInt(stringN.substring(1, tempLen)) + 1;
                }
            }
            if (tempLen > 1) {
                ans += firstNum * (tempLen - 1) * Math.pow(10, tempLen - 2);
            }
            stringN = stringN.substring(1);
        }
        return ans;
    }


    public static void main(String[] args) {
        String test = "1234567890";
        System.out.println(test.substring(9, test.length()));

        System.out.println('a'+"");
        System.out.println(numberOf1Between1AndN_Solution(21345));

    }
}
