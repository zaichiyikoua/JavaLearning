package leetcode.part9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/*
*	leetCode算法刷题记录   笔记88
*	@author  zaichiyikoua
*	@time  2020年2月24日
*	@title  { 前k个高频元素 }
*/

//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
//示例 1:
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
//示例 2:
//输入: nums = [1], k = 1
//输出: [1]
public class TopKFrequentElements {
    // 使用map记录元素和出现的次数，关键是记录之后怎样得到前k个数字
    public List<Integer> solution(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 记录频率
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        // 使用优先队列，默认为最小堆，堆里存的是数字，但是按照频率比较，所以要自定义比较器
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparing(map::get));
        for (Integer number : map.keySet()) {
            if (queue.isEmpty() || queue.size() < k) {
                queue.add(number);
            } else {
                // 比较当前数字的频率和堆头数字的频率
                if (map.get(queue.peek()) < map.get(number)) {
                    queue.poll();
                    queue.add(number);
                }
            }
        }
        // 堆转换为集合后，需要逆序输出，因为堆头是最小的
        List<Integer> result = new ArrayList<>(queue);
        Collections.reverse(result);
        return result;
    }
}
