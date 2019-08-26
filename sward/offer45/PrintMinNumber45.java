package sward.offer45;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: myleetcode
 * @description: https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993?tpId=13&tqId=11185&tPage=2&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * @author: James
 * @create: 2019-08-24 18:57
 **/
public class PrintMinNumber45 {
    public String PrintMinNumber(int [] numbers) {
        StringBuilder ans = new StringBuilder();
        if (numbers==null || numbers.length==0) {
            return ans.toString();
        }
        ArrayList<String> list = new ArrayList<String>();
        for (int item : numbers) {
            list.add(item + "");
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String o1o2 = o1 + o2;
                String o2o1 = o2 + o1;
                for (int i = 0, len = o1o2.length(); i < len; ++i) {
                    if (o1o2.charAt(i) < o2o1.charAt(i)) {
                        return -1;
                    } else if (o1o2.charAt(i) > o2o1.charAt(i)) {
                        return 1;
                    }
                }
                return 0;
            }
        });
        for (String item : list) {
            System.out.println(item);
            ans.append(item);
        }
        String ansString = ans.toString();
        while (ansString.length() > 1) {
            if (ansString.charAt(0) == '0') {
                ansString = ansString.substring(1);
            } else {
                break;
            }
        }
        return ansString;
    }
}
