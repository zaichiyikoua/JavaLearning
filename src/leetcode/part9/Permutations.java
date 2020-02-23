package leetcode.part9;

import java.util.ArrayList;
import java.util.List;

/*
*	leetCode算法刷题记录   笔记85
*	@author  zaichiyikoua
*	@time  2020年2月23日
*	@title  { 全排列 }
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
public class Permutations {
    // 超经典回溯法题目
    public List<List<Integer>> solution(int[] nums) {
        // 返回的数组
        ArrayList<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if (nums == null || nums.length <= 0) {
            return resultList;
        }
        // 记录路径
        ArrayList<Integer> trackList = new ArrayList<Integer>();
        detail(nums, resultList, trackList);
        return resultList;
    }

    public void detail(int[] nums, ArrayList<List<Integer>> resultList, ArrayList<Integer> track) {
        // 结束条件，已经将数组中全部的元素排列完成,添加进最后返回的数组
        if (track.size() == nums.length) {
            resultList.add(new ArrayList<Integer>(track));
            return;
        }
        // 遍历数组，进行选择
        for (int i = 0; i < nums.length; i++) {
            // 排除已有的排列
            if (track.contains(nums[i])) {
                continue;
            }
            // 选择
            track.add(nums[i]);
            // 进入下一层决策树
            detail(nums, resultList, track);
            // 删除加入的元素，进行回溯，恢复状态
            track.remove(track.size() - 1);
        }
    }
}
