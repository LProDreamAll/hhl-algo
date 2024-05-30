package reset.work.list.node;

/**
 * 寻找两个正序数组的中位数
 * <a href="https://leetcode.cn/problems/median-of-two-sorted-arrays/description/">...</a>
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * <p>
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * <p>
 * 提示：
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class FindMedianSortedArrays {
    /**
     * a.合并数组，最大长度是两个数组之和
     * b.两个指针，i1,i2.每次取小的数放到前面，被放进去数组的指针要前移动，大的不动。
     * c.当指针到达某一个数组的长度的时候,给他设置最大值，后续不参与赋值了
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index1 = 0, index2 = 0;
        int sumLen = nums1.length + nums2.length;
        int[] res = new int[sumLen];
        for (int i = 0; i < sumLen; i++) {
            int n1;
            //当指针到达某一个数组的长度的时候,给他设置最大值，后续不参与赋值了
            if (index1 == nums1.length) {
                n1 = Integer.MAX_VALUE;
            } else {
                n1 = nums1[index1];
            }
            int n2;
            if (index2 == nums2.length) {
                n2 = Integer.MAX_VALUE;
            } else {
                n2 = nums2[index2];
            }
            if (n1 <= n2) {
                res[i] = n1;
                index1++;
            } else {
                res[i] = n2;
                index2++;
            }
        }

        if (sumLen % 2 == 1) {
            return res[sumLen / 2];
        } else {
            int mid = sumLen / 2;
            return (double) (res[mid] + res[mid - 1]) / 2;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {3, 4};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println("medianSortedArrays = " + medianSortedArrays);
    }
}
