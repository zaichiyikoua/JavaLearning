package leetcode.part7;

import java.util.HashSet;

/*
*	leetCode算法刷题记录   笔记69
*	@author  zaichiyikoua
*	@time  2020年2月19日
*	@title  { 只出现一次的数字 }
*/

//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//说明：
//你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//示例 1:
//输入: [2,2,1]
//输出: 1
//示例 2:
//输入: [4,1,2,1,2]
//输出: 4
public class SingleNumber {
    // 使用set来完成
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            // 如果set中已存在，那么删掉
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        // set中只会保留一个，所以直接返回
        for (Integer inti : set) {
            return inti;
        }
        return -1;
    }
}
