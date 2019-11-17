package codingInterviewByJava;

import java.util.ArrayList;

//面试题3
//找出数组中重复的数字
//题目：在一个长度为n的数组里的所有数字都在0到n-1的范围内。
//数组中某些数字是重复的，但不知道有几个数字重复了，
//也不知道每个数字重复了几次。
//请找出数组中任意一个重复的数字。
//例如输出长度为7的数组{2, 3, 1, 0, 2, 5, 3}
//那么对应的输出是重复的数字2或者3

public class FindDuplication {
	// 思路 因为是0-N-1的数组，所以如果没有重复项的话
	// 数组值和下标应该是一致的 先比较i下标的值是否为i，是则比较下一个
	// 如果不是，找到值对应的下标，再次比较是否相等 相等则为重复值
	// 不等，交换位置，把值放到对应下标的位置
	public ArrayList<Integer> solution(int[] arr) {
		// 空指针
		if (arr.length == 0 || arr == null) {
			System.out.println("不能为空数组");
		}
		ArrayList<Integer> duplication = new ArrayList<Integer>();
		if (arr.length > 1) {
			for (int i : arr) {
				while (arr[i] != i) {// 下标和值不等
					if (arr[i] == arr[arr[i]]) {
						duplication.add(i);
					}

					int temp = arr[i];
					arr[temp] = arr[i];
					arr[i] = temp;
				}
			}
		}

		return duplication;
	}
}
