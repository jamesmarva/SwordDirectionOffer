package sward.offer38;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * @program: myleetcode
 * @description:
 * https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7?tpId=13&tqId=11180&tPage=2&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 这里牛客网的题目就是一坨屎，妈的，强烈建议用Leetcode
 * @author: James
 * @create: 2019-08-24 12:54
 **/
public class Permutation38 {

    HashSet<String> ans = new HashSet<>();
    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList<>();
        }
        dfs(str.toCharArray(), 0, str.length());
        ArrayList<String> ansList = new ArrayList<>(ans);
        Collections.sort(ansList);
        return ansList;
    }

    private void dfs(char[] chars, int index, int length) {
        if (index == length) {
            ans.add(new String(chars));
        }
        for (int i = index; i < length; ++i) {
            swap(chars, index, i);
            dfs(chars, index+1, length);
            swap(chars, index, i);
        }
    }

    private void swap(char[] chars, int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
}
