package codingInterviewByJava.chapter1;

/*
*	剑指offer面试题复习  笔记13
*	@author  zaichiyikoua
*	@time  2020年1月28日
*	@title  { 剪绳子 }
*/

//题目：给你一根长度为n绳子，请把绳子剪成m段（m、n都是整数，n>1并且m≥1）。
//每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]*k[1]*…*k[m]
//可能的最大乘积是多少？例如当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到最大的乘积18。
public class Offer13 {
    // 题目中出现的最大长度是3，那么每剪一次就尽可能的剪去3，不要去剪1
    // 如果出现了1，就从已经切好长度为 3 的绳子中拿出一段与长度为 1的绳子重新组合，把它们切成两段长度为 2的绳子。
    // 因为3x1 < 2x2
    public int solution(int value) {
        // 特殊值和输入值处理
        if (value < 2) {
            return 0;
        }
        if (value == 2) {
            return 1;
        }
        if (value == 3) {
            return 2;
        }
        // 每次都去剪去最大的长度3
        int timesOf3 = value / 3;
        if (value - timesOf3 * 3 == 1) {
            timesOf3--;
        }
        int timeOf2 = (value - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timeOf2));
    }
}
