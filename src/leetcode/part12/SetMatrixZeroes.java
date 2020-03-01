package leetcode.part12;

import java.util.HashSet;

/*
*   leetCode算法刷题记录   笔记113
*   @author  zaichiyikoua
*   @time  2020年3月1日
*   @title  { 矩阵置零 }
*/

//给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
//示例 1:
//输入: 
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出: 
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
//示例 2:
//
//输入: 
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出: 
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
public class SetMatrixZeroes {
    // 用额外的空间记录为零的数的坐标，然后遍历的时候置零
    public void solution(int[][] matrix) {
        // 数组的行列
        int row = matrix.length;
        int col = matrix[0].length;
        // 为了不重复 使用set
        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> colSet = new HashSet<>();
        // 记录0的坐标
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    // 记录
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        // 遍历数组，置零
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 只要是已经记录的行或者列，都置零
                if (rowSet.contains(i) || colSet.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
