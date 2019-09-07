package sward.offer14;

/**
 * @program: SwordDirectionOffer
 * @description: https://www.nowcoder.com/practice/57d85990ba5b440ab888fc72b0751bf8?tpId=13&tqId=33257&tPage=4&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。
 * 请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * @author: James
 * @create: 2019-09-07 10:26
 **/
public class CutRope14 {

    public int cutRope(int target) {
        if (target < 1) {
            return 0;
        }

        int[] dp = new int[target + 1];
        dp[0] = 0 ;
        dp[1] = 1 ;
        for (int i = 1; i <= target; ++i) {
            int max = 0;
            for (int j = 1; j < i; ++j) {
                int firstMax = Math.max(j, dp[j]);
                int secondMax= Math.max(i - j, dp[i - j]);
                max = Math.max(max, firstMax * secondMax);
            }
            dp[i] = max;
        }
        return dp[target];
    }

    public static void main(String[] args) {
        CutRope14 cutRope14 = new CutRope14();
        System.out.println(cutRope14.cutRope(8));
    }

}
