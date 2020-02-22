package leetcode.part8;

/*
*	leetCode算法刷题记录   笔记79
*	@author  zaichiyikoua
*	@time  2020年2月22日
*	@title  { 旋转链表 }
*/

//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
//示例 1:
//输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
//示例 2:
//输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL
public class RotateList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 将整个链表连接成环，然后在合适的位置断开，确定新的头节点和尾节点
    // 新的链表头在哪里？
    // 在位置 n-k 处，其中 n 是链表中点的个数，新的链表尾就在头的前面，位于位置 n-k-1。
    public ListNode solution(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        // 旧链表的指针
        ListNode oldIndex = head;
        // 计数器初始化，也就是节点的个数
        int count = 1;
        while (oldIndex.next != null) {
            oldIndex = oldIndex.next;
            count++;
        }
        // 尾节点连接头节点形成环
        oldIndex.next = head;
        // 找到新的尾节点节点 (n - k % n - 1)
        ListNode newTail = head;
        for (int i = 0; i < count - k % count - 1; i++) {
            newTail = newTail.next;
        }
        // 找到新的头节点(n - k % n)
        ListNode newHead = newTail.next;
        // 断开环
        newTail.next = null;
        return newHead;

    }
}
