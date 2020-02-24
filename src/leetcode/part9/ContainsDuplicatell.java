package leetcode.part9;

import java.util.HashMap;

/*
*	leetCode算法刷题记录   笔记87
*	@author  zaichiyikoua
*	@time  2020年2月24日
*	@title  { 存在重复元素ll }
*/

//给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
//示例 1:
//输入: nums = [1,2,3,1], k = 3
//输出: true
//示例 2:
//输入: nums = [1,0,1,1], k = 1
//输出: true
//示例 3:
//输入: nums = [1,2,3,1,2,3], k = 2
//输出: false
public class ContainsDuplicatell {
    // 使用hashmap解决
    public boolean solution(int[] nums, int k) {
        if (nums == null || nums.length <= 0) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            // 一次遍历，map中没有就进行映射
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                // 判断是否满足条件
                int index = map.get(nums[i]);
                // 这里要注意理解题目，最大为k，所以是小于等于k 不是等于k
                // 不然测试用例nums = [1, 0, 1, 1] k = 1 会挂
                if (Math.abs(index - i) <= k) {
                    return true;
                }
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
