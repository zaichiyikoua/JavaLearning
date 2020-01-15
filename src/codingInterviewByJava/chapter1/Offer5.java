package codingInterviewByJava.chapter1;

import java.util.ArrayList;
import java.util.HashSet;

/*
*	剑指offer面试题复习  笔记5
*	@author  zaichiyikoua
*	@time  2020年1月15日
*	@title  { 数组中重复的数字 }
*/

//题目：在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
//也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}，
//那么对应的输出是重复的数字2或者3。
public class Offer5 {

    // 思路1 像这种找重复项的，第一时间想到的是用hashSet或者hashMap来进行记录
    // 因为此题现在不需要计算重复出现的次数，只需要找出任意重复的数字，所以set会比较好
    // 遍历原数组，放进set中，判断有没有重复项，有就放进放回数组输出即可
    public ArrayList<Integer> solution(int[] arr) {
        if (arr == null || arr.length <= 0) {
            System.out.println("请输入有效数组");
            return null;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        // 遍历原数组
        for (int i : arr) {
            if (!set.contains(i)) {
                set.add(i);
            } else {
                // set中存在说明重复了，放进list
                list.add(i);
            }
        }
        return list;
    }

    // 思路2，也是书上的思路 因为是0-N-1的数组，所以如果没有重复项的话
    // 数组值和下标应该是一致的 先比较i下标的值是否为i，是则比较下一个
    // 如果不是，找到值对应的下标，再次比较是否相等 相等则为重复值
    // 不等，交换位置，把值放到对应下标的位置
    public ArrayList<Integer> solution2(int[] arr) {
        // 空指针
        if (arr.length == 0 || arr == null) {
            System.out.println("不能为空数组");
        }
        ArrayList<Integer> duplication = new ArrayList<Integer>();
        if (arr.length > 1) {
            for (int i : arr) {
                while (arr[i] != i) {// 下标和值不等
                    if (arr[i] == arr[arr[i]]) {
                        duplication.add(i);
                    }

                    int temp = arr[i];
                    arr[temp] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        return duplication;
    }
}
