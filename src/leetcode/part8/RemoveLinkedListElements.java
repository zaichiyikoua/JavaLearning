package leetcode.part8;

/*
*	leetCode算法刷题记录   笔记77
*	@author  zaichiyikoua
*	@time  2020年2月22日
*	@title  { 移除链表元素 }
*/

//删除链表中等于给定值 val 的所有节点。
//示例:
//输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
public class RemoveLinkedListElements {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 遍历链表删除值即可
    public ListNode solution(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        // 指针
        ListNode preNode = null;
        ListNode currentNode = head;
        while (currentNode != null) {
            // 判断是否为val
            if (currentNode.val != val) {
                preNode = currentNode;
                currentNode = currentNode.next;
            } else {
                // 特殊值，如果要删除节点就是头节点
                if (preNode == null) {
                    currentNode = currentNode.next;
                    head = currentNode;
                } else {
                    // 删除节点
                    preNode.next = currentNode.next;
                    currentNode = currentNode.next;
                }
            }
        }
        return head;
    }
}
