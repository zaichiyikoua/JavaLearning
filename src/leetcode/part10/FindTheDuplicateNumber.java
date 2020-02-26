package leetcode.part10;

import java.util.HashSet;

/*
*	leetCode算法刷题记录   笔记98
*	@author  zaichiyikoua
*	@time  2020年2月26日
*	@title  { 寻找重复数 }
*/

//给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
//示例 1:
//输入: [1,3,4,2,2]
//输出: 2
//示例 2:
//输入: [3,1,3,4,2]
//输出: 3
//说明：
//不能更改原数组（假设数组是只读的）。
//只能使用额外的 O(1) 的空间。
//时间复杂度小于 O(n2) 。
//数组中只有一个重复的数字，但它可能不止重复出现一次。
public class FindTheDuplicateNumber {
    // set解决，很方便，没有改变原数组，也只用了o(1)的额外空间
    public int solution(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i : nums) {
            if (hashSet.contains(i)) {
                return i;
            }
            hashSet.add(i);
        }
        return 0;
    }
}
