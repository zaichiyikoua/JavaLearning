package leetcode.part6;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
*	leetCode算法刷题记录   笔记60
*	@author  zaichiyikoua
*	@time  2020年2月16日
*	@title  { 墙与门 }
*/

//你被给定一个 m × n 的二维网格，网格中有以下三种可能的初始化值：
//-1 表示墙或是障碍物
//0 表示一扇门
//INF 无限表示一个空的房间。然后，我们用 231 - 1 = 2147483647 代表 INF。你可以认为通往门的距离总是小于 2147483647 的。
//你要给每个空房间位上填上该房间到 最近 门的距离，如果无法到达门，则填 INF 即可。
//示例：
//给定二维网格：
//INF  -1  0  INF
//INF INF INF  -1
//INF  -1 INF  -1
//  0  -1 INF INF
//运行完你的函数后，该网格应该变成：
//  3  -1   0   1
//  2   2   1  -1
//  1  -1   2  -1
//  0  -1   3   4
public class WallsAndGates {
    private static final int GATE = 0;
    private static final int EMPTY = Integer.MAX_VALUE;
    // 上下左右四个方向
    private static final List<int[]> DIRECTIONS = Arrays.asList(new int[] { 1, 0 }, new int[] { -1, 0 },
            new int[] { 0, 1 }, new int[] { 0, -1 });

    // BFS方法来完成，找到每一个门，去广度优先搜索找空的房间
    public void solution(int[][] rooms) {
        if (rooms == null) {
            return;
        }
        // 因为是m*n的矩阵
        int m = rooms.length;
        if (m == 0) {
            return;
        }
        int n = rooms[0].length;
        // 广度优先必须的队列，保存的是在矩阵中的坐标
        LinkedList<int[]> queue = new LinkedList<int[]>();
        // 遍历矩阵，找到门，入队
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == GATE) {
                    queue.offer(new int[] { i, j });
                }
            }
        }
        // 遍历队列
        while (!queue.isEmpty()) {
            // 出队得到当前元素
            int[] poll = queue.poll();
            // 得到坐标值
            int row = poll[0];// 行
            int col = poll[1];// 列
            // 向上下左右四个方向遍历
            for (int[] direction : DIRECTIONS) {
                // 得到移动之后的坐标
                int rowDirection = row + direction[0];
                int colDirection = col + direction[1];
                // 筛选
                if (rowDirection < 0 || colDirection < 0 || rowDirection >= m || colDirection >= n
                        || rooms[rowDirection][colDirection] != EMPTY) {
                    continue;
                }
                //
                rooms[rowDirection][colDirection] = rooms[row][col] + 1;
                // 将移动后的坐标保留入队，继续迭代继续找
                queue.add(new int[] { rowDirection, colDirection });
            }
        }
    }
}
