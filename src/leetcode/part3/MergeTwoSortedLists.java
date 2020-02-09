package leetcode.part3;

/*
*	leetCode算法刷题记录   笔记28
*	@author  zaichiyikoua
*	@time  2020年2月9日
*	@title  { 合并两个有序链表 }
*/

//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//示例：
//输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
public class MergeTwoSortedLists {
    // 递归思路
    public ListNode solution(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 合并后的新节点
        ListNode mergedNodeList = null;
        // 要返回的链表也是有序的
        if (l1.val < l2.val) {
            mergedNodeList = l1;
            mergedNodeList.next = solution(l1.next, l2);
        } else {
            mergedNodeList = l2;
            mergedNodeList.next = solution(l1, l2.next);
        }
        return mergedNodeList;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
