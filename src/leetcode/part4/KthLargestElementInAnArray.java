package leetcode.part4;

import java.util.Arrays;

/*
*	leetCode算法刷题记录   笔记32
*	@author  zaichiyikoua
*	@time  2020年2月9日
*	@title  { 数组中的第K个最大元素 }
*/

//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//示例 1:
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
//示例 2:
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4
//说明:
//你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
public class KthLargestElementInAnArray {
    // 最简单直接的方式，对数组进行排序，排序之后的数组第K个最大的元素就是倒数第K个
    public int solution(int[] nums, int k) {
        Arrays.sort(nums);// 默认快排
        return nums[nums.length - k];
    }
}
