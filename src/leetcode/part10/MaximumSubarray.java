package leetcode.part10;

/*
*	leetCode算法刷题记录   笔记95
*	@author  zaichiyikoua
*	@time  2020年2月26日
*	@title  { 最大子序和(动态规划) }
*/

//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//示例:
//输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
public class MaximumSubarray {
    // 之前是用贪心做的 这次用动态规划做
    public int solution(int[] nums) {
        // dp
        int[] dp = new int[nums.length];
        // 初始化
        dp[0] = nums[0];
        int maxValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // dp方程 不选的当前值 和 选了之后的值
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            // 更新max
            maxValue = dp[i] > maxValue ? dp[i] : maxValue;
        }
        return maxValue;
    }
}
