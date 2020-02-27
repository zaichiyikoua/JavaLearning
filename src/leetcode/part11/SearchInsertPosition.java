package leetcode.part11;

/*
*	leetCode算法刷题记录   笔记102
*	@author  zaichiyikoua
*	@time  2020年2月27日
*	@title  { 搜索插入位置 }
*/

//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//你可以假设数组中无重复元素。
//示例 1:
//输入: [1,3,5,6], 5
//输出: 2
//示例 2:
//输入: [1,3,5,6], 2
//输出: 1
//示例 3:
//输入: [1,3,5,6], 7
//输出: 4
//示例 4:
//输入: [1,3,5,6], 0
//输出: 0
public class SearchInsertPosition {
    // 排序数组，目标值，查找返回索引
    // 看到这些关键字就应该想到二分
    public int solution(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            // 二分点，考虑到可能发生的整型溢出，使用 left + (right - left)/2 取mid更安全一点。
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 没找到返回应该插入的索引，观察发现就是左
        return left;
    }
}
