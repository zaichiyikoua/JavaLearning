package leetcode.part4;

import java.util.HashMap;

/*
*	leetCode算法刷题记录   笔记31
*	@author  zaichiyikoua
*	@time  2020年2月9日
*	@title  { 多数元素 }
*/

//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
//你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//示例 1:
//输入: [3,2,3]
//输出: 3
//示例 2:
//输入: [2,2,1,1,1,2,2]
//输出: 2
public class MajorityElement {
    // 遍历数组，用hashmap去记录数组元素出现的次数，然后返回大于 n/2的元素
    public int solution(int[] nums) {
        if (nums == null || nums.length < 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 要返回的数
        int resultNumber = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果map中没有，就初始化
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                // 已经存在，那么次数+1
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            // 然后判断有没有大于 n/2
            if (map.get(nums[i]) > nums.length / 2) {
                resultNumber = nums[i];
            }
        }
        return resultNumber;
    }
}
