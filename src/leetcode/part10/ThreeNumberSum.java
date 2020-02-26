package leetcode.part10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
*	leetCode算法刷题记录   笔记99
*	@author  zaichiyikoua
*	@time  2020年2月26日
*	@title  { 三数之和 }
*/

//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
//注意：答案中不可以包含重复的三元组。
//示例：
//给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
public class ThreeNumberSum {
    // leetCode非常经典的一道题
    // 先固定一个元素，然后使用对撞指针寻找
    public List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int len = nums.length;
        if (nums == null || len < 3) {
            return ans;
        }
        // 排序之后小的在前，大的在后
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            // 优化，如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (nums[i] > 0) {
                break;
            }
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++; // 去重
                    }
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--; // 去重
                    }
                    L++;
                    R--;
                } else if (sum < 0)
                    // 如果小于0，那么必定头指针的值小，所以移动指针
                    L++;
                else if (sum > 0)
                    R--;
            }
        }
        return ans;
    }
}
