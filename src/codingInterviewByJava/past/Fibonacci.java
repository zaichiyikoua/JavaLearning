package codingInterviewByJava.past;

//面试题10：斐波那契数列
//题目：写一个函数，输入n，求斐波那契数列的第n项。
//f(n) = f(n-1) + f(n-2)

public class Fibonacci {
    // 思路 可以用递归和循环 都可以
    // 但是递归效率有问题 更推荐使用循环

    public int solution(int number) {
        // 使用递归实现
        if (number <= 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }

        int result = 0;
        result = solution(number - 1) + solution(number - 2);

        return result;
    }

    public int solutionByCycle(int number) {
        // 循环实现
        int[] result = { 0, 1 };
        if (number < 2) {
            return result[number];
        }
        // 定义三个值实现循环
        int fnone = 1;
        int fntwo = 0;
        // 这里默认为0，fn要计算得出
        int fn = 0;
        for (int i = 2; i < number; i++) {
            fn = fnone + fntwo;
            // 向后推进
            fntwo = fnone;
            fnone = fn;
        }
        return fn;
    }

}
