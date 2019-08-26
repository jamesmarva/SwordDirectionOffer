package sward.offer53;

/**
 * @program: myleetcode
 * @description:
 * nowcoder.com/practice/623a5ac0ea5b4e5f95552655361ae0a8?tpId=13&tqId=11203&tPage=3&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * @author: James
 * @create: 2019-08-25 18:13
 **/
public class GetNumberOfK53 {

    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 0, len  = array.length; i < len; ++i){
            if (array[i] == k) {
                ans++;
            } else if (ans > 0 && array[i] != k) {
                return ans;
            }
        }
        return ans;
    }
}
