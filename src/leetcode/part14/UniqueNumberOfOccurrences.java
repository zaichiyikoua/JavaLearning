package leetcode.part14;

import java.util.HashMap;
import java.util.HashSet;

/*
*	leetCode算法刷题记录   笔记137
*	@author  zaichiyikoua
*	@time  2020年3月25日
*	@title  { 独一无二的出现次数 }
*/

//给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
//如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
//示例 1：
//输入：arr = [1,2,2,1,1,3]
//输出：true
//解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
//示例 2：
//输入：arr = [1,2]
//输出：false
//示例 3：
//输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
//输出：true
//提示：
//1 <= arr.length <= 1000
//-1000 <= arr[i] <= 1000
public class UniqueNumberOfOccurrences {
    // 简答的hashmap解决
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        // 记录次数
        for (int i = 0; i < arr.length; i++) {
//            if (!map.containsKey(arr[i])) {
//                map.getOrDefault(arr[i], 0);
//            } else {
//                map.put(arr[i], map.get(arr[i]) + 1);
//            }
            // 优化代码
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        // 判断是否重复
        for (Integer integer : map.values()) {
//            if (set.contains(integer)) {
//                return false;
//            }
//            set.add(integer);
            // 优化代码 利用set的特性，不用再判断了
            if (!set.add(integer)) {
                return false;
            }
        }
        return true;
    }
}
