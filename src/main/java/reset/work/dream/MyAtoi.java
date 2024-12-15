package reset.work.dream;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class MyAtoi {
    public static int myAtoi(String s) {
        int[] mums = new int[58];
        for (int m = 48, n = 0; n < 10; m++, n++) {
            mums[m] = n;
        }
        long res = 0;
        if (s.isEmpty()) return 0;
        char[] chars = s.toCharArray();
        boolean flag = false;
        boolean read = false;
        for ( int i = 0; i < chars.length; i++) {
            if (chars[i] == ' '  ) {
                if (!read) {
                    continue;
                } else {
                    break;
                }
            }
            if ( chars[i] == '-' || chars[i] == '+' ){
                if (!read) {
                    if (chars[i] == '-') {
                        flag = true;
                    }
                    read = true;
                    continue;
                } else {
                    break;
                }
            }
            if ((int) chars[i] <= 57 && chars[i] >= 48) {
                res = res * 10 + mums[chars[i]];
                read = true;
                if (res > Integer.MAX_VALUE) {
                    if (flag) {
                        res = Integer.MIN_VALUE;
                    } else {
                        res = Integer.MAX_VALUE;
                    }
                    break;
                }
            } else {
                break;
            }
        }

        return flag ? -(int) res : (int) res;
    }

    public static void main(String[] args) {
//        List<String> strings = Lists.newArrayList("   -91283472332", "-+12", "-12", "+12", "12+","21474836460","   +0 123","9223372036854775808");
        List<String> strings = Lists.newArrayList("9223372036854775808");
        for (String s : strings) {
            int i = myAtoi(s);
            System.out.println("res1 = " + i);
        }
    }
}
