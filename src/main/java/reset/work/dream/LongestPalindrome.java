package reset.work.dream;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 给你一个字符串 s，找到 s 中最长的
 * 回文(如果字符串向前和向后读都相同，则它满足 回文性。)
 * 子串(连续的非空字符串)
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 */
public class LongestPalindrome {
    //https://leetcode.cn/problems/longest-palindromic-substring/solutions/2746518/javapython3cdong-tai-gui-hua-zhong-xin-k-frpr/
    public static String longestPalindrome(String s) {
        return null;

    }


    public static String longestPalindrome1(String s) {
        int length = s.length();
        if (length == 1) return s;
        String temp = "";
        int maxLen = 0;
        for (int fast = 0; fast < length; fast++) {
            for (int slow = fast + 1; slow <= length; slow++) {
                String substring = s.substring(fast, slow);
                if (judge(substring)) {
                    if (maxLen < substring.length()) {
                        maxLen = substring.length();
                        temp = substring;
                    }
                }
            }
        }
        return temp;
    }


    private static boolean judge(String s) {
        int length = s.length();
        if (length == 0) return true;
        for (int m = 0, n = length - 1; m <= length / 2 && n >= length / 2; m++, n--) {
            if (s.charAt(m) != s.charAt(n)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        List<String> strings = Lists.newArrayList("cbbc", "baabd", "aa", "aabbccc");
        for (String string : strings) {
            System.out.println("res: " + longestPalindrome1(string));
        }
    }
}
