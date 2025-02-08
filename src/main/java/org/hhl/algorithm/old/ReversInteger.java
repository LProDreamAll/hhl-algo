package org.hhl.algorithm.old;

/**
 * 整数反转
 * <p>
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 */
public class ReversInteger {
    public static int reverse(int x) {
        long res = 0;
        while (x != 0) {
            int k = x % 10;
            x = x / 10;
            res = res * 10 + k;
        }
        return res == (int) res ? (int) res : 0;

    }

    public static void main(String[] args) {
        int reverse = reverse(-1234567);
        System.out.println("reverse = " + reverse);
    }
}
