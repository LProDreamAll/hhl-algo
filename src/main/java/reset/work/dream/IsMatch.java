package reset.work.dream;

/**
 * 正则表达式
 */
public class IsMatch {
    public boolean isMatch(String s, String p) {
        // 双指针 sIndex pIndex
        //p 遇到. 匹配当前字符
        //p 遇到* 前面是. ,前面没有值，前面有字符(还需要看前面一位)
        //p 遇到正常字符正常对比即可。 (保证每次出现字符 * 时，前面都匹配到有效的字符)
        // 1-循环s即可
        return true;
    }
}
