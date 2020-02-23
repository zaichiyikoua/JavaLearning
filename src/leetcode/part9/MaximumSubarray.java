package leetcode.part9;

/*
*	leetCode算法刷题记录   笔记81
*	@author  zaichiyikoua
*	@time  2020年2月23日
*	@title  { 最大子序和 }
*/

//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//示例:
//输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
public class MaximumSubarray {
    // 贪心法，每次都找到子序和最大的，到最后就是全局最优的方案
    public int solution(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        // 当前子序和初始化
        int currentSum = nums[0];
        // 最大子序和初始化
        int maxSum = nums[0];
        // 遍历数组，每一次都找最大的子序和，保存起来
        for (int i = 1; i < nums.length; i++) {
            // 当前子序和 和 当前值 取最大
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    // 评论中的解法
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            res = Math.max(res, sum);
        }
        return res;
    }
}
