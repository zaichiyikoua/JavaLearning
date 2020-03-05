package leetcode.part13;

/*
*	leetCode算法刷题记录   笔记126
*	@author  zaichiyikoua
*	@time  2020年3月5日
*	@title  { 环形链表ll }
*/

//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
//为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
//说明：不允许修改给定的链表。
//示例 1：
//输入：head = [3,2,0,-4], pos = 1
//输出：tail connects to node index 1
//解释：链表中有一个环，其尾部连接到第二个节点。
//示例 2：
//输入：head = [1,2], pos = 0
//输出：tail connects to node index 0
//解释：链表中有一个环，其尾部连接到第一个节点。
//示例 3：
//输入：head = [1], pos = -1
//输出：no cycle
//解释：链表中没有环。
public class LinkedListCyclell {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode solution(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        // 先判断有没有环
        ListNode slowIndexNode = head;
        ListNode quickIndexNode = head;
        boolean isCycle = false;
        while (quickIndexNode != null && quickIndexNode.next != null) {
            slowIndexNode = slowIndexNode.next;
            quickIndexNode = quickIndexNode.next.next;
            if (slowIndexNode == quickIndexNode) {
                isCycle = true;
                break;
            }
        }
        // 存在环，则找到环的入口
        if (isCycle) {
            // 其实画个图就很清楚了
            // 1.第一次相遇，slow = nb
            // 2.a+nb = 入口点
            // 3.slow再走a = 入口 = head走到入口 = a
            // 4.由3得出，起始距离入口 = 第一次相遇位置 + a
            quickIndexNode = head;
            while (quickIndexNode != slowIndexNode) {
                quickIndexNode = quickIndexNode.next;
                slowIndexNode = slowIndexNode.next;
            }
            return slowIndexNode;
        }
        return null;
    }
}
