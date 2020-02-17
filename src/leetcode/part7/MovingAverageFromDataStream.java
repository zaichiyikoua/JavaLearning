package leetcode.part7;

import java.util.LinkedList;

/*
*	leetCode算法刷题记录   笔记62
*	@author  zaichiyikoua
*	@time  2020年2月17日
*	@title  { 数据流中的移动平均值 }
*/

//给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算其所有整数的移动平均值。
//示例:
//MovingAverage m = new MovingAverage(3);
//m.next(1) = 1
//m.next(10) = (1 + 10) / 2
//m.next(3) = (1 + 10 + 3) / 3
//m.next(5) = (10 + 3 + 5) / 3
public class MovingAverageFromDataStream {
    private int size;
    // 注意，这里不能为int
//    private int sum;
    private double sum;
    private LinkedList<Integer> queue = new LinkedList<Integer>();

    public MovingAverageFromDataStream(int size) {
        super();
        this.size = size;
    }

    public double next(int val) {
        sum += val;
        queue.offer(val);
        // 队列的长度比size大，就去掉队列首
        if (queue.size() > size) {
            sum -= queue.poll();
        }
        return sum / queue.size();
    }
}
