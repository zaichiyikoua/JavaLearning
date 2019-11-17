package codingInterviewByJava;

//面试题18（二）：删除链表中重复的结点
//单链表去重
//题目：在一个排序的链表中，如何删除重复的结点？例如，在图3.4（a）中重复
//结点被删除之后，链表如图3.4（b）所示。

public class DeleteDuplicatedNode {
	// 思路 既然已经排好序了 那么就可以比较当前和下一节点是否相同，相同则是重复节点
	// 但是，这里必须要注意
	// 删除之后的链表要完整，不断链
	// 要把要删除节点的前一个节点和后一个节点进行连接
	public boolean solution(ListNode header) {
		if (header == null) {
			return false;
		}

		// 默认头节点是没有前一个节点的
		ListNode preNode = null;
		ListNode nextNode = header.nextNode;

		boolean success = false;

		while (header != null) {
			boolean flag = false;
			// 判断是否重复
			if (header == header.nextNode && (header.nextNode != null)) {
				flag = true;
			}
			if (!flag) {// 如果不重复,向后推进
				preNode = header;
				header = header.nextNode;
			} else {
				// 这里如果有两个相同的值，则删除前一个值
				// 这里存在可能： 有多个连续的重复值
				int value = header.value;
				ListNode toBeDelNode = header;
				while (toBeDelNode != null && toBeDelNode.value == value) {
					nextNode = toBeDelNode.nextNode;
					toBeDelNode = null;
					// 如果有多个
					toBeDelNode = nextNode;
				}
				// 处理连续重复值
				if (preNode == null) {
					header = nextNode;
				} else {
					preNode.nextNode = nextNode;
				}
				header = nextNode;
				success = true;
			}
		}

		return success;
	}
}
