package leetcode.part9;

import java.util.HashSet;

/*
*	leetCode算法刷题记录   笔记84
*	@author  zaichiyikoua
*	@time  2020年2月23日
*	@title  { 缺失数字 }
*/

//给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
//示例 1:
//输入: [3,0,1]
//输出: 2
//示例 2:
//输入: [9,6,4,2,3,5,7,0,1]
//输出: 8
public class MissingNumber {
    // 使用set来完成 这样很好理解，又很快
    public int solution(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        // 将数组中的所有元素放进set中
        for (int i : nums) {
            set.add(i);
        }
        // 原本应该是0-n
        int count = nums.length + 1;
        for (int i = 0; i < count; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}
