package codingInterviewByJava;

//面试题18（一）：在O(1)时间删除链表结点
//题目：给定单向链表的头指针和一个结点指针
//定义一个函数在O(1)时间删除该节点

public class DeleteNodeInList {
	// 思路
	// 最常规的做法 遍历链表 找到要删除节点的前一个结点 删除该节点
	// 但是这样的作法时间复杂度是O(n)
	// 于是换一种想法 将要删除节点的下一节点的值赋给要删除节点
	// 这样要删除节点和下一节点是相同值，然后删除下一节点，这样时间复杂度是O(1)
	public Boolean solution(ListNode header, ListNode toBeDeletedNode) {
		if (header == null || toBeDeletedNode == null) {
			System.out.println("空指针");
			return false;
		}
		boolean flag;
		// 如果只有一个节点，也就是头节点，同时也是尾节点,只能删除它
		if (header == toBeDeletedNode) {
			header = null;
			toBeDeletedNode = null;
			flag = true;
		} else if (!(toBeDeletedNode.nextNode == null)) {
			// 大多数情况下
			// 该思路中，要删除节点不能是尾节点，也就是要删除节点必须要有后继节点
			toBeDeletedNode.value = toBeDeletedNode.nextNode.value;
			toBeDeletedNode.nextNode = toBeDeletedNode.nextNode.nextNode;

			toBeDeletedNode.nextNode = null;
			flag = true;
		} else {
			// 这里的时间复杂度还是O(n)
			// 对于尾节点来说 还是要遍历链表
			while (!(toBeDeletedNode == header)) {
				header = header.nextNode;
			}
			header.nextNode = null;
			toBeDeletedNode = null;
			flag = true;
		}

		return flag;
	}
}
