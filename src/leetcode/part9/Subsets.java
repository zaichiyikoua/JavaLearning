package leetcode.part9;

import java.util.ArrayList;
import java.util.List;

/*
*	leetCode算法刷题记录   笔记86
*	@author  zaichiyikoua
*	@time  2020年2月23日
*	@title  { 子集 }
*/

//给定一个没有重复数字的序列，返回其所有可能的全排列。
//示例:
//输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
public class Subsets {
    // 和全排列一样 经典回溯法
    public List<List<Integer>> solution(int[] nums) {
        ArrayList<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if (nums == null || nums.length <= 0) {
            return resultList;
        }
        // 追踪数组
        ArrayList<Integer> trackList = new ArrayList<Integer>();
        detail(nums, trackList, resultList, 0);
        return resultList;
    }

    public void detail(int[] nums, ArrayList<Integer> trackList, ArrayList<List<Integer>> resultList, int number) {
        resultList.add(new ArrayList<Integer>(trackList));
        for (int i = number; i < nums.length; i++) {
            trackList.add(nums[i]);
            detail(nums, trackList, resultList, i + 1);
            // 回溯
            trackList.remove(trackList.size() - 1);
        }
    }
}
