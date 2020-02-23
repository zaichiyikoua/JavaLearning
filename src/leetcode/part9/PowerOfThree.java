package leetcode.part9;

/*
*	leetCode算法刷题记录   笔记83
*	@author  zaichiyikoua
*	@time  2020年2月23日
*	@title  { 3的幂 }
*/

//给定一个整数，写一个函数来判断它是否是 3 的幂次方。
//示例 1:
//输入: 27
//输出: true
//示例 2:
//输入: 0
//输出: false
//示例 3:
//输入: 9
//输出: true
//示例 4:
//输入: 45
//输出: false
public class PowerOfThree {
    // 典型的数学方式解决
    // n的幂都是这样解决的，见过一次以后都应该知道怎么做了
    public boolean solution(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
