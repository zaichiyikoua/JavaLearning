package leetcode.part8;

import java.util.ArrayList;
import java.util.HashMap;

/*
*	leetCode算法刷题记录   笔记72
*	@author  zaichiyikoua
*	@time  2020年2月19日
*	@title  { 两个数组的交集ll }
*/

//给定两个数组，编写一个函数来计算它们的交集。
//示例 1:
//输入: nums1 = [1,2,2,1], nums2 = [2,2]
//输出: [2,2]
//示例 2:
//输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出: [4,9]
//说明：
//输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
//我们可以不考虑输出结果的顺序。
public class IntersectionOfTwoArraysll {
    // hashmap
    public int[] solution(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1 == null) {
            return null;
        }
        // map
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 遍历数组1，记录值和次数
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        // 这个list用来保存两个数组之间的公共元素
        ArrayList<Integer> list = new ArrayList<Integer>();
        // 遍历数组2
        for (int i : nums2) {
            Integer count = map.get(i);
            if (count != null && count != 0) {
                list.add(i);
                // 更新map
                map.put(i, --count);
            }
        }
        // 此时list中已经有了两个数组的交集
        // 现在生成返回数组
        int[] result = new int[list.size()];
        // 指针
        int index = 0;
        for (Integer integer : list) {
            result[index++] = integer;
        }
        return result;
    }
}
