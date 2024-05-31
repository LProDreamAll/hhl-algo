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
    /**
     * xxxxx
     *   i
     * xxxx
     *  mn
     * n=m+1
     * 中心发散
     * 1-奇数
     * 2-偶数
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int length = s.length();
        int maxLen = 1, start = 0;
        for (int i = 0; i < length; i++) {
            int o1 = expandSearchLongest(s, i, i);
            int o2 = expandSearchLongest(s, i, i + 1);
            int max = Math.max(o2, o1);
            if (max > maxLen) {
                maxLen = max;
                //根据中心点计算长度
                start = i - (max - 1) / 2;
            }
        }
        //起始位置+长度
        return s.substring(start, start+ maxLen);
    }

    //  从[left, right]为中心向两端扩展，找到最长回文串，并返回最大长度
    private static int expandSearchLongest(String s, int l, int r) {
        int length = s.length();
        while (l >= 0 && r < length && (s.charAt(l) == s.charAt(r))) {
            l--;
            r++;
        }
        //r不在当前回文上，l最小能为0
        return r - l - 1;
    }

    public static String longestPalindrome2(String s) {
        //如果 i= j 相同
        //如果 i-1 = j 取决于二者相同
        // 否则得判断 二者相同加上 dp[j+1][i-1] 相同
        int maxLen = 1;
        int length = s.length();
        int start = 0;
        boolean[][] dp = new boolean[length][length];
        for (int m = 0; m < length; m++) {
            for (int n = m; n >= 0; n--) {
                if (m == n) {
                    dp[n][m] = true;
                } else if (n == m - 1) {
                    dp[n][m] = s.charAt(n) == s.charAt(m);
                } else {
                    dp[n][m] = (s.charAt(n) == s.charAt(m)) && dp[n + 1][m - 1];
                }
//                [j,i]为回文串且长度更大，更新
                if (dp[n][m] && (m - n + 1) > maxLen) {
                    maxLen = m - n + 1;
                    start = n;
                }
            }
        }

        return s.substring(start, start + maxLen);

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
        List<String> strings = Lists.newArrayList("cbbc", "babd", "aa", "aabbccc");
        for (String string : strings) {
            System.out.println("res: " + longestPalindrome(string));
        }
    }
}
