package leetcode.part2;

import java.util.ArrayList;
import java.util.Collections;

/*
*	leetCode算法刷题记录   笔记18
*	@author  zaichiyikoua
*	@time  2020年2月6日
*	@title  { 排序链表 }
*/

//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
//示例 1:
//输入: 4->2->1->3
//输出: 1->2->3->4
//示例 2:
//输入: -1->5->3->4->0
//输出: -1->0->3->4->5
public class SortList {
    // 思路，最直接的 先遍历链表，将每个节点的值放进集合中
    // 然后对集合中的值进行排序，再遍历集合生成新的链表，返回头节点
    // 但是效果好像不是特别好，这样比较慢
    public ListNode solution(ListNode head) {
        if (head == null) {
            return null;
        }
        // 遍历链表，放进集合
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        // 对值进行排序
        Collections.sort(list);
        // 生成新的链表头节点
        ListNode root = new ListNode(list.get(0));
        // 指针初始化
        ListNode indexNode = root;
        // 遍历集合生成新的链表，注意起始
        for (int i = 1; i < list.size(); i++) {
            indexNode.next = new ListNode(list.get(i));
            indexNode = indexNode.next;
        }
        return root;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
