package leetcode.part3;

/*
*	leetCode算法刷题记录   笔记27
*	@author  zaichiyikoua
*	@time  2020年2月9日
*	@title  {}
*/

//反转一个单链表。
//示例:
//输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
public class ReverseLinkedList {
    // 超经典面试题
    // 为了防止断链，要记录当前节点和它的前一个节点和后一个节点
    public ListNode solution(ListNode head) {
        if (head == null) {
            return null;
        }
        // 初始化要返回的链表的头节点
        ListNode reversedHeadNode = null;
        // 两个指针
        ListNode currentNode = head;
        ListNode preNode = null;

        while (currentNode != null) {
            // 得到当前节点的下一个节点，用作记录，不然反转之后就没有了
            ListNode next = currentNode.next;
            // 判断是不是尾节点
            if (next == null) {
                // 没有下一个节点了，那么当前节点就是返回链表的头节点
                reversedHeadNode = currentNode;
            }
            // 反转
            currentNode.next = preNode;
            // 移动节点
            preNode = currentNode;
            currentNode = next;
        }

        return reversedHeadNode;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
