package leetcode.part6;

import java.util.ArrayList;
import java.util.List;

/*
*	leetCode算法刷题记录   笔记55
*	@author  zaichiyikoua
*	@time  2020年2月16日
*	@title  { 杨辉三角 }
*/

//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
//在杨辉三角中，每个数是它左上方和右上方的数的和。
//示例:
//输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]
public class PascalsTriangle {
    // 杨辉三角可以理解为一个二维数组
    public List<List<Integer>> solution(int numRows) {
        // 初始化二维数组
        ArrayList<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if (numRows <= 0) {
            return triangle;
        }
        // 初始化最顶部的1
        triangle.add(new ArrayList<Integer>());
        triangle.get(0).add(1);
        // 遍历二维数组，从第二层开始，numRows就是层数，这里不要=numRows，否则会多一层
        for (int i = 1; i < numRows; i++) {
            // 具体的一层
            ArrayList<Integer> currentList = new ArrayList<Integer>();
            // 得到上一层的数据，因为本层的数值依赖于上层
            List<Integer> upstairsList = triangle.get(i - 1);
            // 首尾都是1
            currentList.add(1);
            // 注意边界值
            for (int j = 1; j < i; j++) {
                // 首尾中间的数据
                currentList.add(upstairsList.get(j - 1) + upstairsList.get(j));
            }
            // 首尾都是1
            currentList.add(1);
            // 本层初始化结束，放进triangle
            triangle.add(currentList);
        }
        return triangle;
    }
}
