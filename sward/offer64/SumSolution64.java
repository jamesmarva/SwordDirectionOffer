package sward.offer64;

/**
 * @program: SwordDirectionOffer
 * @description:
 * https://www.nowcoder.com/practice/7a0da8fc483247ff8800059e12d7caf1?tpId=13&tqId=11200&tPage=3&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * @author: James
 * @create: 2019-08-28 07:32
 **/
public class SumSolution64 {

    public int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (sum > 0) && ((sum+=Sum_Solution(--n)) > 0);
        return sum;
    }
}
