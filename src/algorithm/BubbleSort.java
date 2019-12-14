package algorithm;

/*
*	冒泡排序 java实现
*	冒泡是最简单的交换排序了 实现也比较简单
*	思路就是相邻元素两两对比 然后交换元素
*/

public class BubbleSort {
	public void solution(int[] arr) {
		if (arr == null || arr.length <= 0) {
			return;		
		}
		int length = arr.length;
		// 默认升序
		for (int i = 0; i < length - 1; i++) {
			for (int j = 0; j < length - 1; j++) {
				// 相邻元素两两对比 然后交换元素
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}
