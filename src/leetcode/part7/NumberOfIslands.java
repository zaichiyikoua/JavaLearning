package leetcode.part7;

import java.util.LinkedList;

/*
*	leetCode算法刷题记录   笔记61
*	@author  zaichiyikoua
*	@time  2020年2月17日
*	@title  { 岛屿数量 }
*/

//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
//示例 1:
//输入:
//11110
//11010
//11000
//00000
//输出: 1
//示例 2:
//输入:
//11000
//11000
//00100
//00011
//输出: 3
public class NumberOfIslands {
    // 遍历整个二维数组，去找1，以1为根广度搜索
    // 方向
    private static final int[][] DIRECTION = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public int solution(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        // 行
        int rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        // 列
        int cols = grid[0].length;
        // 岛的个数，计数器
        int countIsland = 0;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 遍历二维数组，找1
                // 满足条件，值为1，且没有遍历过
                if (grid[i][j] == '1' && !visited[i][j]) {
                    // 计数
                    countIsland++;
                    // BFS必需的队列
                    LinkedList<Integer> queue = new LinkedList<Integer>();
                    // 将当前的坐标进行转换，然后入队
                    queue.offer(i * cols + j);
                    // 标记当前坐标
                    visited[i][j] = true;
                    // 遍历队列
                    while (!queue.isEmpty()) {
                        Integer poll = queue.poll();
                        // 转回来，得到坐标
                        int curX = poll / cols;
                        int curY = poll % cols;
                        // 向四个方向搜索
                        for (int k = 0; k < 4; k++) {
                            // 搜索的坐标
                            int newX = curX + DIRECTION[k][0];
                            int newY = curY + DIRECTION[k][1];
                            // 如果未被访问，并且是陆地，没有越界，那就继续放入队列
                            if (!visited[newX][newY] && grid[newX][newY] == '1' && newX >= 0 && newX < rows && newY >= 0
                                    && newY < cols) {
                                // 进行转换
                                queue.offer(newX * cols + newY);
                                // 标记访问
                                visited[newX][newY] = true;
                            }
                        }
                    }
                }
            }
        }
        return countIsland;
    }
}
