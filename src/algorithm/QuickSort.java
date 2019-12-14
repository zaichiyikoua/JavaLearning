package algorithm;

/*
*	快排 java实现
*	核心思路就是找数组的基准值 根据基准值排序 建议找数组尾的值 默认基准值左边的比基准值小
*	然后根据基准值分成两个区间数组 然后在区间数组中继续找基准值重复以上操作 直到排序完成
*
*/
public class QuickSort {

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
		// 返回坐标
		return start;
	}
}
