package leetcode.part12;

/*
*	leetCode算法刷题记录   笔记120
*	@author  zaichiyikoua
*	@time  2020年3月4日
*	@title  { 删除排序链表中的重复元素 }
*/

//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
//示例 1:
//输入: 1->1->2
//输出: 1->2
//示例 2:
//输入: 1->1->2->3->3
//输出: 1->2->3
public class RemoveDuplicatesFromSortedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 双指针。好好利用排序链表的特点
    public ListNode solution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 双指针初始化
        ListNode slowNode = head;
        ListNode quickNode = head.next;
        while (quickNode != null) {
            // 找到快慢指针指向节点的值不同的时候
            if (slowNode.val != quickNode.val) {
                // 此时删除
                slowNode.next = quickNode;
                // 移动指针
                slowNode = quickNode;
            }
            quickNode = quickNode.next;
        }
        // 最后的值，没有找到不同的值，说明现在的slow指针到quick指针之间都是相同的
        // 删除重复的值
        slowNode.next = null;
        return head;
    }
}
