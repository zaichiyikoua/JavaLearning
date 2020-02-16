package leetcode.part6;

import java.util.ArrayList;
import java.util.List;

/*
*	leetCode算法刷题记录   笔记56
*	@author  zaichiyikoua
*	@time  2020年2月16日
*	@title  { 杨辉三角ll }
*/

//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k行。
//在杨辉三角中，每个数是它左上方和右上方的数的和。
//示例:
//输入: 3
//输出: [1,3,3,1]
public class PascalsTrianglell {
    // 生成杨辉三角，直接返回当前行即可
    public List<Integer> solution(int rowIndex) {
        // 初始化三角
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        // 最顶部初始化
        triangle.add(new ArrayList<Integer>());
        triangle.get(0).add(1);
        if (rowIndex == 0) {
            return triangle.get(rowIndex);
        }
        // 生成三角，从第二层开始
        for (int i = 1; i <= rowIndex; i++) {
            // 当前层
            ArrayList<Integer> currentList = new ArrayList<Integer>();
            // 上一层数据
            List<Integer> upstairsList = triangle.get(i - 1);
            // 首尾为1
            currentList.add(1);
            for (int j = 1; j < i; j++) {
                currentList.add(upstairsList.get(j - 1) + upstairsList.get(j));
            }
            // 首尾为1
            currentList.add(1);
            // 放进triangle中
            triangle.add(currentList);
        }
        return triangle.get(rowIndex);
    }
}
