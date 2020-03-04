package leetcode.part13;

/*
*	leetCode算法刷题记录   笔记121
*	@author  zaichiyikoua
*	@time  2020年3月4日
*	@title  { 删除排序链表中的重复元素ll }
*/

//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
//示例 1:
//输入: 1->2->3->3->4->4->5
//输出: 1->2->5
//示例 2:
//输入: 1->1->1->2->3
//输出: 2->3
public class RemoveDuplicatesFromSortedListll {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 排序数组，只保留没有重复的节点
    public ListNode solution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 示例二告诉我们需要一个头节点的前驱节点
        ListNode resHead = new ListNode(Integer.MAX_VALUE);
        resHead.next = head;
        // 指针
        ListNode slowNode = resHead;
        ListNode quickNode = resHead.next;
        while (quickNode != null) {
            // 排序数组 连续重复的
            while (quickNode.next != null && quickNode.val == quickNode.next.val) {
                quickNode = quickNode.next;
            }
            // 特殊情况
            if (slowNode.next == quickNode) {
                slowNode = slowNode.next;
            } else {
                // 通常情况
                // 删除节点，移动指针
                slowNode.next = quickNode.next;
                quickNode = quickNode.next;
            }
        }
        return resHead.next;
    }
}
