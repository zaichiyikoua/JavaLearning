package codingInterviewByJava;

import java.util.HashMap;

//面试题39：数组中出现次数超过一半的数字
//题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例
//如输入一个长度为9的数组{1, 2, 3, 2, 2, 2, 5, 4, 2}。由于数字2在数组中
//出现了5次，超过数组长度的一半，因此输出2。

public class MoreThanHalfNumber {
    // 最容易想到的思路就是 将数组排序，因为数超过了数组长度的一半，所以一定是该数组的中位数
    // 该思路涉及快排，所以时间复杂度是O(nlogn)

    // 思路 遍历数组，记录数组中的数据和出现的次数，判断是否超过了数组长度的一半
    // 该思路时间复杂度为O(n),我个人更喜欢这种
    // 小优化，更改条件 找出数字出现的次数超过数组长度的 length / n
    public int solution(int[] array, int n) {
        if (array == null || array.length <= 0 || n <= 0) {
            return -1;
        }
        if (array.length == 1) {
            return array[0];
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : array) {
            // 记录数组中的数据,如果没有这个数就加入map
            if (map.containsKey(i)) {
                // 然后判断次数
                if (map.get(i) >= (array.length / n)) {
                    return i;
                }
                // 没有超过,就让它次数加1
                map.put(i, map.get(i) + 1);
            } else {
                // map中没有的话就初始化
                map.put(i, 1);
            }
        }
        return 0;
    }

    // ***********************************************************************
    // 书上推荐的思路
    // 该数字超过数组长度的一半，所以它出现的次数一定是比其他所有数出现的次数的和还要多
    // 那么遍历数组，保存两个值：一个是数组中的数，一个是次数
    // 当遍历到下一个数字的时候，如果下一个数和之前保存的数相同，则次数加1
    // 不同则次数减1 如果次数为0，那么保存下一个数字，把次数重置为1
    // 因为要找的的数字它出现的次数一定是比其他所有数出现的次数的和还要多
    // 所以肯定是最后一次把次数重置为1时对应的数字
    public int solutionTwo(int[] array) {
        if (array == null || array.length <= 0) {
            return -1;
        }
        if (array.length == 1) {
            return array[0];
        }
        // 初始化数字和次数，默认从数组头部开始
        int findnumber = array[0];
        int times = 1;
        // 遍历数组,已经初始化了，所以从1开始
        for (int i = 1; i < array.length; i++) {
            // 为0时，保存下一个数字，重置次数
            if (times == 0) {
                findnumber = array[i];
                times = 1;
            } else if (array[i] == findnumber) {
                times++;
            } else {
                times--;
            }
        }
        // 检查是否大于一半
        if (check(array, findnumber)) {
            findnumber = 0;
        }
        return findnumber;
    }

    // 检查函数
    public boolean check(int[] array, int findnumber) {
        // 标志位
        boolean flag = true;
        // 计数器
        int times = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == findnumber) {
                times++;
            }
        }
        if (times * 2 <= array.length) {
            flag = false;
        }
        return flag;
    }
}
