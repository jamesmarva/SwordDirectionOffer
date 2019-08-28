package sward.offer65;

/**
 * @program: SwordDirectionOffer
 * @description: https://www.nowcoder.com/practice/59ac416b4b944300b617d4f7f111b215?tpId=13&tqId=11201&tPage=3&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * @author: James
 * @create: 2019-08-28 07:37
 **/
public class Add65 {

    public int Add(int num1,int num2) {

        int sum = 0;
        int carry = 0;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 =carry;
        } while (num2 != 0);
        return sum;
    }
}
