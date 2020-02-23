package leetcode.part9;

/*
*	leetCode算法刷题记录   笔记82
*	@author  zaichiyikoua
*	@time  2020年2月23日
*	@title  { 合并两个有序数组 }
*/

//给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
//说明:
//初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
//你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
//示例:
//输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//输出: [1,2,2,3,5,6]
public class MergeSortedArray {
    // 比较取巧的办法 双指针法
    // 从数组后面向前移动指针，对数组1赋值
    public void solution(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - 1; // 放元素的尾部
        int tail1 = m - 1; // 数组一的尾部
        int tail2 = n - 1; // 数组二的尾部
        while (tail2 >= 0) {
            if (tail1 < 0) { // 这一行是把下面注释的while简化到这里了
                nums1[index--] = nums2[tail2--];
            } else if (nums1[tail1] >= nums2[tail2]) {
                nums1[index--] = nums1[tail1--];
            } else {
                // nums1[tail1] < nums2[tail2]
                nums1[index--] = nums2[tail2--];
            }
        }
    }
}
