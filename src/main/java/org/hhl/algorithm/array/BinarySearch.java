package org.hhl.algorithm.array;

/**
 * 二分查找
 */
public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        //这里数组默认是有序的
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right -left) / 2;
            if (target < arr[mid]) {
                //这时需要继续在左边寻找，right 在下次循环的时候要提前变成当前的中间点，并且隐含当前中间值不等于target,需要往左多移动以一个坐标。
                right = mid - 1;
            }else if (target > arr[mid]) {
                left = mid + 1;
            }else {
                return mid;
            }

        }
        return -1;
    }

}
