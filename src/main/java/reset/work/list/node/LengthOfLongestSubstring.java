package reset.work.list.node;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 */
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring1(String s) {
        if (s.length() == 1) return 1;
        int max = 0;
        for (int m = 0; m < s.length(); m++) {
            Map<Character, Integer> map = new HashMap<>();
            System.out.println("f:" + s.charAt(m));
            map.put(s.charAt(m), 1);
            for (int n = m + 1; n < s.length(); n++) {
                System.out.println("s:" + s.charAt(n));
                if (map.containsKey(s.charAt(n))) {
                    System.out.println("s1:" + s.charAt(n));
                    max = Math.max(max, map.size());
                    map = new HashMap<>();
                } else {
                    System.out.println("s2:" + s.charAt(n));
                    map.put(s.charAt(n), 1);
                    max = Math.max(max, map.size());
                }
            }
        }
        return max;
    }

    /**
     * 无重复字符的最长子串
     * zdklss   left , i -> 每次都记录长度和当前索引
     * zzdklss  left 第一次往前移动一位 left , i -> 每次都记录长度和当前索引 i - left + 1
     * zzdklssabcd  left 移动到 a left , i -> 每次都记录长度和当前索引 i - left + 1
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int i1 = map.get(s.charAt(i)) + 1;
                //只要遇到重复的就代表在这一段窗口内最大的距离是left没有改变前(因为获取的是最长子串，是连续的)
                left = Math.max(left, i1);
            }
            map.put(s.charAt(i), i);
            System.out.println("i :" + i);
            System.out.println("maxLen :" + maxLen + " 差值: " + (i - left + 1));
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int i = lengthOfLongestSubstring("abcabcbb");
        System.out.println("res = " + i);


    }


}
