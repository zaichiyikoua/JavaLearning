package leetcode.part5;

import java.util.ArrayList;
import java.util.List;

/*
*	leetCode算法刷题记录   笔记44
*	@author  zaichiyikoua
*	@time  2020年2月13日
*	@title  { 螺旋矩阵 }
*/

//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
//示例 1:
//输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
//示例 2:
//输入:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//输出: [1,2,3,4,8,12,11,10,9,5,6,7]
public class SpiralMatrix {
    // 我们定义矩阵的第 k 层是到最近边界距离为 k 的所有顶点。
    // 例如，矩阵最外层元素都是第 1 层，次外层元素都是第 2 层，然后是第 3 层的
    // 对于每层，我们从左上方开始以顺时针的顺序遍历所有元素
    public List<Integer> solution(int[][] matrix) {
        // 要返回的数组
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        // 入值检测
        if (matrix == null || matrix.length == 0) {
            return resultList;
        }
        // 假设当前层左上角坐标是(r1, c1)，右下角坐标是(r2, c2)。
        int r1 = 0;
        int c1 = 0;
        int r2 = matrix.length - 1;
        int c2 = matrix[0].length - 1;
        // 循环条件
        while (r1 <= r2 && c1 <= c2) {
            // 首先打印顶部
            for (int i = c1; i <= c2; i++) {
                resultList.add(matrix[c1][i]);
            }
            // 打印右边，注意边界条件
            for (int j = r1 + 1; j <= r2; j++) {
                resultList.add(matrix[j][r2]);
            }
            if (r1 < r2 && c1 < c2) {
                // 打印底部
                for (int k = c2 - 1; k > c1; k--) {
                    resultList.add(matrix[r2][k]);
                }
                // 打印左边
                for (int l = r2; l > r1; l--) {
                    resultList.add(matrix[l][c1]);
                }
            }
            // 缩圈
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return resultList;
    }
}
