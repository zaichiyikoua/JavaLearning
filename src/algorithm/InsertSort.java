package algorithm;

/*
*	简单插排 java实现
*	插入排序也是一种简单直观的排序
*	思路就是在无序数组中取出一个元素，在已经排好序的数组中找到合适的位置插入
*/

public class InsertSort {
    public void solution(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return;
        }

        int length = arr.length;
        int temp;
        // 指针
        int leftIndex;

        // 这里从1开始 默认第一个元素已经排好序了
        for (int i = 1; i < length; i++) {
            // 用作比较的数据
            temp = arr[i];
            leftIndex = i - 1;

            // 取出下一个元素，在已经排序的元素序列中从后向前扫描；
            while (leftIndex >= 0 && arr[leftIndex] > temp) {
                // 如果该元素（已排序）大于新元素，将该元素移到下一位置
                arr[leftIndex + 1] = arr[leftIndex];
                leftIndex--;
            }

            // 直到找到已排序的元素小于或者等于新元素的位置
            // 将新元素插入
            arr[leftIndex + 1] = temp;
        }
    }
}
