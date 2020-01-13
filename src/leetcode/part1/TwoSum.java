package leetcode.part1;

import java.util.HashMap;

/*
*   leetCode算法刷题记录   笔记1
*   @author  zaichiyikoua
*   @time  2020年1月13日
*   @title  { 两数之和 }
*/

//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
//示例:
//给定 nums = [2, 7, 11, 15], target = 9
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]

public class TwoSum {

    // 思路
    // 要不能重复使用数组中的元素,所以可以用hashmap,遍历数组,如果有两个数的和等于目标值,则返回这两个数
    // 这样使用hashmap的话速度还是很快的
//    执行用时 :3 ms, 在所有 Java 提交中击败了97.82%的用户
    @SuppressWarnings("null")
    public int[] solution(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 输入值检测
        if (nums == null && nums.length < 2) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        // 遍历数组，放入map
        for (int i = 0; i < nums.length; i++) {
            // 存在两数之和
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                result[0] = map.get(temp);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    // 暴力法，思路简单直接
    // 遍历该数组，找到两个数的和为目标值
    // 这是最慢的方法吧，但是简单直接
//    执行用时 :51 ms, 在所有 Java 提交中击败了10.00%的用户

    @SuppressWarnings("null")
    public int[] solution2(int[] nums, int target) {
        int[] result = new int[2];
        // 输入值检测
        if (nums == null && nums.length < 2) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        // 暴力解决，两层遍历，寻找是否存在这两个数
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }
}
