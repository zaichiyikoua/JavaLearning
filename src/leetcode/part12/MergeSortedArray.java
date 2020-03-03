package leetcode.part12;

import java.util.Arrays;

/*
*	leetCode算法刷题记录   笔记117
*	@author  zaichiyikoua
*	@time  2020年3月3日
*	@title  { 合并排序的数组(暴力法) }
*/

//给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
//初始化 A 和 B 的元素数量分别为 m 和 n。
//示例:
//输入:
//A = [1,2,3,0,0,0], m = 3
//B = [2,5,6],       n = 3
//输出: [1,2,2,3,5,6]
public class MergeSortedArray {
    public void solution(int[] A, int m, int[] B, int n) {
        int length = A.length - 1;
        // 将两个数组合并，然后排序
        for (int i = 0; i < n; i++) {
            A[length--] = B[i];
        }
        Arrays.sort(A);
    }
}
