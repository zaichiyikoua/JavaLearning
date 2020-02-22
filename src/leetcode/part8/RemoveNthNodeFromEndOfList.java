package leetcode.part8;

/*
*	leetCode算法刷题记录   笔记76
*	@author  zaichiyikoua
*	@time  2020年2月22日
*	@title  { 删除链表的倒数第N个节点 }
*/

//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//示例：
//给定一个链表: 1->2->3->4->5, 和 n = 2.
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
//说明：
//给定的 n 保证是有效的。
public class RemoveNthNodeFromEndOfList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 利用滑动窗口，让快指针先走n-1步，然后保持这个距离，当快指针到链表的尾节点的时候
    // 此时，慢指针指向的就是要删除的节点，然后将节点删除即可
    public ListNode solution(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        // 滑动窗口，初始化都指向头节点
        ListNode slowIndeListNode = head;
        ListNode quickIndexListNode = head;
        // 慢指针的前节点
        ListNode preNode = null;
        // 向让快指针走n-1步
        for (int i = 0; i < n - 1; i++) {
            quickIndexListNode = quickIndexListNode.next;
        }
        // 遍历链表，直到快指针到达尾节点
        while (quickIndexListNode != null && quickIndexListNode.next != null) {
            // 移动指针
            preNode = slowIndeListNode;
            slowIndeListNode = slowIndeListNode.next;
            quickIndexListNode = quickIndexListNode.next;
        }
        // 此时的慢指针就是要删除的节点
        // 那么将当前节点的值改为下一节点的值，然后删除下一个节点
        ListNode removeNode = slowIndeListNode;
        // 考虑特殊值，比如说倒数第一个节点，那么此时快慢指针是相同的
        // 此时没有后继节点
        if (removeNode.next == null) {
            // 那么就是删除慢指针节点
            preNode.next = null;
        } else {
            removeNode.val = removeNode.next.val;
            removeNode.next = removeNode.next.next;
        }
        // 返回头节点
        return head;
    }
}
