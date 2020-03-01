package leetcode.part12;

import java.util.ArrayList;
import java.util.List;

/*
*	leetCode算法刷题记录   笔记112
*	@author  zaichiyikoua
*	@time  2020年3月1日
*	@title  { 组合 }
*/

//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//示例:
//输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
public class Combinations {
    // 类全排列问题 都用回溯法解
    public List<List<Integer>> combine(int n, int k) {
        // 要返回的list
        ArrayList<List<Integer>> resList = new ArrayList<>();
        // 追踪数组
        ArrayList<Integer> track = new ArrayList<>();
        backTrack(n, resList, track, 1, k);
        return resList;
    }

    // 回溯方法
    public void backTrack(int n, ArrayList<List<Integer>> res, ArrayList<Integer> track, int start, int k) {
        // 结束条件
        if (track.size() == k) {
            res.add(new ArrayList<>(track));
            return;
        }
        // 操作 然后 回溯
        for (int i = start; i <= n; i++) {
            track.add(i);
            backTrack(n, res, track, i + 1, k);
            track.remove(track.size() - 1);
        }
    }
}
