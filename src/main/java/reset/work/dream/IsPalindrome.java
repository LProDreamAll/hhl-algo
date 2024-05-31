package reset.work.dream;

// 回文数
public class IsPalindrome {
    // 1221
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int temp = x;
        int result = 0;
        while (x > 0) {
            int k = x % 10;
            x = x / 10;
            result = result * 10 + k;
        }
        return temp == result;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(321));
    }
}
