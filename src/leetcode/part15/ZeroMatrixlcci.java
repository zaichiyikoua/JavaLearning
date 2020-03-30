package leetcode.part15;

import java.util.HashSet;

/*
*	leetCode算法刷题记录   笔记144
*	@author  zaichiyikoua
*	@time  2020年3月30日
*	@title  { 零矩阵 }
*/

//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
//示例 1：
//输入：
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出：
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
//示例 2：
//
//输入：
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出：
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
public class ZeroMatrixlcci {
    // 记录为0的坐标，然后赋值
    public void setZeroes(int[][] matrix) {
        // M x N矩阵
        int m = matrix.length;
        int n = matrix[0].length;
        // 记录0的坐标
        // 为了不重复 使用set
        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> colSet = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    // 记录
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        // 置零
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rowSet.contains(i) || colSet.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
