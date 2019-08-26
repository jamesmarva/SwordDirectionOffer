package sward.offer58;

/**
 * @program: myleetcode
 * @description:
 * https://www.nowcoder.com/practice/12d959b108cb42b1ab72cef4d36af5ec?tpId=13&tqId=11196&tPage=3&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * @author: James
 * @create: 2019-08-25 19:22
 **/
public class LeftRotateString58 {


    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int moveLen = n % str.length();
        String move = str.substring(0, moveLen);
        String noMoving = str.substring(moveLen);
        return noMoving+move;
    }

    public static void main(String[] args) {
        String test="abcdefg";
        System.out.println(test.substring(1));
    }


}
