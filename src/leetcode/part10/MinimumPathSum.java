package leetcode.part10;

/*
*	leetCode算法刷题记录   笔记93
*	@author  zaichiyikoua
*	@time  2020年2月25日
*	@title  { 最小路径和 }
*/

//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//说明：每次只能向下或者向右移动一步。
//示例:
//输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
public class MinimumPathSum {
    // 动态规划找到每一条路径，计算它的路径权值和
    public int solution(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        // dp
        int[][] dp = new int[m][n];
        // 同样的，只有向下和向右两种状态
        // 从左上角开始
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 同样考虑边界，
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    // dp方程，当前值+左边的值
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else if (j == 0) {
                    // dp方程，当前值+上边的值
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else {
                    // 除边界条件之外的大多数情况，因为是找最小路径和
                    // dp方程，当前值+左边上边两者更小的值
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
