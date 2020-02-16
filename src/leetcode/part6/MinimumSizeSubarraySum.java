package leetcode.part6;

/*
*	leetCode算法刷题记录   笔记59
*	@author  zaichiyikoua
*	@time  2020年2月16日
*	@title  { 长度最小的子数组 }
*/

//给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
//示例: 
//输入: s = 7, nums = [2,3,1,2,4,3]
//输出: 2
//解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
public class MinimumSizeSubarraySum {
    public int solution(int s, int[] nums) {
        if (nums == null || nums.length < 0) {
            return 0;
        }
        // 初始化最小，这里要注意不能为0，因为之后的min()不管什么都是0最小。。
        int minSize = Integer.MAX_VALUE;
        // 和
        int sum = 0;
        // 慢指针初始化
        int index = 0;
        // i就是快指针
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // 满足和>=s的条件
            while (sum >= s) {
                // 快慢指针之间的距离就是连续子数组的长度，进行更新
                minSize = Math.min(minSize, i + 1 - index);
                // 重新计算和
                sum -= nums[index];
                // 移动慢指针
                index++;
            }
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}
