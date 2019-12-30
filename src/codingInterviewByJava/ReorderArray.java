package codingInterviewByJava;

//面试题21：调整数组顺序使奇数位于偶数前面
//题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有
//奇数位于数组的前半部分，所有偶数位于数组的后半部分。

public class ReorderArray<E> {
    // 思路 要使得数组前部分为奇数，后部分为偶数
    // 使用前后指针分别指向首尾，指针靠拢 找到前部分为奇数和后部分为偶数的数 交换位置

    public int[] solution(int[] array) {
        if (array == null || array.length <= 0) {
            System.out.println("空指针");
        }
        // 定义双指针
        int headIndex = 0;
        int tailIndex = array.length - 1;

        while (headIndex < tailIndex) {
            // 奇数不能被2整除 偶数能被2整除
            // 要在前部分找到偶数 在后部分找到奇数

            // 优化 前指针小于后指针
            if (headIndex < tailIndex && array[headIndex] % 2 != 0) {
                // 只要是奇数 就向后移动指针 直到找到偶数
                headIndex++;
            }
            if (headIndex < tailIndex && array[tailIndex] % 2 == 0) {
                tailIndex--;
            }
            // 交换值
            if (headIndex < tailIndex) {
                int temp = array[headIndex];
                array[headIndex] = array[tailIndex];
                array[tailIndex] = temp;
            }
        }
        return array;
    }
}
