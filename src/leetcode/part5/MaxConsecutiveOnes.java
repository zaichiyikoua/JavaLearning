package leetcode.part5;

/*
*	leetCode算法刷题记录   笔记46
*	@author  zaichiyikoua
*	@time  2020年2月13日
*	@title  { 最大连续1的个数 }
*/

//给定一个二进制数组， 计算其中最大连续1的个数。
//示例 1:
//输入: [1,1,0,1,1,1]
//输出: 3
//解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
//注意：
//输入的数组只包含 0 和1。
//输入数组的长度是正整数，且不超过 10,000。
public class MaxConsecutiveOnes {
    // 两个计数器
    public int solution(int[] nums) {
        // 记录1的个数
        int count = 0;
        // 记录当前最大个数
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                // 遇到1，计数
                count += 1;
            } else {
                // 遇到0，那么判断是不是最大个数
                maxCount = Math.max(maxCount, count);
                // 遇到了0，所以重置计数器
                count = 0;
            }
        }
        return Math.max(maxCount, count);
    }
}
