package leetcode.part15;

/*
*	leetCode算法刷题记录   笔记147
*	@author  zaichiyikoua
*	@time  2020年4月6日
*	@title  { 返回倒数第K个节点lcci }
*/

//实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
//注意：本题相对原题稍作改动
//示例：
//输入： 1->2->3->4->5 和 k = 2
//输出： 4
//说明：
//给定的 k 保证是有效的。
public class KthNodeFromEndOfListlcci {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 滑动窗口解决
    public int kthToLast(ListNode head, int k) {
        if (head == null) {
            return -1;
        }
        // 双指针初始化
        ListNode startNode = head;
        ListNode endNode = head;
        // 滑动窗口的间距
        for (int i = 0; i < k; i++) {
            endNode = endNode.next;
        }
        while (endNode != null) {
            startNode = startNode.next;
            endNode = endNode.next;
        }
        // 滑动窗口到达链表尾部，返回慢指针指向的节点
        return startNode.val;
    }
}
