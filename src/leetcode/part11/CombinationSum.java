package leetcode.part11;

import java.util.ArrayList;
import java.util.List;

/*
*	leetCode算法刷题记录   笔记109
*	@author  zaichiyikoua
*	@time  2020年2月29日
*	@title  { 组合总数 }
*/

//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//candidates 中的数字可以无限制重复被选取。
//说明：
//所有数字（包括 target）都是正整数。
//解集不能包含重复的组合。 
//示例 1:
//输入: candidates = [2,3,6,7], target = 7,
//所求解集为:
//[
//  [7],
//  [2,2,3]
//]
//示例 2:
//输入: candidates = [2,3,5], target = 8,
//所求解集为:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//]
public class CombinationSum {
    // 现在做了很多的算法题了，也算有了点经验，看到之后大概知道用 回溯 解
    public List<List<Integer>> solution(int[] candidates, int target) {
        // 要返回的list
        ArrayList<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return resultList;
        }
        // track数组
        ArrayList<Integer> track = new ArrayList<Integer>();
        backTrack(candidates, resultList, track, target, 0);
        return resultList;
    }

    // 最后一个start参数用作去重
    public void backTrack(int[] nums, ArrayList<List<Integer>> resultList, ArrayList<Integer> track, int target,
            int start) {
        // 结束条件
        if (target == 0) {
            resultList.add(new ArrayList<Integer>(track));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            // 如果target<当前数，则跳过
            if (target < nums[i]) {
                continue;
            }
            // 做出选择
            track.add(nums[i]);
            backTrack(nums, resultList, track, target - nums[i], i);
            // 撤销选择
            track.remove(track.size() - 1);
        }
    }
}
