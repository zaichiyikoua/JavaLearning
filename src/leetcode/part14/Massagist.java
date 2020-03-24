package leetcode.part14;

/*
*	leetCode算法刷题记录   笔记135
*	@author  zaichiyikoua
*	@time  2020年3月24日
*	@title  { 按摩师 }
*/

//一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
//在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
//给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长）
//返回总的分钟数。
//注意：本题相对原题稍作改动
//示例 1：
//输入： [1,2,3,1]
//输出： 4
//解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
//示例 2：
//输入： [2,7,9,3,1]
//输出： 12
//解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
//示例 3：
//输入： [2,1,4,5,3,1,1,3]
//输出： 12
//解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
public class Massagist {
    // 又是一道找最优解的题 那就还是找dp方程
    public int massage(int[] nums) {
        // dp初始化
        int[] dp = new int[nums.length];
        // 特殊值
        // 只有1天的时候，必须接受预约，因此 dp[0] = nums[0]
        dp[0] = nums[0];
        // 头2天的时候，由于不能同时接受预约，因此最优值是这两天接受预约时长的最大值
        dp[1] = Math.max(nums[0], nums[1]);
        if (nums == null || nums.length <= 0) {
            return dp[0];
        }
        for (int i = 2; i < nums.length; i++) {
            // dp方程
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
