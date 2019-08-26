package sward.offer05;

/**
 * @program: myleetcode
 * @description:
 * https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * @author: James
 * @create: 2019-08-21 07:17
 **/
public class ReplaceSpace05 {

    public String replaceSpace(StringBuffer str) {
        if (str == null) {
            return "";
        }

        String temp  = str.toString();
        temp = temp.replaceAll(" ", "%20");
        return temp;
    }
}
