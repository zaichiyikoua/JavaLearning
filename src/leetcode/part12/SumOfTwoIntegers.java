package leetcode.part12;

/*
*	leetCode算法刷题记录   笔记116
*	@author  zaichiyikoua
*	@time  2020年3月2日
*	@title  { 两整数之和 }
*/

//不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
//示例 1:
//输入: a = 1, b = 2
//输出: 3
//示例 2:
//输入: a = -2, b = 3
//输出: 1
public class SumOfTwoIntegers {
    // 直接调库函数解决 hhh
    public int solution(int a, int b) {
        return Math.addExact(a, b);
    }
}
