package leetcode.part3;

import java.util.HashSet;

/*
*	leetCode算法刷题记录   笔记26
*	@author  zaichiyikoua
*	@time  2020年2月9日
*	@title  { 存在重复 }
*/

//给定一个整数数组，判断是否存在重复元素。
//如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
//示例 1:
//输入: [1,2,3,1]
//输出: true
//示例 2:
//输入: [1,2,3,4]
//输出: false
//示例 3:
//输入: [1,1,1,3,3,4,3,2,4,2]
//输出: true
public class ContainsDuplicate<E> {
    // 很典型的判断是否重复，遍历数组，将元素放进hashset中，每次判断一下
    public boolean solution(int[] nums) {
        boolean flag = false;
        if (nums == null || nums.length < 0) {
            return flag;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return flag = true;
            }
            set.add(nums[i]);
        }
        return flag;
    }
}
