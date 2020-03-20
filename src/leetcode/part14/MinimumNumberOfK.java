package leetcode.part14;

import java.util.Arrays;

/*
*	leetCode算法刷题记录   笔记133
*	@author  zaichiyikoua
*	@time  2020年3月20日
*	@title  { 最小的K个数 }
*/

//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
//示例 1：
//输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
//示例 2：
//输入：arr = [0,1,2,1], k = 1
//输出：[0]
//限制：
//0 <= k <= arr.length <= 10000
//0 <= arr[i] <= 10000
public class MinimumNumberOfK {
    // 最简单直接的方法 数组排序之后输出前K个数即可
    @SuppressWarnings("null")
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];
        if (arr == null && (arr.length <= 0)) {
            return result;
        }
        // 无脑sort
        Arrays.sort(arr);
        // 输出前k个数
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }
}
