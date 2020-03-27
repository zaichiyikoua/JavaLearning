package leetcode.part15;

/*
*	leetCode算法刷题记录   笔记142
*	@author  zaichiyikoua
*	@time  2020年3月27日
*	@title  { 旋转数组lcci }
*/

//给定一幅由N × N矩阵表示的图像，其中每个像素的大小为4字节，编写一种方法，将图像旋转90度。
//不占用额外内存空间能否做到？
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
public class RotateMatrixlcci {
    // 之前好像做过该题..
    // 还是先将数组的[i][j] 变成[j][i] 然后再反转每一行的值
    public void rotate(int[][] matrix) {
        // n × n
        // 行列
        int row = matrix.length;
        int col = matrix.length;
        // 先将整个数组倒置
        int temp;
        for (int i = 0; i < row; i++) {
            for (int j = i; j < col; j++) {
                temp = matrix[i][j];
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
                // 注意脚标越界
                matrix[i][j] = matrix[i][col - j - 1];
                matrix[i][col - j - 1] = tmp;
            }
        }
    }
}
