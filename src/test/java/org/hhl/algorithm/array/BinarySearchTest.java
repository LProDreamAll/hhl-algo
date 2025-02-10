package org.hhl.algorithm.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTest {
    @Test
    public void testBinarySearch() {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        assertEquals(3, BinarySearch.binarySearch(arr, 7));

        // 测试目标值在数组开头
        assertEquals(0, BinarySearch.binarySearch(arr, 1));

        // 测试目标值在数组末尾
        assertEquals(6, BinarySearch.binarySearch(arr, 13));

        // 测试目标值不在数组中
        assertEquals(-1, BinarySearch.binarySearch(arr, 8));
    }
}