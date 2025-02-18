package org.hhl.algorithm.array;

public class Demo {

    public static int find(int[] arr, int k) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l+ (r - l) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] < k) {
                l = mid + 1;
            } else {
                r=mid -1;
            }
        }
        return -1;
    }
}
