package leetcode.part10;

/*
*	leetCode算法刷题记录   笔记100
*	@author  zaichiyikoua
*	@time  2020年2月26日
*	@title  { 打家劫舍 }
*/

//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
//给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
//示例 1:
//输入: [1,2,3,1]
//输出: 4
//解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//偷窃到的最高金额 = 1 + 3 = 4 。
//示例 2:
//输入: [2,7,9,3,1]
//输出: 12
//解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//偷窃到的最高金额 = 2 + 9 + 1 = 12 。
public class Rob {
    public int solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[1];
        }
        int[] dp = new int[nums.length];
        // 特殊值
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            // 如果要打劫第n家，就必然不能打劫第n-1家
            // 所以打劫第n家得到的钱一共是第n家的钱加上前n-2家获得的最多的钱，即：f(n-2)+nums(n)，
            // 如果不打劫第n家，获得的最大收益就是f(n-1)，两者我们要去较大的那个
            // dp方程
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
