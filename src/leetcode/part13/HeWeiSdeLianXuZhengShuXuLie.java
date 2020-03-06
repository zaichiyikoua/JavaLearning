package leetcode.part13;

import java.util.ArrayList;

/*
*	leetCode算法刷题记录   笔记128
*	@author  zaichiyikoua
*	@time  2020年3月6日
*	@title  { 和为S的连续正数序列 }
*/

//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
//序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
//示例 1：
//输入：target = 9
//输出：[[2,3,4],[4,5]]
//示例 2：
//输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
public class HeWeiSdeLianXuZhengShuXuLie {
    // 滑动窗口，和就是窗口内元素的和 然后移动滑动窗口 进行判断即可
    public int[][] solution(int target) {
        // 滑动窗口初始化
        int left = 1;
        int right = 1;
        int sum = 0;
        // 返回数组
        ArrayList<int[]> resList = new ArrayList<>();
        // 因为序列是连续的 当left = target/2时下一个比left大1，加起来就超过target了
        // 题目要求最少两个整数
        while (left <= target / 2) {
            if (sum < target) {
                // 右边界向右移动
                sum += right;
                right++;
            } else if (sum > target) {
                // 左边界向左移动
                sum -= left;
                left++;
            } else {
                // 相等时，返回序列
                int[] temp = new int[right - left];
                // 左闭右开的区间
                for (int k = left; k < right; k++) {
                    temp[k - left] = k;
                }
                // 加入res
                resList.add(temp);
                // 左边界向右移动
                sum -= left;
                left++;
            }
        }
        return resList.toArray(new int[resList.size()][]);
    }
}
