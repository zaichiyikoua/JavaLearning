package leetcode.part11;

/*
*	leetCode算法刷题记录   笔记101
*	@author  zaichiyikoua
*	@time  2020年2月27日
*	@title  { 两两交换链表中的节点 }
*/

//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//示例:
//给定 1->2->3->4, 你应该返回 2->1->4->3.
public class SwapNodesInPairs {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode solution(ListNode head) {
        // 递归三步
        // 找结束条件 找到尾节点的时候终止
        if (head == null || head.next == null) {
            return head;
        }
        // 单次的过程
        ListNode nextNode = head.next;
        head.next = solution(nextNode.next);
        nextNode.next = head;
        // 找到返回值
        return nextNode;
    }
}
