package leetcode.part3;

import java.util.Arrays;

/*
*	leetCode算法刷题记录   笔记25
*	@author  zaichiyikoua
*	@time  2020年2月7日
*	@title  { 数组拆分l }
*/

//给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
//示例 1:
//输入: [1,4,3,2]
//输出: 4
//解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
//提示:
//n 是正整数,范围在 [1, 10000].
//数组中的元素范围在 [-10000, 10000].
public class ArrayPartitionl {
    // 这道题首先想到的就是先对数组进行排序，然后再找最小值的总和
    // 仔细观察能够发现，最大总和就是1 3 5...这样的规律进行求和
    public int solution(int[] nums) {
        if (nums == null || nums.length < 0) {
            return 0;
        }
        Arrays.sort(nums);
        int resultNumber = 0;
        // 就是这个 +=2 比较关键，都是隔一个数相加
        for (int i = 0; i < nums.length; i += 2) {
            resultNumber += nums[i];
        }
        return resultNumber;
    }
}
