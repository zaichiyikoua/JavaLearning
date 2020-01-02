package algorithm;

/*
*	简单选择排序 java实现
*	这种排序也是比较简单的排序
*	核心思路就是找最小值  在未排序的数组中找到最小值 放进排序数组的尾部 然后重复操作
*	默认要排序的数组是无序 有序数组为空
*/

public class SelectionSort {
    public void solution(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return;
        }
        int length = arr.length;
        // 小优化
        int temp;
        int minIndex;
        for (int i = 0; i < length; i++) {
            // 默认数组第一个为最小值
            minIndex = i;
            // 从剩下的未排序数组中找到最小值
            for (int j = i + 1; j < length - 1; j++) {
                if (arr[j] < arr[minIndex]) {
                    // 保留最小值索引
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
