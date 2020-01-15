package codingInterviewByJava.chapter1;

/*
*	剑指offer面试题复习  笔记6
*	@author  zaichiyikoua
*	@time  2020年1月15日
*	@title  { 二维数组中的查找 }
*/

//题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按
//照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个
//整数，判断数组中是否含有该整数。
public class Offer6 {
    // 思路，首先选取数组的右上角的数字。
    // 如果该数字大于要查找的数字，那么删除这个数字的列
    // 如果小于要查找的数字，那么删除这个数字的行
    // 然后重复，一步一步减少搜索的范围
    public boolean solution(int[] arr, int rows, int columns, int keyValue) {
        // 标志位
        boolean flag = false;
        // 只有满足这样的条件才执行程序
        if (arr != null && rows > 0 && columns > 0) {
            int row = 0;
            int column = columns - 1;
            while (row < rows && column >= 0) {
                // 判断右上角的值和要查找的值的关系
                if (arr[row * columns + column] == keyValue) {
                    flag = true;
                    break;
                } else if (arr[row * columns + column] < keyValue) {
                    --column;
                } else {
                    ++row;
                }
            }
        }
        return flag;
    }
}
