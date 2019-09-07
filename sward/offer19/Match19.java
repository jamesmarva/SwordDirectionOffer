package sward.offer19;

/**
 * @program: SwordDirectionOffer
 * @description:
 * https://www.nowcoder.com/practice/45327ae22b7b413ea21df13ee7d6429c?tpId=13&tqId=11205&tPage=3&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * @author: James
 * @create: 2019-09-07 12:46
 **/
public class Match19 {

    char[] globalStr;
    char[] gloablPattern;
    boolean ans = false;
    public boolean match(char[] str, char[] pattern) {
        gloablPattern = pattern;
        globalStr = str;
        matchCore(0, 0, globalStr.length, gloablPattern.length);
        return ans;
    }

    public void matchCore(int indexChar, int indexPattern, int lenChar, int lenPattern) {
        if (ans) {
            return;
        }
        if (indexPattern == lenPattern) {
            if (indexChar == lenChar) {
                ans = true;
            }
            return;
        }
        boolean firstMatch = (indexChar < lenChar) &&
                    (globalStr[indexChar] == gloablPattern[indexPattern] || gloablPattern[indexPattern] == '.');
        if (indexPattern + 1 < lenPattern && gloablPattern[indexPattern + 1] == '*') {
//          假设这个*代表0，每次都要先判断这个。
            matchCore(indexChar, indexPattern + 2, lenChar, lenPattern);
//          如果匹配了，就匹配下一个
            if (firstMatch) {
                matchCore(indexChar + 1, indexPattern, lenChar, lenPattern);
            }
        } else if (firstMatch) {
            matchCore(indexChar + 1, indexPattern + 1, lenChar, lenPattern);
        }
    }
}
