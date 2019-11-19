package codingInterviewByJava;

import java.util.LinkedList;

//面试题30：包含min函数的栈
//题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min
//函数。在该栈中，调用min、push及pop的时间复杂度都是O(1)。

public class StackWithMin {
	// 思路 使用辅助栈来保存数据栈中的最小值
	// 让辅助栈栈顶一直保存最小值，调用min（）方法时，将栈顶弹出
	// 每次数据栈压入时，跟辅助栈栈顶最小值比较 数据栈弹出时，辅助栈同时弹出，更新栈顶

	// 数据栈和辅助栈
	private LinkedList<Integer> dataList = new LinkedList<Integer>();
	private LinkedList<Integer> ancillaryList = new LinkedList<Integer>();

	public StackWithMin() {
		super();
	}

	public void push(Integer data) {
		// 数据栈压入数据
		dataList.push(data);
		// 辅助栈压入
		if (data > ancillaryList.peek()) {
			ancillaryList.push(ancillaryList.getLast());
		}
		if (data < ancillaryList.peek()) {
			ancillaryList.push(data);
		}

	}

	public void pop() {
		if (dataList != null && dataList.size() != 0) {
			dataList.pop();
		}

		if (ancillaryList != null && ancillaryList.size() != 0) {
			ancillaryList.pop();
		}
	}

	public Integer min() {
		Integer min = null;

		if (ancillaryList.size() != 0) {
			min = ancillaryList.peek();
		}

		return min;
	}
}
