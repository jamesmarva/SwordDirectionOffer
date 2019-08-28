package sward.offer50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: myleetcode
 * @description:
 * https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c?tpId=13&tqId=11187&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 *
 * @author: James
 * @create: 2019-08-24 23:21
 **/
public class FirstNotRepeatingChar50 {

    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (int i = 0, len = chars.length; i < len; ++i) {
            char temp = chars[i];
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        for (int i = 0, len = chars.length; i < len; ++i) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    public int FirstNotRepeatingCharVersion2(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        int[] map = new int[256];
        char[] chars = str.toCharArray();
        for (int i = 0, len = chars.length; i < len; ++i) {
            char temp = chars[i];
            map[temp]++;
        }
        for (int i = 0, len = chars.length; i < len; ++i) {
            if (map[chars[i]] == 1) {
                return i;
            }
        }
        return -1;
    }




    private int index;
    private int[] chars = new int[256];

    public FirstNotRepeatingChar50() {
        Arrays.fill(chars, -1);
    }
    //Insert one char from stringstream
    public void Insert(char ch) {
        if (chars[ch] < 0) {
            chars[ch] = index;
        } else if (chars[ch] >= 0) {
            chars[ch] = -2;
        }
        index++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        int minIndex = Integer.MAX_VALUE;
        char ans = '#';
        for (int i = 0; i < 256; ++i) {
            if (chars[i] >= 0 && minIndex > chars[i]) {
                ans = (char) i;
                minIndex = chars[i];
            }
        }
        return ans;
    }
}
