package leetcode.part12;

/*
*	leetCode算法刷题记录   笔记111
*	@author  zaichiyikoua
*	@time  2020年3月1日
*	@title  { 旋转图像 }
*/

//给定一个 n × n 的二维矩阵表示一个图像。
//将图像顺时针旋转 90 度。
//说明：
//你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
//示例 1:
//给定 matrix = 
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
//示例 2:
//给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//], 
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
public class RotateImage {
    // 因为要求了不能使用辅助数组，必须要在本数组上进行变换
    // 所以先将数组进行倒置，然后再每行进行倒置
    public void solution(int[][] matrix) {
        // n × n
        // 行列
        int row = matrix.length;
        int col = matrix.length;
        // 先将整个数组倒置
        for (int i = 0; i < row; i++) {
            for (int j = i; j < col; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 然后倒置每一行的元素
        for (int i = 0; i < row; i++) {
            // 这里要注意 就说怎么没有翻转
            // 这里只能是一半 如果过了一半的话会再次翻转回来 等同于没有翻转
            for (int j = 0; j < col / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][col - j - 1];
                matrix[i][col - j - 1] = tmp;
            }
        }
    }
}
