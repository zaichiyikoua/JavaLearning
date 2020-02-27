package leetcode.part11;

/*
*	leetCode算法刷题记录   笔记103
*	@author  zaichiyikoua
*	@time  2020年2月27日
*	@title  { 在排序数组中查找元素的第一个和最后一个位置 }
*/

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//你的算法时间复杂度必须是 O(log n) 级别。
//如果数组中不存在目标值，返回 [-1, -1]。
//示例 1:
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4]
//示例 2:
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1]
public class FindFirstAndLastPositionOfElementInSortedArray {
    // 因为要求了时间复杂度，所以二分
    public int[] solution(int[] nums, int target) {
        // 返回数组初始化
        int[] result = new int[] { -1, -1 };
        int left = 0;
        int right = nums.length - 1;
        // 二分
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 此时找到出现的target，但是可能并不是第一次出现或者最后一次出现的target
                // 所以以这个点为起点向前向后找第一个和最后一个
                result[0] = findLeft(nums, target, left, mid);
                result[1] = findRight(nums, target, mid, right);
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    // 向前找
    private int findLeft(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int pivot = (start + end) / 2;

            if (nums[pivot] == target) {
                if (pivot == 0 || nums[pivot - 1] < target) {
                    return pivot;
                } else {
                    end = pivot - 1;
                }
            } else {
                start = pivot + 1;
            }
        }

        return -1;
    }

    // 向后找
    private int findRight(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int pivot = (start + end) / 2;

            if (nums[pivot] == target) {
                if (pivot == nums.length - 1 || nums[pivot + 1] > target) {
                    return pivot;
                } else {
                    start = pivot + 1;
                }
            } else {
                end = pivot - 1;
            }
        }

        return -1;
    }
}
