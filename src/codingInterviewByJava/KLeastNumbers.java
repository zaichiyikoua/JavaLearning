package codingInterviewByJava;

//面试题40：最小的k个数
//题目：输入n个整数，找出其中最小的k个数。例如输入4、5、1、6、2、7、3、8
//这8个数字，则最小的4个数字是1、2、3、4。

public class KLeastNumbers {
    // 思路，排序 排序完成之后 最小的k位数就是前k位
    public void solution(int[] array, int k) {
        if (array == null || array.length <= 0) {
            return;
        }
        // 边界值
        if (k <= 1 || k > array.length) {
            return;
        }
        quickSort(array, 0, array.length - 1);
        for (int i = 0; i < k - 1; i++) {
            System.out.println(array[i]);
        }
    }

    public void quickSort(int[] array, int start, int end) {
        if (array.length <= 0 || array == null || start < 0 || end < 0) {
            return;
        }
        if (start < end) {
            int index = getIndex(array, start, end);
            quickSort(array, start, index - 1);
            quickSort(array, index + 1, end);
        }
    }

    public int getIndex(int[] array, int start, int end) {
        // 设定基准值，一般不建议设置头，建议设置尾
        int index = array[end];
        while (start < end) {
            // 左边比index小 右边比index大
            // 指针移动
            while (start < end && array[start] < index) {
                start++;
            }
            while (start < end && array[end] > index) {
                end--;
            }
            // 此时找到左边比index大 右边比index小的两个值
            // 交换位置
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }
        // 此时start == end
        // 交换array[start]和index的值
        int temp = array[start];
        array[start] = index;
        index = temp;
        return start;
    }
}
