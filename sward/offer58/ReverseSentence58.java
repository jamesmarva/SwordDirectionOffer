package sward.offer58;

import java.io.OutputStream;
import java.util.Arrays;

/**
 * @program: SwordDirectionOffer
 * @description: https://www.nowcoder.com/practice/3194a4f4cf814f63919d0790578d51f3?tpId=13&tqId=11197&tPage=3&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
    牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
    同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
    例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
    Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * @author: James
 * @create: 2019-09-07 08:38
 **/
public class ReverseSentence58 {

    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0 || str.length() == 1) {
            return str;
        }
        String strNew = new StringBuilder(str).reverse().toString();
        char[] strChars = strNew.toCharArray();
        int len = strNew.length();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < len;) {
            if (strChars[i] != ' ') {
                StringBuilder sb = new StringBuilder();
                while (i < len && strChars[i] != ' ') {
                    sb.append(strChars[i]);
                    ++i;
                }
                ans.append(sb.reverse().toString());
            } else {
                ans.append(strChars[i]);
                ++i;
            }
        }
        return ans.toString();
    }

    public String ReverseSentenceNew(String str) {
        if (str == null || str.trim().equals("")) {
            return str;
        }
        String[] strs = str.split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; --i) {
            ans.append(strs[i]);
            if (i != 0){
                ans.append(" ");
            }
        }
        return ans.toString();
    }


    public static void main(String[] args) {
        String test = " ";
        String[] testArr = test.split(" ");
        ReverseSentence58 reverseSentence58 = new ReverseSentence58();
        System.out.println(test.length());
        System.out.println(reverseSentence58.ReverseSentence(test).length());
        System.out.println(Arrays.toString(testArr));
    }
}
