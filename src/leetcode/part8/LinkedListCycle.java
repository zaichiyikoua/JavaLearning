package leetcode.part8;

/*
*	leetCode算法刷题记录   笔记73
*	@author  zaichiyikoua
*	@time  2020年2月19日
*	@title  { 环形链表 }
*/

//给定一个链表，判断链表中是否有环。
//为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
//示例 1：
//输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
//示例 2：
//输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
//示例 3：
//输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
public class LinkedListCycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 经典链表题目
    // 快慢指针法，只要链表中存在环，像一个跑道一样，那么快指针必定会追上慢指针
    public boolean solution(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        // 快慢指针初始化
        ListNode slowIndex = head;
        ListNode quickIndex = head.next;
        // 结束条件为快指针追上慢指针
        while (slowIndex != quickIndex) {
            // 如果不存在环的话，那么快指针移动到链表的尾节点就结束了，这里就不需要考虑慢指针了
            // 因为必定快指针先到链表尾节点
            if (quickIndex == null || quickIndex.next == null) {
                return false;
            }
            // 每次慢指针移动一格，快指针移动两格
            slowIndex = slowIndex.next;
            quickIndex = quickIndex.next.next;
        }
        return true;
    }
}
